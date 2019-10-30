package com.leetcode.problems;


public class TrailingZeroes {

	public static void main(String[] args) {

		System.out.println(trailingZeroes(5));
	}

	private static int trailingZeroes(int n) {
        return n == 0 ? 0: n / 5 + trailingZeroes(n/5);
    }
	
}
