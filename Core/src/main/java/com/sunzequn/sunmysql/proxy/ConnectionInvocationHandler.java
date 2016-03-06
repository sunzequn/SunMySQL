package com.sunzequn.sunmysql.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Sloriac on 15/11/16.
 * <p>
 * Create a proxy implementation of the java.sql.Connection.
 */
public class ConnectionInvocationHandler implements InvocationHandler {

    /**
     * The object which needs a proxy.
     * In this class, it is a connection.
     */
    private Connection proxy;
    /**
     * The pool of connections.
     */
    private LinkedList<Connection> connections;

    /**
     * Constructor for ConnectionInvocationHandler that takes a Connection and a LinkedList<Connection> to use.
     *
     * @param proxy       The connection which needs a proxy.
     * @param connections The pool from which we retrieve connections.
     */
    public ConnectionInvocationHandler(Connection proxy, LinkedList<Connection> connections) {
        this.proxy = proxy;
        this.connections = connections;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //When calling the method "connection.close()", put the connection back to the pool.
        if (method.getName().equals("close")) {
            connections.push((Connection) this.proxy);
            return null;
        }
        return method.invoke(this.proxy, args);
    }
}
