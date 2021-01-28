package com.leetcode.xzx.greedy;

import java.util.Arrays;

/**
 * @author: zhixiang.xiao
 * @create: 2021/1/28 12:37
 **/

public class OverlapIntervals {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] b = {{1, 2}, {1, 2}, {1, 2}};
        int[][] c = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(a));
        System.out.println(eraseOverlapIntervals(b));
        System.out.println(eraseOverlapIntervals(c));
    }

    /**
     * 435. 无重叠区间:
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     * <p>
     * 贪心算法：将区间按照右端点从小到大排序，依次选择右端点最小的区间，再依次往后寻找下一个不重叠的区间
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 首先将 intervals 按照区间尾的大小排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int total = 0, prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) total++;
            else prev = intervals[i][1];
        }
        return total;
    }
}
