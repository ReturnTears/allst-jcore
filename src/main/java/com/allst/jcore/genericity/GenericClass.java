package com.allst.jcore.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类：在类定义的类名后加上<泛型参数名>，就定义了一个泛型类，
 * 该泛型参数名的作用域存在于类定义和整个类主体内
 *
 * @author Hutu
 * @since 2023-11-02 下午 11:07
 */
public class GenericClass<T> implements GenericInterface<T> {

    /**
     * 方法类：在方法的返回值之前加上<泛型参数名>，就定义了一个泛型方法，
     * 该泛型参数名的作用域包括方法返回值、方法参数、方法异常以及整个方法主体
     */
    public <K, E extends Exception> K genericMethod() throws E {
        List<K> list = new ArrayList<K>();
        K k = null;
        return null;
    }

}
