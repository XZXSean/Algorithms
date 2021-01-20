package com.pipi.xzx.summerpackage2020;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/20 18:37
 **/

public class RainBow {

    public static void main(String[] args) {
        // 使用 linkedHashMap 使其按输入有序
        Map<String, Integer> rainBowMap = new LinkedHashMap<>();
        Map<String, String> rainNameMap = new HashMap<>();
        initRainBow(rainBowMap, rainNameMap);
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNext()) {
            int n = inScanner.nextInt();
            int cnt = 7; // 共有7种颜色
            for (int i = 0; i < n; i++) {
                String colorString = inScanner.next();
                if (rainBowMap.get(colorString) == 0) {
                    // 第一次输入这种颜色,缺失的颜色数减 1
                    cnt--;
                    rainBowMap.put(colorString, 1);
                }
            }
            System.out.println(cnt); // 输出缺失颜色数量
            for (Map.Entry<String, Integer> entry : rainBowMap.entrySet()) {
                if (entry.getValue() == 0) { // 缺失
                    System.out.println(rainNameMap.get(entry.getKey()));
                }
            }
            // 一组测试用例之后需要更新重新初试map
            initRainBow(rainBowMap, rainNameMap);
        }
    }

    public static void initRainBow(Map<String, Integer> rainBowMap, Map<String, String> rainNameMap) {
        rainBowMap.clear();
        rainBowMap.put("red", 0);
        rainBowMap.put("orange", 0);
        rainBowMap.put("yellow", 0);
        rainBowMap.put("green", 0);
        rainBowMap.put("cyan", 0);
        rainBowMap.put("blue", 0);
        rainBowMap.put("purple", 0);
        // 读取输出的名字
        if (rainNameMap.isEmpty()) {
            rainNameMap.put("red", "A");
            rainNameMap.put("orange", "B");
            rainNameMap.put("yellow", "C");
            rainNameMap.put("green", "D");
            rainNameMap.put("cyan", "E");
            rainNameMap.put("blue", "F");
            rainNameMap.put("purple", "G");
        }
    }

}
