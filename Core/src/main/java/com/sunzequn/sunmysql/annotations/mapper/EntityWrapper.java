package com.sunzequn.sunmysql.annotations.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Sloriac on 15/11/18.
 *
 * The wrapper class for a entity (table).
 */
public class EntityWrapper {

    /**
     * The name of the table corresponding to the entity.
     */
    private String table;
    /**
     * The mapping relation between the properties of a entity
     * and the columns of it`s corresponding table.
     */
    private List<PropertyWrapper> propertyWrapperList;

    public EntityWrapper() {
    }

    public EntityWrapper(String table, List<PropertyWrapper> propertyWrapperList) {
        this.table = table;
        this.propertyWrapperList = propertyWrapperList;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<PropertyWrapper> getPropertyWrapperList() {
        return propertyWrapperList;
    }

    public void setPropertyWrapperList(List<PropertyWrapper> propertyWrapperList) {
        this.propertyWrapperList = propertyWrapperList;
    }
}
