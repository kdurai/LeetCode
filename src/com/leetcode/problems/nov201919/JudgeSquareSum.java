package com.leetcode.problems.nov201919;

/*
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such 
 * that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 

Example 2:

Input: 3
Output: False
 */
public class JudgeSquareSum {

	public static void main(String[] args) {
		
		System.out.println(judgeSquareSum(5));

	}
	
	private static boolean judgeSquareSum(int c) {
        
		if(c == 0)
			return true;
		
		int start = 0, end = (int)Math.sqrt(c);
		
		while(start <= end) {
			int sum = start * start + end * end;
			
			if(sum < c)
				start++;
			else if( sum > c)
				end--;
			else
				return true;
		}
		
		return false;
    }

}
