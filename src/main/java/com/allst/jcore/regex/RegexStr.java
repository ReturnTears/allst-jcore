package com.allst.jcore.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hutu
 * @since 2023-02-20 下午 03:31
 */
public class RegexStr {
    public static void main(String[] args) {
        String str = "select count(1)   as totalCount, sum  (case when c_check_busi_code is null or c_check_busi_code = '' then 1 else 0 end) as errorCount,   {group} from dgs.t_dq_check_rule_busi where 1  = 1 and {cond} = {value} group by {group}";
        // ^,*.{group}$

        String pattern = "\\w+\\{group}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("result :" + m.matches());

        String replaceAll = str.replaceAll("\\s+", " ");
        System.out.println("replaceAll : " + replaceAll);

        boolean contains = StringUtils.contains(replaceAll, ", {group}");
        System.out.println("contains : " + contains);

        String replace = StringUtils.replace(replaceAll, ", {group}", "");
        System.out.println("replace : " + replace);
    }
}
