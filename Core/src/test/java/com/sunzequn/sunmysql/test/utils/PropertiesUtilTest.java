package com.sunzequn.sunmysql.test.utils;

import com.sunzequn.sunmysql.utils.PropertiesUtil;
import org.junit.Test;

/**
 * Created by Sloriac on 15/11/15.
 */
public class PropertiesUtilTest {

    @Test
    public void getValueTest(){

        System.out.println(PropertiesUtil.getValue("test"));

    }

}
