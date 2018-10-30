package com.spring.service;

import com.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dhanetwa on 9/29/2018.
 */

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    private String data;

    public String getData() {
        return "stuent name is: " + studentDao.getName();
    }
}
