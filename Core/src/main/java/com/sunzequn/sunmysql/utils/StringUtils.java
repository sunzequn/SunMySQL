package com.sunzequn.sunmysql.utils;

/**
 * Created by Sloriac on 15/11/16.
 *
 * The util class for handling strings.
 */
public class StringUtils {

    public static boolean isEmpty(String string){
        return (string == null || string.length() == 0);
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
