package com.sunzequn.sunmysql.annotations.mapper;

/**
 * Created by Sloriac on 15/11/18.
 *
 * The wrapper class for a property of a entity (a column of a table).
 */
public class PropertyWrapper {

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
    private String value;

    public PropertyWrapper() {
    }

    public PropertyWrapper(String property, String column, String value) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
