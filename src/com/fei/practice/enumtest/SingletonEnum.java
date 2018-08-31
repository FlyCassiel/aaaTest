package com.fei.practice.enumtest;

/**
 * 枚举单例
 * enum有且仅有private的构造器
 */
public enum SingletonEnum {
    INSTANCE;

    public void  otherMethods(){
        System.out.println("Something");
    }
}
