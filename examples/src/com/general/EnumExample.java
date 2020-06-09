package com.general;

import java.util.EnumSet;

public enum EnumExample {
    HIGH (3){
        @Override
        public String toLowerCase() {
            return HIGH.toLowerCase();
        }
    },
    MEDIUM (2){
        @Override
        public String toLowerCase() {
            return MEDIUM.toLowerCase();
        }
    },
    LOW (1){
        @Override
        public String toLowerCase() {
            return LOW.toLowerCase();
        }
    };
    private int code;
    private EnumExample(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public abstract String toLowerCase();
}
class UseEnum{
    EnumExample enumExample = EnumExample.HIGH;

    public EnumExample getEnumExample() {
        return enumExample;
    }

    public static void main(String[] args) {
        UseEnum useEnum = new UseEnum();
        System.out.println(useEnum.getEnumExample());
        EnumExample enumExample = EnumExample.LOW;
        switch (enumExample){
            case HIGH:
                System.out.println("high");
                break;
            case LOW:
                System.out.println("low");
                break;
            default:
                System.out.println("no value");
        }
        for(EnumExample enumExample1 : EnumExample.values()){
            System.out.println(enumExample1);
        }
        EnumExample enumExample2 = EnumExample.valueOf("HIGH");
        System.out.println(enumExample2.getCode());

        EnumSet<EnumExample> enumSet = EnumSet.of(EnumExample.HIGH, EnumExample.MEDIUM);

    }
}
