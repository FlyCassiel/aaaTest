package com.fei.practice.sorting;

/**
 * 堆排序：大顶堆  小顶堆
 * <p>
 * 堆排序就是利用堆的这种特点进行编写的，
 * 原理：先将一组拥有n个元素的序列构建成大顶堆或者小顶堆，在将根结点上的数跟堆最后一位数进行互换，
 * 此时，第n位的数就是整个序列中最大或者最小的数了，然后在将前n-1位元素进行构建成大顶堆或者小顶堆，
 * 在将根结点跟第n-1位进行互换，得到第2大或者第2小的数，在将前n-2位数进行构建，
 * 依次类推，直到只剩下1位元素即结束，排序完成。
 * <p>
 * 通过讲解原理：堆排序分为三步
 * <p>
 * 1、构建大顶堆或小顶堆
 * <p>
 * 2、循环
 * <p>
 * 　　根节点和末尾结点进行互换，
 * <p>
 * 　　构建大顶堆或小顶堆
 * <p>
 * 3、排序完成
 */


/**
 * @since 2018-09-03
 */
public class Heap {

    /**
     * 要知道什么是堆这种数据结构
     * 堆是一颗完全二叉树。分为大顶堆和小顶堆，
     * 大顶堆，每个父结点都比自己的子节点大，也就是根结点为最大
     * 小顶堆，每个父结点都比自己的子节点小，也就是根结点最小。
     * 按照大顶堆和小顶堆这种特点，将一个无序的n个记录的序列构建成大顶堆,将根节点上的数与最后一个
     * 结点n进行交换，然后在对n-1个记录进行构建大顶堆，继续把根节点与最后一个结点(n-1)互换，继续上面的操作。
     * 从小到大排序，则使用大顶堆
     * 从大到小排序，则使用小顶堆
     * 从小到大
     */

    public void heapSort(int[] array) {
        //1.   将数据建成大顶堆
        int length = array.length;  //length为数组的长度，有几个数就是几，不要跟数组最大的下标值搞混淆了，有10个数，length就是10，数组最大下标为9
        //找到完全二叉树中的最后一个父结点(拥有子结点)的位置length/2，也就是最后一个父节点是在完全二叉树的第length/2的位置上，
        // 但是在数组中的位置是 (length/2)-1，它代表父节点在数组中的位置


        //依次遍历每一个父节点，比如最后一个父节点是4，那么它前面所有结点都是父节点，都需要进行构建（树特性）
        for (int i = (length / 2) - 1; i >= 0; i--) {
            //无序序列，所以需要从下往上全部进行构建。
            // 该方法做的事情就是，比较找到父节点，和两个子节点中最大的数放置到父节点的位置上。
            adjustMaxHeap(array, i, length);
        }


        //2.    构建好了大顶堆后，将第一个数与最后一个进行互换,互换后继续调整大顶堆，
        for (int i = length - 1; i > 0; i--) {
            wrap(array, 0, i);        //互换数据，提取出来了。互换数据后，就已经不在是大顶堆了，需要重新进行构建
            adjustMaxHeap(array, 0, i);    //从上往下，因为基本上都已经有序了，没必要在从下往上重新进行构建堆了，这就利用了前面比较的结果，减少了很多次比较。
        }

    }

    //互换数据
    private void wrap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 构建大顶堆的操作，
     * 父节点和其左右子节点的大小比较和互换，每次将父结点的位置和数组传进来，
     * 就能构建出大顶堆了。
     *
     * @param array  排序数组
     * @param s      当前所指父节点在数组中位置（下标）
     *               父节点和左节点的关系  ： 2s+1
     *               父节点和有右结点的关系：2s+2
     * @param length 数组的长度。用来判断父节点的两个子节点是否存在
     */
    private void adjustMaxHeap(int[] array, int s, int length) {
        int temp = array[s];
        int child;            //代表更大一方的子节点的数组下标
        //2s+1 是左子节点在数组中的位置，本来s+1是父节点在二叉树中的位置，2*(s+1) 是左子节点在二叉树中的位置，那么左子节点在数组中的位置为2*(s+1)-1，简化就为2s+1了
        //为什么需要这个for循环？很多人不理解，觉得这个方法里只需要找到父节点和两个子结点最大的一个即可，这是因为忽略了一个小问题，看下面到152行的解释应该就明白了。
        for (child = s * 2 + 1; child <= length - 1; child = child * 2 + 1) {    //child <= length-1 说明肯定有子节点，如果child=length-1，说明只有左结

            if (child < length - 1 && array[child] < array[child + 1]) {//child<length-1，就说明肯定右子结点，将其进行比较，找出大的一方的数组下标
                child++;    //变成右子节点所在数组中的下标，找到那个较大的子节点
            }
            if (array[child] > temp) {    //将子节点(可能是左结点，也可能是右结点，就看上面这个判断了)与父节点进行比较，子节点大的话，将大的赋给父节点
                array[s] = array[child];
            } else {        //父节点大，什么也不做，跳出这层循环。
                break;
            }

            array[child] = temp;    //父结点变为最大时，要将原先的父节点的值给现在的子节点。
            s = child;        //因为子节点的值变了，那么就不知道这个子节点和他自己的两个子节点中是否还是最大，所以需要将该子节点的数组下标给s，去重新检测一遍。只有当父节点为最大时，才会执行break退出循环。

        }
    }
    public static void main(String[] args){

        Heap heap = new Heap();
        int[] array = {23,13,49,6,31,19,38};
        heap.heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }
}
