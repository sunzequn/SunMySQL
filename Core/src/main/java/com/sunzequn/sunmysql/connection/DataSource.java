package com.sunzequn.sunmysql.connection;

import com.sunzequn.sunmysql.exception.ConfigException;
import com.sunzequn.sunmysql.utils.PropertiesUtil;
import com.sunzequn.sunmysql.utils.StringUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sloriac on 15/11/16.
 * <p>
 * The data source of MySQL, Providing a MySQL connection with the parameters defined in the config file.
 */
public class DataSource {

    /**
     * The driver name of MySQL. It is a default value.
     */
    private static final String MYSQL_CLASS_NAME = "com.mysql.jdbc.Driver";

    private static Connection connection = null;


    /**
     * Constructor for DataSource.
     * It is also initialize a connection of MySQL.
     */
    public DataSource() {
        try {
            Class.forName(MYSQL_CLASS_NAME);
            connection = DriverManager.getConnection(Configuration.jdbcUrl, Configuration.user, Configuration.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a connection of MySQL.
     *
     * @return a connection
     */
    public Connection getConnection() {
        return connection;
    }

}
