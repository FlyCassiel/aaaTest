package com.fei.practice.linkedlist;

/**
 * 单链表的简单操作(增加，删除，获取总长度，链表元素排序，链表遍历)　　
 */
public class Test01 {
    /**
     * 初始化头结点,插入删除等操作，以及计算长度都是这个头结点
     */
    public static Node head = new Node(null);

    public Test01() {
        head.next=null;
    }

    /**
     * 计算单链表的长度，也就是有多少个节点
     * @return
     */
    public int length(){
        int length = 0;
        Node temp = head;
        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    /**
     * 增加操作
     *         直接在链表的最后插入新增的结点即可
     *         将原本最后一个结点的next指向新结点
     */
    public void addNode(Object param){
        //创建一个新结点
        Node node = new Node(param);

        //链表中有结点，遍历到最后一个节点
        Node temp = head;   //一个移动的指针（把头结点看做一个指向节点的指针）
        while (temp.next != null){ //遍历单链表，知道遍历到最后一个则跳出循环。
            temp = temp.next;      //往后移动一个节点，指向下一个节点
        }
        temp.next = node;   //temp为最后一个节点是头结点，将其next指向新结点
    }

    /**
     * 插入，删除   head后是数据的第一位   自己定义
     */

    /**
     * insertNodeByIndex:在链表的指定位置插入结点。
     *         插入操作需要知道1个结点即可，当前位置的前一个结点
     * index:插入链表的位置，从1开始
     * node:插入的结点
     */
    public void insertNodeByIndex(int index,Object param){

        /**
         * 新建一个结点
         */
        Node node = new Node(param);

        //首先需要判断指定位置是否合法，
        if(index<1||index>length()+1){
            System.out.println("插入位置不合法。");
            return;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while(head.next != null){//遍历单链表
            if(index == length++){        //判断是否到达指定位置。
                //注意，我们的temp代表的是当前位置的前一个结点。
                //前一个结点        当前位置        后一个结点
                //temp            temp.next     temp.next.next
                //插入操作。
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 通过index删除指定位置的结点,跟指定位置增加结点是一样的，先找到准确位置。然后进行删除操作。
     *             删除操作需要知道1个结点即可：和当前位置的前一个结点。
     * @param index：链表中的位置，从1开始
     *
     */
    public void delNodeByIndex(int index){
        //判断index是否合理
        if(index<1 || index>length()){
            System.out.println("给定的位置不合理");
            return;
        }

        //步骤跟insertNodeByIndex是一样的，只是操作不一样。
        int length=1;
        Node temp = head;
        while(temp.next != null){
            if(index == length++){
                //删除操作。
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

   public void print(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
       System.out.println();
   }


    public static void main(String[] args){
        Test01 test01 = new Test01();
        /**
         * 增加四条数据
         */
        test01.addNode(30);
        test01.addNode(20);
        test01.addNode(10);
        test01.addNode(40);   //30->20->10->40

        test01.print();

        /**
         *插入数据   把数据插入到第1位
         */
        test01.insertNodeByIndex(1,50);  //50->30->20->10->40

        test01.print();

        /**
         * 删除数据  删除第2位数据
         */
        test01.delNodeByIndex(2);   //50->20->10->40

        test01.print();

        System.out.println("");
    }
}

