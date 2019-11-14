package com.leetcode.problems.nov201914;

/* 
 * Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
 * 
 */

public class ConvertToBase7 {

	public static void main(String[] args) {

		int num = 14;
		System.out.println(convertToBase7(num));
		num = 100;
		System.out.println(convertToBase7(num));
		num = -7;
		System.out.println(convertToBase7(num));
	}

	private static String convertToBase7(int num) {
        
		if(num == 0)
            return "0";
		
		StringBuilder sb = new StringBuilder();
		
		boolean sign = false;
		
		if(num < 0)
		{
			sign = true;
			num = -num;
		}
		
		while(num > 0) {
			sb.append(num%7);
			num = num/7;
			
		}
		
		return sign ? "-" + sb.reverse().toString(): sb.reverse().toString();
    }
}
