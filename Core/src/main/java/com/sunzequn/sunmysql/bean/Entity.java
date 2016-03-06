package com.sunzequn.sunmysql.bean;

import java.util.List;

/**
 * Created by Sloriac on 15/11/18.
 *
 * The wrapper class for a entity (table).
 */
public class Entity {

    /**
     * The name of the table corresponding to the entity.
     */
    private String table;
    /**
     * The mapping relation between the properties of a entity
     * and the columns of it`s corresponding table.
     */
    private List<Property> propertyList;

    public Entity() {
    }

    public Entity(String table, List<Property> propertyList) {
        this.table = table;
        this.propertyList = propertyList;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}
