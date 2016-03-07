package com.sunzequn.sunmysql.connection;

import com.sunzequn.sunmysql.proxy.ConnectionInvocationHandler;
import com.sunzequn.sunmysql.proxy.ProxyFactory;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by Sloriac on 15/11/16.
 *
 * The implementation of the interface javax.sql.DataSource.
 * This class is thread safe.
 */
public class DataSourcePool implements javax.sql.DataSource {

    /**
     * The Singleton instance of this class.
     */
    private static final DataSourcePool instance = new DataSourcePool();
    /**
     * The data source of MySQL.
     */
    private DataSource dataSource;
    /**
     * The pool of connections.
     */
    private LinkedList<Connection> connections;

    /**
     * Returns the Singleton instance of this class.
     * @return singleton instance
     */
    public static DataSourcePool instance() {
        return instance;
    }

    /**
     * Constructor for creating the Singleton instance of this class.
     */
    private DataSourcePool() {
        super();
        dataSource = new DataSource();
        connections = new LinkedList<>();
        for (int i = 0; i < Configuration.initialPoolSize; i++) {
            connections.add(new DataSource().getConnection());
        }

    }

    /**
     * Get the proxy of a connection in the pool.
     * @return the proxy of a connection if the pool is not empty otherwise null;
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (connections.size() > 0) {
            final Connection connection = connections.pop();
            ConnectionInvocationHandler connHandler = new ConnectionInvocationHandler(connection, connections);
            return ProxyFactory.instance().createConnection(connHandler);
        } else {
            throw new SQLException("No connection left.");
        }

    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
