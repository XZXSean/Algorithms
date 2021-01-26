package com.pipi.xzx.stl;

import java.util.Scanner;

public class PIPIArray {

	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		while (inScanner.hasNext()) {
			int n = inScanner.nextInt(); // 数组长度
			int m = inScanner.nextInt(); // 询问次数
			String string = "";
			for (int i = 0; i < n; i++) { // 获得数组数据
				string += inScanner.nextInt();
			}
			for (int i = 0; i < m; i++) {
				int k = inScanner.nextInt(); // 第k次出现
				int v = inScanner.nextInt(); // 元素v
				findPIPIArray(string, k, v);
			}
		}
	}

	public static void findPIPIArray(String arr, int k, int v) {
		if (k == 1) {
			System.out.println(arr.indexOf(v + '0') + 1);
		} else {
			String[] string = arr.split("" + v);
			if (k >= string.length) {
				System.out.println(0);
			} else {
				int sum = 0;
				for (int i = 0; i < k; i++) {
					sum += string[i].length() + 1;
				}
				System.out.println(sum);
			}
		}
	}
}
