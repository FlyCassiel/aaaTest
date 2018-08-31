package com.fei.practice.linkedlist;

/**
 * 编写一个Node类来充当结点的模型,两个属性
 * 1.存放数据的data
 * 2.存放下一节点的引用
 */
public class Node {
    //为了方便，这两个变量都设置为public，而不是private，不需要提供get，set方法
    //存放数据的变量
    public Object data;
    //存放结点的变量
    public Node next;

    //构造方法，
    public Node(Object data) {
        this.data = data;
    }
}
