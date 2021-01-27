package com.leetcode.xzx.greedy;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s= {1,2,3};
		System.out.println(findContentChildren(g, s));

	}

	/**
	 * 455. 分发饼干
	 * 		https://leetcode-cn.com/problems/assign-cookies/
	 * @param g
	 * @param s
	 * @return
	 */
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int sum = 0;
		int i = 0, j = 0;
		while (i < g.length && j < s.length) {
			if (g[i] <= s[j]) {
				i++;
				j++;
				sum++;
			} else {
				j++;
			}
		}
		return sum;
	}

}
