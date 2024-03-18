package com.allst.jcore.genericity.demo2;

import java.io.Serializable;

/**
 *
 * 表明T类型必须是Number类或其子类， 并必须实现java.io.Serializable接口
 *
 * @author Hutu
 * @since 2024-03-18 下午 11:10
 */
public class Peer<T extends Number & Serializable> {
}
