package com.leetcode.xzx.dynamic;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/9 18:00
 **/

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit_dynamic(prices));
        System.out.println(maxProfit_violence(prices));

    }

    /**
     * 买卖股票的最佳时机：只能买卖一次
     * 暴力解法
     * 【例子】:[7,1,5,3,6,4]
     *
     * @param prices
     * @return
     */
    public static int maxProfit_violence(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    /**
     * 买卖股票的最佳时机：只能买卖一次
     * 动态规划解决
     * 【例子】:[7,1,5,3,6,4]
     * <p>
     * 解题思路：
     * s1: 记录今天之前买入的最小值
     * s2: 计算今天卖出的最大获利
     * s3: 比较每天的最大获利
     *
     * @param prices
     * @return
     */
    public static int maxProfit_dynamic(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(min, price);
        }
        return maxProfit;
    }
}
