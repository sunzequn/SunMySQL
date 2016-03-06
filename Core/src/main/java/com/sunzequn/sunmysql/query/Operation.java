package com.sunzequn.sunmysql.query;

import com.sunzequn.sunmysql.bean.Entity;
import com.sunzequn.sunmysql.sql.Parser;

/**
 * Created by Sloriac on 15/11/20.
 */
public class Operation extends AbstractOperation {

    private Parser parser;

    public Operation(Parser parser) {
        this.parser = parser;
    }

    public <T> T execute(Entity entity) {

        return null;
    }

}
