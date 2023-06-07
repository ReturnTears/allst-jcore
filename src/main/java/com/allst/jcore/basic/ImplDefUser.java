package com.allst.jcore.basic;

import com.allst.jcore.entity.User;

/**
 * @author Hutu
 * @since 2023-06-07 下午 10:57
 */
public class ImplDefUser extends AbstractDefUser {
    @Override
    protected void exec(User user) {
        System.out.println(user.toString());
    }
}
