package com.leetcode.xzx.string;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/4 16:12
 **/

public class Atoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        while (input.hasNext()) {
            str = input.nextLine();
            System.out.println(myAtoi(str));
        }
    }

    /**
     * 字符串转换整数 (atoi)：https://leetcode-cn.com/problems/string-to-integer-atoi
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        if (null == s || s.length() == 0) return 0;
        long sum = 0;
        int i = 0, exp = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') i++; // 找到第一个非空字符
        if (i >= len || (s.charAt(i) != '+' && s.charAt(i) != '-'
                && !Character.isDigit(s.charAt(i))))
            return 0;   // 字符串全为空字符或第一个非空字符非 正负符号或数字，则无效
        boolean isSign = true; // 标记正负符号
        if (s.charAt(i) == '-') {
            isSign = false;// 负
            i++;
        } else if (s.charAt(i) == '+') { // 正
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i)) && exp <= 12) {
            sum = 10 * sum + s.charAt(i) - '0'; // char -> int
            i++;
            if (sum > 0) exp++; // 整数长度超过12即可认为已经超过整数最大上限，
        }
        if (sum > Integer.MAX_VALUE
                || sum <= Integer.MIN_VALUE) // 溢出界,此处这样写是防止整数过大已溢出long上下界
            return isSign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (!isSign) sum = -sum; // 负数
        return (int) sum;
    }
}
