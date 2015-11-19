package com.sunzequn.sunmysql.exception;

import java.io.IOException;

/**
 * Created by Sloriac on 15/11/16.
 *
 * Handle exceptions of config files.
 */
public class ConfigException extends IOException {

    public ConfigException() {
        super();
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}
