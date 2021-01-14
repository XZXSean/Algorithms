package com.pipi.xzx.test2013;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/14 22:41
 **/

public class SecurityPassword {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            String passwordString = inScanner.nextLine();
            if (isSecurity(passwordString)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean isSecurity(String password) {
        if (password.length() < 8) return false;
        int upLetter = 0, lowLetter = 0, digit = 0, specialLetter = 0; // 大写字母，小写字母，数字，特殊字符
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit++;
            } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                upLetter++; // 大写字母
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                lowLetter++;
            } else {
                specialLetter++;
            }
        }
        int security = 0;
        if (digit > 0) security++;
        if (lowLetter > 0) security++;
        if (upLetter > 0) security++;
        if (specialLetter > 0) security++;
        return security > 2;
    }

}
