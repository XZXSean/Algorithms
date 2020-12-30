package com.algorithms.xzx.practice;

/**
 * @author: zhixiang.xiao
 * @create: 2020/12/30 20:09
 **/

public class Chapter1 {

    static int cnt_of_exercise_1_1_26 = 0;

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(binomial(40, 20, 0.2));
        System.out.println(cnt_of_exercise_1_1_26);
        System.out.println(2);

//        exercise_1_1_1();

    }

    // 二项分布
    public static double binomial(int N, int k, double p) {
        cnt_of_exercise_1_1_26++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    // 1.1.1
    public static void exercise_1_1_1() {
        System.out.println((0 + 15) / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
    }


}
