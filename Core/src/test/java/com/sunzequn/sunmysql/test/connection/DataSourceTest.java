package com.sunzequn.sunmysql.test.connection;

import com.sunzequn.sunmysql.connection.DataSource;
import org.junit.Test;

/**
 * Created by Sloriac on 15/11/16.
 */
public class DataSourceTest {

    @Test
    public void constructorTest(){
        DataSource dataSource = new DataSource();
        System.out.println(dataSource);
    }

}