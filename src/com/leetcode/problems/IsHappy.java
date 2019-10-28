package com.leetcode.problems;

/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

public class IsHappy {

	public static void main(String[] args) {

		int N = 29;
		
		System.out.println(isHappy(N));
	}

	private static boolean isHappy(int n) {
        
		int slow = n, fast = n;
		
		do
		{
			slow = squareSum(slow);
			fast = squareSum(fast);
			fast = squareSum(fast);
		}while( slow != fast);
		
		return slow == 1 ?  true: false;
    }
	
	private static int squareSum(int n) {
		int sum = 0;
		
		while(n > 0) {
			int tmp = n % 10;
			sum += tmp * tmp;
			n = n /10;
		}
		
		return sum;
	}
}
