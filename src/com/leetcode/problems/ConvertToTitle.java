package com.leetcode.problems;

public class ConvertToTitle {

	public static void main(String[] args) {

		System.out.println(convertToTitle(33));
	}

	private static String convertToTitle(int n) {
		
		StringBuilder str = new StringBuilder();
		
		while(n > 0) {
			--n;
			str.insert(0, (char)('A' + (n % 26)));
			n = n / 26;
		}
		
		return str.toString();
    }
}
