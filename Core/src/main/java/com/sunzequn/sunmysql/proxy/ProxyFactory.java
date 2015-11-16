package com.sunzequn.sunmysql.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by Sloriac on 15/11/16.
 *
 * Create proxy implementations of JDBC interfaces.
 */
public class ProxyFactory {


    /**
     * The Singleton instance of this class.
     */
    private static final ProxyFactory instance = new ProxyFactory();

    /**
     * Returns the Singleton instance of this class.
     * @return singleton instance
     */
    public static ProxyFactory instance() {
        return instance;
    }

    /**
     * Constructor for ProxyFactory subclasses to use.
     */
    public ProxyFactory() {
        super();
    }

    /**
     * Convenience method to generate a single-interface proxy using the handler's classloader
     *
     * @param <T> The type of object to proxy
     * @param type The type of object to proxy
     * @param handler The handler that intercepts/overrides method calls.
     * @return proxied object
     */
    public <T> T newProxyInstance(Class<T> type, InvocationHandler handler) {
        return type.cast(Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class<?>[] {type}, handler));
    }


    /**
     * Creates a new proxy <code>Connection</code> object.
     * @param handler The handler that intercepts/overrides method calls.
     * @return proxied Connection
     */
    public Connection createConnection(InvocationHandler handler) {
        return newProxyInstance(Connection.class, handler);
    }
}
