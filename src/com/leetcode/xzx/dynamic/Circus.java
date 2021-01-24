package com.leetcode.xzx.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Circus {

	public static void main(String[] args) {
		int[] height = {65,70,56,75,60,68};
		int[] weight = {100,150,90,190,95,110};
		System.out.println(bestSeqAtIndex(height, weight));

	}

	public static int bestSeqAtIndex(int[] height, int[] weight) {
		CircusPerson[] persons = new CircusPerson[height.length];
		for (int i = 0; i < height.length; i++) {
			CircusPerson person = new CircusPerson(height[i], weight[i]);
			persons[i] = person;
		}
		int res = 0;
		int[] dp = new int[height.length];
		Arrays.sort(persons);
		for (CircusPerson circusPerson : persons) {
			int i = Arrays.binarySearch(dp, 0,res,circusPerson.height);
			if(i < 0) i = -(i+1);
			dp[i] = circusPerson.height;
			if (i == res) {
				res++;
			}
		}
		return res;

	}

	static class CircusPerson implements Comparable<CircusPerson> {
		int height;
		int weight;

		public CircusPerson(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		// 按身高升序，体重降序排序
		@Override
		public int compareTo(CircusPerson o) {
			return this.height == o.height ? o.weight - this.weight : this.height - o.height;

		}

	}

}
