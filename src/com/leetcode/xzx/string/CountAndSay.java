package com.leetcode.xzx.string;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/5 18:10
 **/

public class CountAndSay {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            System.out.println(countAndSay(n));
        }
    }

    public static String countAndSay(int n) {
        if (n == 0) return null;
        int cnt = 0; // 相同字符的个数
        char say = 0; // 相同数字
        char lastChar = 0; // 暂存上一个字符
        StringBuilder stringBuilder = new StringBuilder();
        String str = "" + 1; // 1个
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < str.length(); j++) {
                say = str.charAt(j);
                if (lastChar == 0) { // 初始化lastChar
                    lastChar = say;
                }
                if (lastChar == say) { // 相同的字符
                    cnt++;
                } else {
                    stringBuilder.append(cnt).append(lastChar);
                    lastChar = say;
                    cnt = 1;
                }
            }
            stringBuilder.append(cnt).append(say);
            str = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            lastChar = 0;
            cnt = 0;
        }
        return str;
    }
}
