package com.allst.jcore.basic;

/**
 * @author June 2019/02/15 上午 11:56
 * @version 1.0
 */
public class RealizeAbsUser extends AbstractUser implements InterfaceUser {

    public RealizeAbsUser(String username, String password) {
        super(username, password);
    }

    public static void main(String... args) {
        RealizeAbsUser user = new RealizeAbsUser("Kang", "123-321");
        System.out.println(user.username);
        InterfaceUser interfaceUser = new RealizeAbsUser("KangKang", "123-321");
        interfaceUser.delUser();
        System.out.println(InterfaceUser.age);
        System.out.println(InterfaceUser.name);
        AbstractUser abstractUser = new RealizeAbsUser("KangKangKang", "123-321");
        abstractUser.putUser();
    }

    @Override
    public void putUser() {
        System.out.println("RealizeAbsUser class`s  putUser methods......");
    }

    /**
     * del user 抽象方法
     */
    @Override
    public void delUser() {
        System.out.println("RealizeAbsUser class`s  delUser methods......");
    }
}
