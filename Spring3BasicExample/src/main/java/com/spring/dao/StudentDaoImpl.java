package com.spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by dhanetwa on 9/29/2018.
 */

@Repository("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
