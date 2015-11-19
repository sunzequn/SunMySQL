package com.sunzequn.sunmysql.test.annotations;

import com.sunzequn.sunmysql.annotations.mapper.Mapping;
import org.junit.Test;

/**
 * Created by Sloriac on 15/11/18.
 */
public class MappingTest {

    @Test
    public void mapping(){
        Person person = new Person();
        Mapping<Person> mapping = new Mapping<>();
        mapping.mapping(person);

    }
}
