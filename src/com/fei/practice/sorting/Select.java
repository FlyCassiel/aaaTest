package com.fei.practice.sorting;

/**
 * 选择排序
 * 原理：
 * 先将第一个位值上的数跟之后所有位置上的数依次进行比较，
 * 如果第一个位置上的数比第二个位置上的数大，则进行互换，
 * 然后继续将第一个位置上的数与第三个位置上的数进行比较，
 * 经过一轮的比较后，第一个位值上的数就是所有数中最小的一个，
 * 接着将第二个位置上的数与之后所有位置上的数进行比较，同样的规则，
 * 第二轮比较结束后，第二位放的就是所有数中第二小的数，依次往下比，
 * 直到最后一个位置结束。按照这种方法进行排序，就叫做选择排序。
 */

public class Select {

    private void xuanzeSort(int[] array){
      for (int j = 0; j < array.length; j++){
          for(int i = j+1; i < array.length; i++){
              if(array[j] > array[i]){
                  int t;
                  t = array[i];
                  array[i] = array[j];
                  array[j] = t;
              }
          }
          System.out.print(array[j]+"       ");
      }
        System.out.println();
    }
    public static void main(String[] args){
        int[] array = {4,2,7,5,8,3};
        Select xuanze = new Select();
        xuanze.xuanzeSort(array);
        for(int i =0; i < array.length; i++){
          System.out.print(array[i]);
        }
        System.out.println();
    }
}
