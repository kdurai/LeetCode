package com.leetcode.problems;

/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one 
 * digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

	public static void main(String[] args) {

		System.out.println(addDigits(38));
	}
	
	private static int addDigits(int num) {
        int sum = 0;
        
        while(num > 0)
        {
        	sum += num % 10;
        	if(sum > 9)
        	{
        		int carryover = sum % 10;
        		sum = sum / 10 + carryover;
        	}
        	
        	num /= 10;
        }
        
        return sum;
    }

}
