package com.pipi.xzx.weektest1038;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/13 18:51
 **/

import java.lang.reflect.Array;
import java.util.*;

/**
 * 问题 A: 司令官PIPI: http://pipioj.online/problem.php?cid=1038&pid=0
 */
public class PIPI9Commander {
    public static void main(String[] args) {
        /*
         * 输入：
         * 	第一行输入一个正整数 N， 代表士兵的个数(N<=1e5)。
         * 	第二行输入N个正整数，代表每一个士兵所属兵团所在营地的位置M(M<=1e6)。
         *
         * 样例输入：
         * 	5
         * 	2 2 2 3 3
         */
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = inScanner.nextInt();
        }
        System.out.println(min_cost(nums));
    }

    public static int min_cost(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        // 统计不同营地的类型以及数量
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int min = Integer.MAX_VALUE; // 最小值
        // 遍历map,依次计算以当前营地为基准靠拢的值
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int camp = entry.getKey();
            int dis = 0;
            for (Integer key : map.keySet()) {
                if (key == camp) continue;
                if (Math.abs(key - camp) % 2 == 1) {
                    dis = dis + map.get(key); // 若距离为1，代价
                }
            }
            if (dis < min)
                min = dis;
        }

        return min;
    }
}
