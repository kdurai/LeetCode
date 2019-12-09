package com.leetcode.medium.dec201909;

/*
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one 
 * number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

public class MaxProduct {

	public static void main(String[] args) {
		int[] nums = {-2,0,-1};
		System.out.println(maxProduct(nums));

	}

	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		int r = nums[0];
		int n = nums.length;
		int min = r;
		int max = r;
		
		for(int i = 1; i < n; i++ )
		{
			if(nums[i] < 0)
			{
				int temp = min;
				min = max;
				max = temp;
			}
			
			min = Math.min(nums[i], min * nums[i]);
			max = Math.max(nums[i], max * nums[i]);
			
			r = Math.max(r, max);
		}
		
		return r;
    }
}
