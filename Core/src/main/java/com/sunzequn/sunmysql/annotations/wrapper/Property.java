package com.sunzequn.sunmysql.annotations.wrapper;

/**
 * Created by Sloriac on 15/11/18.
 *
 * The wrapper class for a property of a entity (a column of a table).
 */
public class Property {

    /**
     * The name of a property.
     */
    private String property;
    /**
     * The name of the column corresponding to the property above.
     */
    private String column;
    /**
     * The value of the property.
     */
    private Object value;

    public Property() {
    }

    public Property(String property, String column, Object value) {
        this.property = property;
        this.column = column;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
