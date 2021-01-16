package com.pipi.xzx.test2014;

import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/16 18:08
 **/

public class Score {
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int score = inScanner.nextInt();
            System.out.println(scoreToLevel(score));
        }
    }

    public static String scoreToLevel(int score) {
        if (score > 120 || score < 0) return "Score is error!";
        else if (score > 107) return "A";
        else if (score > 99) return "B";
        else if (score > 79) return "C";
        else if (score > 71) return "D";
        else return "E";
    }
}
