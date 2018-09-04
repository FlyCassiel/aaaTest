package com.fei.practice.sorting;

/**
 * 归并排序：
 * 原理：（2路归并）
 * 初始将一个数组中每个元素都看成一个有序序列(数组长度为n)，
 * 然后将相邻两个有序序列合并成一个有序序列，
 * 第一趟归并就可以得到n/2个长度为2(最后一个有序序列的长度可能是1，也可能不是，关键看数组中元素的个数了)的有序序列，
 * 在进行两两归并，得到n/4个长度为4的有序序列(最后一个的长度可能小于4)...一直这样归并下去，直到得到一个长度为n的有序序列1
 *
 */

/**
 *  相邻两个有序序列合并成一个有序序列的     算法原理：
 *  简单来说，通过三步，解决三个问题，就可以写出归并排序　　　　　　
 *  1、解决相邻两个有序序列归并成一个有序序列，非常简单，新增一个数组(长度和需要排列的数组相同)，
 *  二路归并的核心操作，在归并的过程中，可能会破坏原来的有序序列，所以，将归并的结果存入另外一个数组中，
 *  设两个相邻的有序序列为r[s] ~r[m]和r[m+1]~r[t]，将这两个有序序列归并成一个有序序列，r1[s]~r1[t]，设三个参数i,j,k。
 *  i和j分别指向两个有序序列的第一个记录，即i=s，j=m+1，
 *  k指向存放归并结果的位置(也就是将归并结果放到r1中的哪个位置)k=s。然后，比较i和j所指记录的数，
 *  取出较小者作为归并结果存入k所指的位置，然后将较小者的指向往后移动，直至两个有序序列之一的所有记录都取完，
 *  在将另一个有序序列的剩余记录顺序送到归并后的有序序列中(也就是放到r1中)
 */
public class Merge {
    //一次归并
    /**
     * 相邻两个有序序列归并为一个有序序列
     * @param r    原数组，需要归并的数组
     * @param r1   新数组，归并后的数组
     * @param s    两个有序序列的第一个有序序列的第一个元素的下标
     * @param m    两个有序序列的第一个有序序列的最后一个元素的下标
     * @param t    两个有序序列的第二个有序序列的最后一个元素的下标
     */
    private void merge(int[] r, int[] r1, int s, int m, int t){
        int i = s,     //两个有序序列的第一个有序序列的第一个元素的下标
            j = m + 1, //两个有序序列的第二个有序序列的第一个元素的下标
            k = s;     //新数组中的指向
        while(i <= m && j <= t){//两个有序序列都没有遍历完
            if(r[i] < r[j]){
                r1[k++] = r[i++];
            }else{
                r1[k++] = r[j++];
            }
        }
        //当其中一个序列遍历完之后，将剩下那个序列加到新数组中,判断是哪一个序列没有遍历完
        while(i <= m){
            r1[k++] = r[i++];
        }
        while(j<=t){
            r1[k++] = r[j++];
        }
    }

    //一趟归并
    /**
     * 2、如何完成一趟归并？
     * 　这里就需要分情况了，三种情况，
     * 　假设每个有序序列中的元素个数为h(第一次归并的h=1)，i=0，从第一个元素开始。归并每次取两个有序序列，那么跨度就是2h，问题就来了，只要知道长度为n(n为数组的最大下标值)的数组中有几个这样的两个有序序列，那么可以进行不同的操作了。
     *
     *  第一种情况：(i+2*h-1) <= n  //比如，i=0，h=1时，(i+2*h-1)的意思就是指向了第一个两个有序序列的最后一个位置的下标值，用它来跟n(n为数组最大的下标值)比较，如果小于n，那么说明后面还有别的数，如果等于n，说明到结尾了，整个数组正好全是两个有序序列得，不会有多余数。那么就执行一次归并，将这两个有序序列归并，然后i加2h。如果还符合这个条件，继续归并，如果不符合，判断别的情况。
     *
     * 第二种情况：(i+h-1) < n //说明最后还有两个有序序列，但是最后一个有序序列的长度不是h，同样将其进行归并
     *
     * 第三种情况: (i+h-1) >= n //说明只剩下最后一个有序序列，则直接将其有序序列送到r1的相应位置。
     */
    /**
     * 一趟归并排序
     * @param r    原数组，需要归并操作的数组
     * @param r1 新数组，归并好的数组
     * @param h 步长多少(有序序列中含有的元素个数)
     * @param n    数组长度(数组下标的最大值)
     */
    public void mergePass(int[] r, int[] r1, int h, int n){
        //判断根据步长能分成多个有序序列，
        int i = 0;
        while((i+2*h-1) <= n){//待归并的两个相邻有序序列的长度均为h,需要理解(i+2*h-1)的意思。
            merge(r,r1,i,i+h-1,i+2*h-1);//需要注意一次归并需要的参数
            i += 2*h;
        }
        if(i+h-1 < n){//说明最后还有两个序列，第一个序列长度为h，第二个序列长度小于h
            merge(r,r1,i,i+h-1,n);
            i += 2*h;
        }else{//剩下最后一个序列，长度并且小于或等于h,不用归并了，直接放入新数组中
            for(; i<=n; i++){
                r1[i] = r[i];
            }
        }
    }

    /**
     * 3、完成整个归并排序
     *
     *前面我们解决了两个问题，一个是两个有序序列如何进行归并，一个是如何判断完成一趟归并过程。
     * 现在就需要解决如何控制二路归并的结束呢？也就是需要归并多少趟。
     *当步长等于n或者大于n时，说明只剩下一个有序序列了，那么即归并结束了。
     */
    //二分归并排序非递归算法
    //n：数组最大下标
    public void mergeSort(int[] r, int[] r1,int n){
        int h = 1;    //从1开始排序
        while(h<n){    //直到h>=n才结束，也就步长小于n时都要进行归并
            mergePass(r,r1,h,n);    //一趟归并
            h = 2*h;
            mergePass(r1,r,h,n);//因为经过一趟归并后，r1就变为了那个需要归并的数组，那么r就充当新数组，并且这也能够让排序好的数组放回到r数组中
            h = 2*h;
        }
    }
}