package com.fei.practice.sorting;

public class Quick {

    /*
     * 对序列划分为左右两个部分,
     * 轴值为数组第一个元素
     * i，first:指向需要进行左右两侧排序的序列的第一个位置
     * j，end:指向需要进行左右两侧排序的序列的最后一个位置
     */
    public int Partition(int[] array, int first, int end){
        int i = first;
        int j = end;
        while(i < j){        //i和j会慢慢往中间靠，当i==j时，说明已经排好左右两侧的数据了，这里为什么不写i!=j作为条件呢？原因是有些情况是first>end，比如first=0，而end=-1，
            while(i < j && array[i] < array[j]){//右侧进行扫描，array[i]是轴值
                j--;    //最后一个元素是大于轴值的，那么就不动，因为已经在其右边的，j--，往前移动一个位置
            }
            if(i < j){    //这一步是当array[i] > array[j]。轴值的位置变为了j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
            while(i<j&&array[i] < array[j]){//左侧扫描，如果都比轴值小的话，i往后移动
                i++;
            }
            if(i < j){    //当发现有比轴值大的数时，进行互换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
        }
        return  j;
    }

    public void quickSort(int[] array, int first, int end){
        if(first < end){
            int pivot = Partition(array,first,end);    //返回轴值的位置
            quickSort(array,first,pivot-1);//第一次排好后，pivot-1就是左侧最尾部的位置
            quickSort(array,pivot+1,end);    //pivot+1，右侧最开始的位置。
        }
    }
    public static void main(String[] args){
        Quick quick = new Quick();
        int[]  array = {23,13,49,6,31,19,28};
        /*int j =quick.Partition(array,0,array.length-1);*/
        /*System.out.println(j);*/
        quick.quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"   ");
        }
    }
}
