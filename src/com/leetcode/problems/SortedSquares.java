package com.leetcode.problems;

import java.util.Arrays;

public class SortedSquares {

	public static void main(String[] args) {

		int[] arr = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(arr)));
	}

	private static int[] sortedSquares(int[] A) {

		int[] result = new int[A.length];
		
		for(int i = 0; i < A.length; i++)
			result[i] = A[i] * A[i];
		
		Arrays.sort(result);
		
		return result;
	}
}
