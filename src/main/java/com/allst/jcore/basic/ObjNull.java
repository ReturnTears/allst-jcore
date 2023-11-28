package com.allst.jcore.basic;

import com.allst.jcore.bean.User;

import java.util.List;

/**
 * @author Hutu
 * @since 2023-11-17 上午 10:46
 */
public class ObjNull {
    public static void main(String[] args) {
        List<User> users = null;
        for (int i = 0; users != null && i < users.size(); ++i) {
            User user = users.get(i);
        }
    }
}
