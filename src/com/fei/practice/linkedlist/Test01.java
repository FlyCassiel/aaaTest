package com.fei.practice.linkedlist;

/**
 * 单链表的简单操作(增加，删除，获取总长度，链表元素排序，链表遍历)
 */
public class Test01 {
    /**
     * 初始化头结点,插入删除等操作，以及计算长度都是这个头结点
     */
    public static Node head = new Node(null);
    //第二个头结点
    private Node head1 = new Node(null);

    public Test01() {
        head.next = null;
        head1.next = null;
    }

    /**
     * 计算单链表的长度，也就是有多少个节点
     *
     * @return
     */
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 增加操作
     * 直接在链表的最后插入新增的结点即可
     * 将原本最后一个结点的next指向新结点
     */
    public void addNode(Object param) {
        //创建一个新结点
        Node node = new Node(param);

        //链表中有结点，遍历到最后一个节点
        Node temp = head;   //一个移动的指针（把头结点看做一个指向节点的指针）
        while (temp.next != null) { //遍历单链表，知道遍历到最后一个则跳出循环。
            temp = temp.next;      //往后移动一个节点，指向下一个节点
        }
        temp.next = node;   //temp为最后一个节点是头结点，将其next指向新结点
    }

    /**
     * 插入，删除   head后是数据的第一位   自己定义
     */

    /**
     * insertNodeByIndex:在链表的指定位置插入结点。
     * 插入操作需要知道1个结点即可，当前位置的前一个结点
     * index:插入链表的位置，从1开始
     * node:插入的结点
     */
    public void insertNodeByIndex(int index, Object param) {

        /**
         * 新建一个结点
         */
        Node node = new Node(param);

        //首先需要判断指定位置是否合法，
        if (index < 1 || index > length() + 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while (head.next != null) {//遍历单链表
            if (index == length++) {        //判断是否到达指定位置。
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
     * 删除操作需要知道1个结点即可：和当前位置的前一个结点。
     *
     * @param index：链表中的位置，从1开始
     */
    public void delNodeByIndex(int index) {
        //判断index是否合理
        if (index < 1 || index > length()) {
            System.out.println("给定的位置不合理");
            return;
        }

        //步骤跟insertNodeByIndex是一样的，只是操作不一样。
        int length = 1;
        Node temp = head;
        while (temp.next != null) {
            if (index == length++) {
                //删除操作。
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 打印单链表中的数据
     */
    public void print() {
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 对链表中的结点进行选择排序，按照从小到大的顺序，使用选择排序
     */
    public void selectSortNode() {
        //判断链表的长度小于2，否则只有一个数据，无需排序
        if (length() < 2) {
            System.out.println("无需排序");
            return;
        }
        //选择排序
        Node temp = head;
        while (temp.next != null) {
            Node tempTwo = temp.next;
            while (tempTwo.next != null) {
                if (Integer.parseInt(String.valueOf(temp.next.data)) > Integer.parseInt(String.valueOf(tempTwo.next.data))) {
                    Object t = tempTwo.next.data;
                    tempTwo.next.data = temp.next.data;
                    temp.next.data = t;
                }
                tempTwo = tempTwo.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 对链表进行插入排序，按从大到小的顺序，只要这里会写，那么手写用数组插入排序
     * 也是一样的。先要明白原理。什么是插入排序，这样才好写代码。
     * 插入排序：分两组，一组当成有序序列，一组当成无序，
     * 将无序组中的元素与有序组中的元素进行比较(如何比较，那么就要知道插入排序的原理是什么这里不过多阐述)
     * 这里我想到的方法是，构建一个空的链表当成有序序列，而原先的旧链表为无序序列，按照原理，一步步进行编码即可。
     */
    public void insertSort() {
        //判断链表的长度小于2，否则只有一个数据，无需排序
        if (length() < 2) {
            System.out.println("无需排序");
            return;
        }

        //创建新链表
        Node newHead = new Node(null);    //新链表的头结点
        Node newTemp = newHead;        //新链表的移动指针

        Node temp = head;        //旧链表的移动指针
        if (newTemp.next == null) {        //将第一个结点直接放入新链表中。
            newTemp.next = new Node(temp.next.data);
            temp = temp.next;    //旧链表中指针移到下一位(第二个结点处)。
        }

        while (temp.next != null) {     //    遍历现有链表
            while (newTemp.next != null) {
                //先跟新链表中的第一个结点进行比较,如果符合条件则添加到新链表，注意是在第一个位置上增加结点
                //如果不符合，则跟新链表中第二个结点进行比较，如果都不符合，跳出while，判断是否是到了新链表的最后一个结点，如果是则直接在新链表后面添加即可

                if (Integer.parseInt(String.valueOf(newTemp.next.data)) < Integer.parseInt(String.valueOf(temp.next.data))) {
                    Node node = new Node(temp.next.data);
                    node.next = newTemp.next;
                    newTemp.next = node;
                    break;
                }
                newTemp = newTemp.next;
            }
            if (newTemp.next == null) {//到达最末尾还没符合，那么说明该值是新链表中最小的数，直接添加即可到链表中即可
                //直接在新链表后面添加
                Node node = new Node(temp.next.data);
                newTemp.next = node;
            }
            //旧链表指针指向下一位结点，继续重复和新链表中的结点进行比较。
            temp = temp.next;
            //新链表中的移动指针需要复位，指向头结点
            newTemp = newHead;
        }
        //开始使用新链表，旧链表等待垃圾回收机制将其收回。
        head = newHead;

    }

    /**
     * 查找中间节点
     */
    public Node getMiddleNode() {
        if (head.next == null) return head;

        Node temp = head;
        Node target = head;
        while (temp.next != null) {
            target = target.next;
            temp = temp.next.next;
        }
        return target;
    }

    /**
     * 查找倒数第k位上的节点
     *
     * @return
     */
    public Node FindKthToTail(int k) {
        Node p, q;
        p = head;
        q = head;
        int count = 0;
        if (p.next == null) {
            return null;
        }
        while (p.next != null) {
            count++;
            p = p.next;
        }
        if (k > count) {
            return null;
        } else {
            for (int i = 1; i <= count - (k - 1); i++) {
                q = q.next;
            }
        }
        return q;
    }

    /**
     * 合并两个有序单链表     node1    node2
     */
    public static Node mergeSortedList(Node node1, Node node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        Node target = null;
        if (Integer.parseInt(String.valueOf(node1.data)) > Integer.parseInt(String.valueOf(node2.data))) {
            target = node2;
            node2 = node2.next;
        } else {
            target = node1;
            node1 = node1.next;
        }
        target.next = null;
        Node mergeHead = new Node(null);
        mergeHead.next = target;
        while (node1 != null && node2 != null) {
            if (Integer.parseInt(String.valueOf(node1.data)) > Integer.parseInt(String.valueOf(node2.data))) {
                target.next = node2;
                node2 = node2.next;
            } else {
                target.next = node1;
                node1 = node1.next;
            }
            target = target.next;  //指针向后移
            target.next = null;
        }
        if (node1 == null) target.next = node2;
        else target.next = node1;
        return mergeHead;
    }


    public static void main(String[] args) {
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
        test01.insertNodeByIndex(1, 50);  //50->30->20->10->40

        test01.print();

        /**
         * 删除数据  删除第2位数据
         */
        test01.delNodeByIndex(2);   //50->20->10->40

        test01.selectSortNode();

        test01.print();

        test01.insertSort();
        test01.print();

        Node node = test01.getMiddleNode();
        System.out.println(node);

        Node node1 = test01.FindKthToTail(2);
        System.out.println(node1);
    }
}

