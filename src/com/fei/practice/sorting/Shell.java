package com.fei.practice.sorting;

import java.util.Date;

/**
 * 希尔排序（插入排序增强）
 */
public class Shell {

    public void shellSort(int[] array){
        int i,j,temp;    //i,j分别为for循环中的控制变量 temp作用是临时记录数
        int length = array.length;
        int gap = length;
        do{
            gap = gap/2;    //步长， 假设length为10，则步长为5 2 1
            for(i = gap; i<length; i++){
                if(array[i] < array[i-gap]){
                    temp = array[i];
                    for(j = i-gap; j>=0 && array[j]>temp; j-=gap){
                        array[j+gap] = array[j];
                    }
                    array[j+gap] = temp;
                }
            }

        }while(gap>0);
    }

    public static void main(String[] args){

        long startTime=System.currentTimeMillis();

        Shell shell = new Shell();
        int[] array = {49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4,49,38,65,97,76,13,27,49,55,4};
        shell.shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"   ");
        }

        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");
    }

}
