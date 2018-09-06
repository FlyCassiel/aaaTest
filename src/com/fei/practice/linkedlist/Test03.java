package com.fei.practice.linkedlist;

import java.util.Scanner;

/**
 * 最小邮票数
 *
 * @since 2018-09-04
 */
public class Test03 {
    /**
     * 题目描述
     * 有若干张邮票，要求从中选取最少的邮票张数凑成一个给定的总值。
     * 如，有1分，3分，3分，3分，4分五张邮票，要求凑成10分，则使用3张邮票：3分、3分、4分即可。
     * <p>
     * 输入描述:
     * 有多组数据，对于每组数据，首先是要求凑成的邮票总值M，M<100。然后是一个数N，
     * N〈20，表示有N张邮票。接下来是N个正整数，分别表示这N张邮票的面值，且以升序排列。
     * <p>
     * 输出描述:
     * 对于每组数据，能够凑成总值M的最少邮票张数。若无解，输出0。
     * <p>
     * 输入例子:
     * 10
     * 5
     * 1 3 3 3 4
     * <p>
     * 输出例子:
     * 3
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();   //总数（凑成的邮票总值）
            int count = scanner.nextInt();  //总张数（邮票总张数）
            int[] num = new int[count];
            for (int i = 0; i < count; i++) {
                num[i] = scanner.nextInt();  //每张邮票的值
            }
            System.out.println(Mincount(num, count, sum));
        }
    }

    private static int Mincount(int[] num, int count, int sum) {
        int[] dp = new int[sum + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = sum + 1;   //第0位为0，从第1位开始各位都为sum+1
        }
        for (int i = 0; i < count; i++) {
            for (int j = sum; j >= num[i]; j--) {   //j的值递减，直到和这个位上的数值相等时停止递减
                dp[j] = Math.min(dp[j], dp[j - num[i]] + 1); //比较最新的dp值和以前的dp，选取最小，刷新数据
                //System.out.println(dp[j]+"   i="+i+"   "+"j="+j);
            }
        }
        if (dp[sum] == sum + 1) {
            return 0;
        }
        return dp[sum];

    }
}
