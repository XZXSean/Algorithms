package com.leetcode.xzx.array;

import java.util.HashMap;
import java.util.Map;

public class EquivDominoPairs {

	public static void main(String[] args) {
		int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
		System.out.println(numEquivDominoPairs(dominoes));
	}

	public static int numEquivDominoPairs(int[][] dominoes) {
		int len = dominoes.length;
		Map<Pair, Integer> map = new HashMap<EquivDominoPairs.Pair, Integer>();
		for (int i = 0; i < len; i++) {
			Pair pair = new Pair(dominoes[i][0], dominoes[i][1]);
			map.put(pair, map.getOrDefault(pair, 0) + 1);
		}
		int sum = 0;
		for (int is : map.values()) {
			sum += is * (is - 1) / 2;
		}
		return sum;
	}

	static class Pair {
		private int num1;
		private int num2;

		public Pair(int num1, int num2) {
			super();
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public int hashCode() {
			return Math.max(num2, num1) * 10 + Math.min(num2, num1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return (this.num1 == other.num1 && this.num2 == other.num2)
					|| (this.num1 == other.num2 && this.num2 == other.num1);
		}

	}

}
