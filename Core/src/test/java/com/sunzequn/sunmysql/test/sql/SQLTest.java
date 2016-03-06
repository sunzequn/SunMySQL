package com.sunzequn.sunmysql.test.sql;

import com.sunzequn.sunmysql.annotations.Mapping;
import com.sunzequn.sunmysql.bean.Entity;
import com.sunzequn.sunmysql.sql.InsertParser;
import com.sunzequn.sunmysql.sql.Parser;
import com.sunzequn.sunmysql.test.annotations.Person;
import org.junit.Test;

/**
 * Created by Sloriac on 15/11/20.
 */
public class SQLTest {

    @Test
    public void insertTest() {
        Person person = new Person("sunzequn", 22);
        Mapping<Person> mapping = new Mapping<>();
        Entity entity = mapping.mapping(person);

        Parser resolver = new InsertParser();

        System.out.println(resolver.excute(entity));

    }
}
