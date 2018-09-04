package com.fei.practice.sorting;

/**
 * 冒泡排序：
 * 原理：
 * 整个过程就想气泡一样往上升，假设从小到大排序，对于给定的n个记录，
 * 从第一个记录开始依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时，交换位置，
 * 进行一轮比较后，第n位上就是整个记录中最大的数，然后在对前n-1个记录进行第二轮比较，
 * 重复该过程直到进行比较的记录只剩下一个为止。
 */
public class Bubble {

    private void selectSort(int[] array){
        /**
         * 通过看冒泡排序的原理图，我们知道只要让其一直遍历数组即可，只不过每遍历一次，就要让遍历的长度减1，
         * 所有就在遍历的外面加一层while循环。判断的条件为，当遍历的长度>=1时，此时就只需要遍历两个数据了，比完后不应该在继续。
         * 非常简单的逻辑。
         *
         * @param array
         */
        for (int j = array.length -1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if( array[i] > array[i+1]){
                    int t = array[i];
                    array[i] = array[i+1];
                    array[i+1] = t;
                }
            }
        }
    }

    public static void main(String[] args){
        Bubble bubble = new Bubble();
        int[]  array = {9,7,12,4,3,8};
        bubble.selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"   ");
        }
    }
}
