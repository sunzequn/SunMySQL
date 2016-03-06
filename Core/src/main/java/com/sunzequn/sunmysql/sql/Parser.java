package com.sunzequn.sunmysql.sql;

import com.sunzequn.sunmysql.bean.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Sloriac on 15/11/18.
 */
public interface Parser {

    public PreparedStatement parse(Connection connection, Entity entity);
}
