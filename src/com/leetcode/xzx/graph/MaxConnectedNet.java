package com.leetcode.xzx.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MaxConnectedNet {

	public static void main(String[] args) {
		int[][] connections = {
				{0,1},
				{0,2},
				{1,2}
		};
		System.out.println(makeConnected(4, connections));
	}
	
	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n-1) return -1;
		int[] father = new int[n]; // 并查集的父数组
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < father.length; i++) {
			father[i] = i;
		}
		for(int i = 0; i < connections.length; i++) {
			int[] edge = connections[i];
			int head = edge[0];
			int tail = edge[1];
			if(find(head, father) != find(tail, father)) {// 未联通，直接纳入并查集
				merge(head, tail, father);
				set.add(head);
				set.add(tail);
			} else {
				list.add(i); //暂存多余的连通分量
			}
		}
		Set<Integer> type = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			type.add(find(i, father));
		}
		return type.size() - 1;
    }
	
	/**
     * 并查集
     */
    public static int find(int x, int[] father) {
        return x == father[x] ? x : find(father[x], father);
    }

    public static void merge(int i, int j, int[] father) {
        father[find(i, father)] = find(j, father);
    }

}
