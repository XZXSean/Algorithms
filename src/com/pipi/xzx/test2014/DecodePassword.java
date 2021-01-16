package com.pipi.xzx.test2014;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/16 18:51
 **/

public class DecodePassword {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            String startString = inScanner.nextLine();
            if (startString.equals("ENDOFINPUT"))
                break;
            String passwordString = inScanner.nextLine();
            String endString = inScanner.nextLine();
            DecodePassword(passwordString);
        }
    }

    public static void DecodePassword(String password) {
        String newPassword = "";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isAlphabetic(c)) { // 是字母
                int dis = c - 5; // 与A的距离
                if (dis < 'A') {
                    // 当比A小时，减去 Z - (A - (c - 5 ) ) + 1个位置
                    c = (char) ('Z' - 'A' - 5 + c + 1);
                } else {
                    c = (char) dis;
                }
            }
            newPassword += c;
        }
        System.out.println(newPassword);
    }
}
