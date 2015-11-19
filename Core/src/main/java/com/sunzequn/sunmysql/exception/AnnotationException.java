package com.sunzequn.sunmysql.exception;

/**
 * Created by Sloriac on 15/11/18.
 *
 * Handle exceptions of annotations.
 */
public class AnnotationException extends Exception {

    public AnnotationException() {
        super();
    }

    public AnnotationException(String message) {
        super(message);
    }

    public AnnotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnnotationException(Throwable cause) {
        super(cause);
    }
}
