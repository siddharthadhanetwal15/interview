package com.StringAlgorithms;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by dhanetwa on 9/6/2018.
 */
public class Test {
    void m1(String str, Date date) {
        System.out.println(str);
    }

    void m2(String str, Timestamp ts) {
        System.out.println(str);
    }

    void exceptionCheck() throws Exception {
        try {
            throw new Exception("try");
        } catch (Exception e) {
            throw new Exception("catch");
        } finally {
            throw new Exception("finally");
        }
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Date date = null;
        t1.m1("m1", date);
        t1.m2("m2", null);


        try {
            t1.exceptionCheck();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}