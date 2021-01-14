package com.pipi.xzx.test2013;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/14 18:58
 **/

public class Palindrome {
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int cnt = 1;
        String string, showString = "case";
        while (inScanner.hasNext()) {
            string = inScanner.nextLine();
            if (null != string && string.length() > 0) {
                showString = showString + cnt + ": ";
                showString = isPalindrome(string) ? showString + "yes" : showString + "no";
                System.out.println(showString);
                cnt++;
                showString = "case";
            }
        }

    }

    /**
     * 判断是否回文字符串
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string) {
        int len = string.length();
        int mid = len / 2;
        for (int i = 0; i <= mid; i++) { // 直接两边调用依次对比即可
            if (string.charAt(i) != string.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
