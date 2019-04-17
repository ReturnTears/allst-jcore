package com.allst.jcore.i18n;

import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 国际化-page252
 * @author June
 * @date 2018/04/17
 */
public class PracI18n {

    public static void main(String[] args) {
        stI18n();
    }

    private static void stI18n() {
        Locale german = new Locale("de");
        Locale ch = new Locale("zh", "CN");
        Locale germanSwitzerland = new Locale("de", "CH");
        System.out.println(germanSwitzerland.getDisplayName(Locale.GERMAN));
        System.out.println(ch.getDisplayName(Locale.CHINA));
        // Java SE7开始 Java支持IETF BCP 47语言标签
        // 调用从语言标签中创建Locale
        Locale chineseTraditionalCharactersHongKong = Locale.forLanguageTag("zh-Hant-HK");
        // 除了构建一个Locale或使用预定义的Locale外，还可以有两种方法来获得一个Locale对象
        Locale def = Locale.getDefault();
        // 对于所有依赖Locale的类，可以返回一个他们所支持的Locale数组，下面示例：将返回所有DateFormat类所能处理的Locale
        Locale[] locales = DateFormat.getAvailableLocales();
        for (Locale locale : locales) {
            // System.out.println(locale.getDisplayName()+"-"+locale.getLanguage()+"-"+locale.getCountry())
            // System.out.println(locale.toString())
        }

        Locale loc = new Locale("de", "DE");
        NumberFormat format = NumberFormat.getCurrencyInstance(loc);
        double art = 123456.78;
        String res = format.format(art);
        System.out.println(res);

        TextField inputField = null;
        NumberFormat fmt = NumberFormat.getNumberInstance();
        try {
            inputField = new TextField();
            inputField.setText("123,456.78 $");
            Number input = fmt.parse(inputField.getText().trim());
            double d = input.doubleValue();
            Number n = input.doubleValue();

            System.out.println("123,456.78 $ parse解析的值："+d+"\n不关心两者的差异解析的值："+n);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
