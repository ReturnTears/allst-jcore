package com.allst.jcore.jv8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YiYa
 * @since 2020-02-04 下午 04:40
 */
public class AllstJv8Func {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        for (int i = 0; i < hiddenFiles.length; i++) {
            System.out.println(hiddenFiles[i].getName());
        }
    }
}
