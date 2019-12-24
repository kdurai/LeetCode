package com.leetcode.problems;

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 * 
 */

public class IsPerfectSquare {

	public static void main(String[] args) {
		
		System.out.println(isPerfectSquare(12));

	}
	
	private static boolean isPerfectSquare(int num) {
        
		long x = num;
		
		while( x * x > num)
			x = (x + num/x) >> 1;
		return x * x == num;
		
    }

	private boolean isPerfectSquareAnother1(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
	
	private static boolean isPerfectSquareAnother2(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	 }
}
