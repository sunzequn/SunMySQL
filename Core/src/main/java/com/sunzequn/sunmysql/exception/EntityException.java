package com.sunzequn.sunmysql.exception;

/**
 * Created by Sloriac on 15/11/20.
 *
 * Handle exceptions of entities.
 */
public class EntityException extends Exception {

    public EntityException() {
        super();
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }
}
