package com.leetcode.xzx.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/9 19:23
 **/

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15).toString());
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 0) return list;
        String string = "";
        boolean flag = false; // 是否是3或5的倍数
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                string += "Fizz";
                flag = true;
            }
            if (i % 5 == 0) {
                string += "Buzz";
                flag = true;
            }
            if (!flag) {
                string += i;
            }
            list.add(string);
            string = "";
            flag = false;
        }
        return list;
    }
}
