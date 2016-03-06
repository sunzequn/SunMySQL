package com.sunzequn.sunmysql.utils;

/**
 * Created by Sloriac on 15/11/16.
 *
 * The util class for handling strings.
 */
public class StringUtil {

    /**
     * Determine whether the string is empty.
     * @param string The string which needs determining.
     * @return true if the string is empty otherwise false.
     */
    public static boolean isEmpty(String string){
        return (string == null || string.length() == 0);
    }

    /**
     * Determine whether the string is not empty.
     * @param string The string which needs determining.
     * @return true if the string is not empty otherwise false.
     */
    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
