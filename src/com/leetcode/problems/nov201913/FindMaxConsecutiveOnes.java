package com.leetcode.problems.nov201913;

/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

public class FindMaxConsecutiveOnes {

	public static void main(String[] args) {
		
		int[] arr = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(arr));

	}
	
	private static int findMaxConsecutiveOnes(int[] nums) {
	        
		int max = 0, maxhere = 0;

		for(int num : nums)
			max = Math.max(max, maxhere = num == 0 ? 0 : maxhere + 1);
		
		return max;
	 }

}
