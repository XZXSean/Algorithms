package com.leetcode.xzx.greedy;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		int[] candy = { 1, 0, 2 };
		System.out.println(candys(candy));

	}

	/**
	 * 135. 分发糖果:
	 * 		https://leetcode-cn.com/problems/candy/
	 * 
	 * 两次遍历：
	 * 	s0: 初始所有孩子默认为0
	 *  s2: 从左往右遍历：若右边的孩子评分高，则右边的孩子为当前孩子糖果数+1
	 *  s3: 从右往左遍历：若左边的孩子评分高，且左边孩子糖果数不大于当前孩子，左边孩子糖果数为当前孩子糖果数+1
	 * @param ratings
	 * @return
	 */
	public static int candys(int[] ratings) {
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 0; i < ratings.length - 1; i++) {
			if (ratings[i + 1] > ratings[i]) {
				candy[i + 1] = candy[i] + 1;
			}
		}
		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				candy[i - 1] = Math.max(candy[i] + 1, candy[i-1]);
			}
		}
		int sum = 0;
		for (int i : candy) {
			sum += i;
		}
		return sum;
	}

}
