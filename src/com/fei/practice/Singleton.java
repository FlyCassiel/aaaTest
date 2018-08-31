package com.fei.practice;

import java.io.Serializable;

/**
 * 单例模型
 */
public class Singleton implements Serializable {
    /**
     * 饿汉式
     */
    /**
     * 私有的构造方法，使之不能new多个对象
     */
    private Singleton() {
    }

    /**
     * 静态的成员变量 ，构造方法是私有的，静态的可以保证在初始化这个类的时候对象就存在
     */
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }

}
