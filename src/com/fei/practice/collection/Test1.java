package com.fei.practice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组和集合的转换
 */
public class Test1 {

    public static void main(String[] args) {
        //创建数组
        int[] array = {1, 4, 2, 5, 3, 8};

        //转换成集合
        Arrays.asList(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //创建集合
        List list = new ArrayList();  //ArrayList 以数组为数据结构的集合  有序的可重复的
        list.add(2);
        list.add("a");

        //转换成数组
        list.toArray();

        System.out.println(list.toString());
    }

}
