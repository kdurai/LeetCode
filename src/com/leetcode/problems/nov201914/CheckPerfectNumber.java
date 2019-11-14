package com.leetcode.problems.nov201914;

/*
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

 */

public class CheckPerfectNumber {

	public static void main(String[] args) {

		int num = 28;
		System.out.println(checkPerfectNumber(num));
	}

	private static boolean checkPerfectNumber(int num) {
        int max = num/2;
        
        int sum = 0;
        while(max > 0)
        {
        	if(num % max ==0)
        	{
        		sum = sum + max;
        		System.out.println("sum = " + sum);
        	}
        	max = max -1;
        }
        
        return sum == num;
    }
}
