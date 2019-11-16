package com.leetcode.contest.nov162019;

public class Encode {

	public static void main(String[] args) {

		int num = 23;
		System.out.println(encode(num));
		num = 107;
		System.out.println(encode(num));
	}

	private static String encode(int num) {
		return Integer.toBinaryString(num + 1).substring(1);
    }
}
