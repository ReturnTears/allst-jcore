package com.allst.jcore.bat;

import java.io.IOException;
import java.io.InputStream;

/**
 * Java调用Windows Bat脚本
 * @author June 2018-01-12
 * @version 1.0
 */
public class JavaCallBat {
    public static void main(String[] args) {
        batDecom();
    }

    private static void batDecom() {
        String localCmd = "xxx.bat(bat脚本文件路径)";
        try {
            Process p = Runtime.getRuntime().exec("cmd /c start " + localCmd);
            InputStream in = p.getInputStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.println((char) c);
            }
            in.close();
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("it`s done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
