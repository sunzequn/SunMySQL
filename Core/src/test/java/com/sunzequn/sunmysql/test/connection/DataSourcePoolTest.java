package com.sunzequn.sunmysql.test.connection;

import com.sunzequn.sunmysql.connection.DataSourcePool;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Sloriac on 15/11/16.
 */
public class DataSourcePoolTest {

    @Test
    public void connectionTest(){

        DataSourcePool dataSourcePool = new DataSourcePool();

        try {
            Connection connection = dataSourcePool.instance().getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
