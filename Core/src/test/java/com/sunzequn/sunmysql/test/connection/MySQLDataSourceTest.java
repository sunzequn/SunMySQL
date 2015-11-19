package com.sunzequn.sunmysql.test.connection;

import com.sunzequn.sunmysql.connection.MySQLDataSource;
import org.junit.Test;

/**
 * Created by Sloriac on 15/11/16.
 */
public class MySQLDataSourceTest {

    @Test
    public void constructorTest(){
        MySQLDataSource dataSource = new MySQLDataSource();
        System.out.println(dataSource);
    }

}