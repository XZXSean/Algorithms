package com.leetcode.xzx.greedy;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/28 13:00
 **/

public class PlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }

    /**
     * 605. 种花问题
     * https://leetcode-cn.com/problems/can-place-flowers/
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 0) { // 如果当前位置为0，只需要判断下一个位置是否为1,
                if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) { // 为1说明不可以种
                    i += 3; // +3 是保证下一个判断的位置前一个必定为0
                } else { // 已经到了最后一个位置或者下一个位置未种，说明可以在此处种花
                    n--;
                    i += 2;
                }
            } else {
                i += 2;
            }
        }
        return n <= 0;
    }
}
