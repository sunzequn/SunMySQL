package com.sunzequn.sunmysql.query;


import com.sunzequn.sunmysql.connection.DataSourcePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Sloriac on 15/11/20.
 */
public abstract class AbstractOperation {

    private DataSourcePool dataSourcePool = DataSourcePool.instance();

    /**
     * Factory method that retrieves a connection from its DataSource.
     *
     * @return An initialized Connection.
     * @throws SQLException if a database access error occurs
     */
    protected Connection prepareConnection() throws SQLException {
        return dataSourcePool.getConnection();
    }

    /**
     * Factory method that creates and initializes a PreparedStatement object for the given SQL.
     *
     * @param connection The Connection used to create the PreparedStatement.
     * @param sql        The SQL statement to prepare.
     * @return An initialized PreparedStatement.
     * @throws SQLException if a database access error occurs
     */
    protected PreparedStatement prepareStatement(Connection connection, String sql)
            throws SQLException {

        return connection.prepareStatement(sql);
    }
}
