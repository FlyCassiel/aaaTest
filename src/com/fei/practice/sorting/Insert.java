package com.fei.practice.sorting;

/**
 * 插入排序：原理：分为有序数组和无序数组
 * 给定的一组记录，将其分为两个序列组，一个为有序序列(按照顺序从小到大或者从大到小)，一个为无序序列，
 * 初始时，将记录中的第一个数当成有序序列组中的一个数据，剩下其他所有数都当做是无序序列组中的数据。
 * 然后从无序序列组中的数据中(也就是从记录中的第二个数据开始)依次与有序序列中的记录进行比较，
 * 然后插入到有序序列组中合适的位置，直到无序序列组中的最后一个数据插入到有序序列组中为止。
 */
public class Insert {
    /**
     * 分两组：前面是有序   | 后面是无序
     * 比如，现在是排序第四位上的数
     * 就把第四位上的数与有序数组中的最后一位比较大小，大则，放最后一位，小，则再和前一位比较。
     * @param array
     */
    private void insertSort(int[] array){

        int temp,j;
        for (int i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]){
                temp = array[i];
                for (j = i-1; j >= 0 && array[j] > temp; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }

    public static void main(String[] args){

        long startTime=System.currentTimeMillis();

        Insert insert = new Insert();
        int[] array = {49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4};
        insert.insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"    ");
        }

        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");
    }
}
