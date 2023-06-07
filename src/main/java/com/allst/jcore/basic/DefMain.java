package com.allst.jcore.basic;

import com.allst.jcore.entity.User;

/**
 * @author Hutu
 * @since 2023-06-07 下午 10:58
 */
public class DefMain {
    public static void main(String[] args) {
        AbstractDefUser defUser = new ImplDefUser();
        User user = new User();
        defUser.exec(user);

        InterfaceDefUser interfaceDefUser = new ImplDefUser();
        user.setName("Hu");
        user.setAge(22);
        interfaceDefUser.doUser(user);
    }
}
