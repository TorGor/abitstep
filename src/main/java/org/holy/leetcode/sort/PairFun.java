package org.holy.leetcode.sort;

import java.util.*;

public class PairFun {
	static List<Pair> countPair(int[] num, int diff) {

		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < num.length; i++){
			hashSet.add(num[i]);
		}
		Set<Integer> set = new TreeSet<>(hashSet);
		Integer[] integers = set.toArray(new Integer[]{});

		ArrayList<Pair> list = new ArrayList<>();

		for (int i = 0; i < integers.length-1; i++) {
			int a = integers[i];
			for (int j = i+1; j < integers.length; j++) {
				int b = integers[j];
				int abs = Math.abs(a-b);
				if(abs == diff) {
					Pair p = new Pair();
					p.x = a;
					p.y = b;
					list.add(p);
				}
			}
		}

		return list;
	}

	static class Pair{
		int x;
		int y;
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}


	public static void main(String[] args) {
		int[] arrays = {1,2,3,4,5,3};
		List<Pair> list = countPair(arrays,1);
		System.out.println(list);
	}







}

