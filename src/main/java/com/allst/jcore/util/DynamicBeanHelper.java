package com.allst.jcore.util;

import com.google.common.collect.Maps;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 属性动态绑定帮助类
 *
 * @author Hutu
 * @since 2023-09-07 上午 09:07
 */
public class DynamicBeanHelper {
    public static Object getTarget(Object dest, Map<String, Object> properties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class> propertyMap = Maps.newHashMap();
        for (PropertyDescriptor descriptor : descriptors) {
            if (!"class".equals(descriptor.getName())) {
                propertyMap.put(descriptor.getName(), descriptor.getPropertyType());
            }
        }
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            propertyMap.put(entry.getKey(), entry.getValue().getClass());
        }

        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        for (Map.Entry<String, Class> entry : propertyMap.entrySet()) {
            try {
                if (!properties.containsKey(entry.getKey())) {
                    dynamicBean.setValue(entry.getKey(), propertyUtilsBean.getNestedProperty(dest, entry.getKey()));
                }
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        for (Map.Entry<String, Class> entry : propertyMap.entrySet()) {
            dynamicBean.setValue(entry.getKey(), entry.getValue());
        }

        return dynamicBean.getTarget();
    }

    public static class DynamicBean {
        private Object target;
        private BeanMap beanMap;

        public DynamicBean(Class superClass, Map<String,Class> propertiesMap) {
            this.target = generateBean(superClass, propertiesMap);
            this.beanMap = BeanMap.create(this.target);
        }

        public void setValue(String properties, Object value) {
            beanMap.put(properties, value);
        }

        public Object getValue(String properties) {
            return beanMap.get(properties);
        }

        public Object getTarget() {
            return this.target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }

        public BeanMap getBeanMap() {
            return beanMap;
        }

        public void setBeanMap(BeanMap beanMap) {
            this.beanMap = beanMap;
        }

        private Object generateBean(Class superClass, Map<String, Class> propertiesMap) {
            BeanGenerator generator = new BeanGenerator();
            if (null != superClass) {
                generator.setSuperclass(superClass);
            }
            BeanGenerator.addProperties(generator, propertiesMap);
            return generator.create();
        }
    }
}
