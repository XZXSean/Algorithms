package com.pipi.xzx.weeklygame1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/18 19:49
 **/

public class PIPIStringIX {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            String string = inScanner.nextLine();
            getPIPIIX(string);
        }

    }

    public static void getPIPIIX(String string) {
        char lastChar = string.charAt(0);
        String subString = "" + lastChar;
        Set<String> set = new TreeSet<>(); // 使用 set 去重，treeset 可自动排序
        for (int i = 1; i < string.length(); i++) {
            while (i < string.length() && lastChar == string.charAt(i)) {
                i++;
                subString += lastChar;
            }
            if (i == string.length()) { // 已经到末尾
                set.add(subString);
            } else {
                // 还未到末尾
                set.add(subString);
                lastChar = string.charAt(i);
                subString = "" + lastChar; //重新更新 子串
            }
        }
        System.out.println(set.size());
        for (String string2 : set) {
            System.out.println(string2);
        }
    }

}
