package com.general.customexception;

/**
 * Created by dhanetwa on 6/20/2018.
 */
public class TestException {

    static void checkValidAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is lower then 18yrs!!");
        }
    }

    public static void main(String[] args) {
        try {
            checkValidAge(17);
        } catch (InvalidAgeException e) {
            e.printStackTrace();
        }
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String s) {
        super(s);
    }
}
