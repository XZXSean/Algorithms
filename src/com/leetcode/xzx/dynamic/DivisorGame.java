package com.leetcode.xzx.dynamic;

public class DivisorGame {

	public static void main(String[] args) {
		String string = "aaaaaa", tString = "bbaaaa";
		System.out.println(isSubsequence(string, tString));

	}

	public boolean divisorGame(int N) {
		return N % 2== 0;
    }
	
	public static boolean isSubsequence(String s, String t) {
		char c = s.charAt(0);
		int last = t.indexOf(c);
		for(int i = 1; i < s.length(); i++) {
			c = s.charAt(i);
			int k = t.indexOf(c, last+1);
			if(k < 0) return false;
			last = k;
		}
		return true;
    }
	
}
