package com.pipi.xzx.test2013;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/14 20:18
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Narcissus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) { // 循环执行
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            List<Integer> list = narcissisticNumber(low, high);
            if (list.size() > 0) { // 按照格式打印数据
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) { // 最后一个不打印空格
                        System.out.print(list.get(i));
                    } else {
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println(); // 分行
            } else {
                System.out.println("no");
            }
        }

    }

    public static List<Integer> narcissisticNumber(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (isNarcissistic(i))
                list.add(i);
        }
        return list;
    }

    /**
     * 判断是否为水仙花数
     *
     * @param num
     * @return
     */
    public static boolean isNarcissistic(int num) {
        String numString = "" + num; // 将数字转换为字符串
        int sum = 0;
        for (int i = 0; i < numString.length(); i++) {
            sum += (int) Math.pow(numString.charAt(i) - '0', 3); // 计算每位数字的3次方之和
        }
        return sum == num;
    }

}
