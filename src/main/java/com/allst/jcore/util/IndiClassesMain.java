package com.allst.jcore.util;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Hutu
 * @since 2023-03-26 下午 08:25
 */
public class IndiClassesMain {

    private static Map<String, IndiClassesPo> existMaps;
    private static Map<String, IndiClassesPo> inputMaps = Maps.newHashMap();
    private static int count = 100;

    public static void main(String[] args) {
        // 模拟已存在的数据
        List<IndiClassesPo> existLists = existPo();
        existMaps = existLists.stream().collect(Collectors.toMap(IndiClassesPo::getClassesName, x -> x, (key1, key2) -> key2)); // Function.identity()
        // System.out.println(existMaps.get("classes-1").toString());

        // 模拟导入的数据
        List<IndiClassesPo> importLists = importPo();

        List<IndiClassesPo> result = Lists.newArrayList();
        StringBuilder sb = new StringBuilder();
        for (IndiClassesPo po : importLists) {
            String msg = valid(po);
            if (StringUtils.isNotEmpty(msg)) {
                sb.append(msg).append(",");
                continue;
            }
            // 新增的父节点,默认将子节点都增加到当前节点下
            String parentName = po.getParentName();
            if (StringUtils.isEmpty(parentName) && existMaps.containsKey(parentName)) {
                po.setParentId(existMaps.get(parentName).getClassesId());
            }
            result.add(po);
        }
        System.out.println(sb.toString());
        System.out.println("result : " + result);
    }

    private static String valid(IndiClassesPo po) {
        po.setClassesId(++count + "");
        String classesName = po.getClassesName();
        if (StringUtils.isEmpty(classesName)) {
            return String.format("classesName [%s] is null", classesName);
        }
        String parentName = po.getParentName();
        // 父节点不为空
        if (StringUtils.isNotEmpty(parentName)) {
            // 已存在的分类中不存在当前分类
            if (!existMaps.containsKey(parentName)) {
                // 新增的分类中也不存在
                if ((inputMaps.size() > 0 && !inputMaps.containsKey(parentName))) {
                    return String.format("parentName [%s] is not exist", parentName);
                } else { // 新增的分类中存在
                    IndiClassesPo existing = inputMaps.get(parentName);
                    int level = Integer.parseInt(existing.getClassesLevel()) + 1;
                    // 新增的分类层级不应该大于5
                    if (level > 5) {
                        return String.format("[%s] not can add", classesName);
                    }
                    po.setClassesLevel(level + "");
                    po.setParentId(existing.getClassesId());
                    inputMaps.put(classesName, po);
                }
            }
            // 已存在的分类中存在当前分类
            if (existMaps.containsKey(parentName)) {
                // 新增的分类中存在则使用新增的分组， 不存在则使用已存在的分类
                IndiClassesPo existing = ObjectUtil.isNotNull(inputMaps.get(parentName)) ? inputMaps.get(parentName) : existMaps.get(parentName);
                po.setParentId(existing.getClassesId());
                int level = Integer.parseInt(existing.getClassesLevel()) + 1;
                // 新增的分类层级不应该大于5
                if (level > 5) {
                    return String.format("[%s] not can add", classesName);
                }
                po.setClassesLevel(level + "");
                inputMaps.put(classesName, po);
            }
        } else {
            po.setParentId("00");
            po.setClassesLevel("1");
            inputMaps = Maps.newHashMap();
            inputMaps.put(classesName, po);
        }

        return null;
    }

    private static List<IndiClassesPo> existPo() {
        List<IndiClassesPo> pos = Lists.newArrayList();
        IndiClassesPo po = IndiClassesPo.of("1", "classes-1", "1", "00");
        IndiClassesPo po11 = IndiClassesPo.of("11", "classes-11", "2", "1");
        IndiClassesPo po12 = IndiClassesPo.of("12", "classes-12", "2", "1");
        IndiClassesPo po13 = IndiClassesPo.of("13", "classes-13", "2", "1");
        pos.add(po);
        pos.add(po11);
        pos.add(po12);
        pos.add(po13);


        return pos;
    }

    private static List<IndiClassesPo> importPo() {
        List<IndiClassesPo> pos = Lists.newArrayList();
        /*IndiClassesPo po = IndiClassesPo.of("", "i-classes-A");
        IndiClassesPo po1 = IndiClassesPo.of("i-classes-A", "classes-11");
        IndiClassesPo po2 = IndiClassesPo.of("classes-11", "i-classes-B1");
        IndiClassesPo po3 = IndiClassesPo.of("i-classes-B1", "i-classes-C1");*/
        IndiClassesPo po = IndiClassesPo.of("classes-1", "i-classes-A");
        IndiClassesPo po1 = IndiClassesPo.of("i-classes-A", "classes-11");
        IndiClassesPo po2 = IndiClassesPo.of("classes-11", "i-classes-B1");
        IndiClassesPo po3 = IndiClassesPo.of("i-classes-B1", "i-classes-C1");
        IndiClassesPo po4 = IndiClassesPo.of("i-classes-C1", "i-classes-D1");
        pos.add(po);
        pos.add(po1);
        pos.add(po2);
        pos.add(po3);
        pos.add(po4);

        return pos;
    }
}
