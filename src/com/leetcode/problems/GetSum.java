package com.leetcode.problems;

/*
 *Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
 
 */
public class GetSum {

	public static void main(String[] args) {
		int a = 2, b= 1;
		System.out.println(getSum(a, b));
	}
	
	private static int getSum(int a, int b) {
        return b == 0 ? a:getSum(a ^ b, (a &  b) << 1);
    }
}
