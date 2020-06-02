package com.allst.jcore.jvm;

import java.net.URL;

/**
 * @author YiYa
 * @since 2020-06-02 下午 11:11
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        System.out.println("--------------获取启动类加载器可以加载的api路径-------------");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL e : urls) {
            System.out.println(e.toExternalForm());
        }

        System.out.println("--------------获取扩展类加载器可以加载的api路径-------------");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String e : extDirs.split(";")) {
            System.out.println(e);
        }
    }
}
