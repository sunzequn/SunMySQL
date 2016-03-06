package com.sunzequn.sunmysql.sql;

import com.sunzequn.sunmysql.annotations.wrapper.Entity;
import com.sunzequn.sunmysql.annotations.wrapper.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by Sloriac on 15/11/18.
 */
public class InsertParser implements Parser {

    @Override
    public PreparedStatement parse(Connection connection, Entity entity) {

        String sql1 = "INSERT INTO " + entity.getTable() + "(";
        String sql2 = "VALUES(";
        List<Property> properties = entity.getPropertyList();
        int end = properties.size() - 1;
        for (Property property : properties) {

            sql1 += property.getColumn();
            sql2 += "'" + property.getValue();
            if (properties.indexOf(property) != end) {
                sql1 += ", ";
                sql2 += "', ";
            } else {
                sql1 += ") ";
                sql2 += "');";
            }

        }
        return null;
    }
}
