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

    /**
     * The number of connections in the data source pool, whose default value is 10.
     */
    private static int initialPoolSize = 10;
    private static String jdbcUrl = null;
    private static String user = null;
    private static String password = null;
    private static Connection connection = null;


    /**
     * Constructor for DataSource.
     * It is also initialize a connection of MySQL.
     */
    public DataSource() {
        try {
            Class.forName(MYSQL_CLASS_NAME);
            initValue();
            connection = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize values of parameters.
     */
    public void initValue() {
        jdbcUrl = PropertiesUtil.getValue("jdbcUrl");
        checkParameter("jdbcUrl", jdbcUrl);
        user = PropertiesUtil.getValue("user");
        checkParameter("user", user);
        password = PropertiesUtil.getValue("password");
        checkParameter("password", password);
        String size = PropertiesUtil.getValue("initialPoolSize");
        if (StringUtil.isNotEmpty(size)) {
            initialPoolSize = Integer.valueOf(size);
        }
    }

    /**
     * Determine whether the parameter is defined in the file config.properties.
     *
     * @param parameter The parameter which needs checking.
     */
    public void checkParameter(String parameter, String value) {
        if (StringUtil.isEmpty(value)) {
            try {
                throw new ConfigException("The parameter:" + parameter + " is not defined.");
            } catch (ConfigException e) {
                e.printStackTrace();
            }
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

    /**
     * The getter method of initialPoolSize.
     *
     * @return the value of initialPoolSize
     */
    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    @Override
    public String toString() {
        return "initialPoolSize:" + initialPoolSize + " jdbcUrl:" + jdbcUrl + " user:" + user + " password:" + password;
    }
}
