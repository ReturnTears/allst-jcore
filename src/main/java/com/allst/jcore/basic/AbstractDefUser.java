package com.allst.jcore.basic;

import com.allst.jcore.entity.User;

/**
 * @author Hutu
 * @since 2023-06-07 下午 10:48
 */
public abstract class AbstractDefUser implements InterfaceDefUser {
    @Override
    public void doUser(User user) {
        before(user);
        exec(user);
        after(user);
    }

    protected abstract void exec(User user);

    protected void before(User user) {
        user.setName("KangKang");
        System.out.println("AbstractDefUser exec before() : " + user.toString());
    }

    protected void after(User user) {
        user.setAge(18);
        System.out.println("AbstractDefUser exec after() : " + user.toString());
    }
}
