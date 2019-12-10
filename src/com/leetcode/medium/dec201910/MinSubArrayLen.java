package com.leetcode.medium.dec201910;

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a 
 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time 
complexity is O(n log n). 

*/
public class MinSubArrayLen {

	public static void main(String[] args) {
		
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));

	}

	public static int minSubArrayLen(int s, int[] nums) {
     
		if(nums == null || nums.length == 0)
			return 0;
		
		int result = Integer.MAX_VALUE;
		
		int left = 0;
		int sum = 0;
		int len = nums.length;
		
		for(int i = 0; i < len; i++ )
		{
			sum += nums[i];
			
			while(sum >= s)
			{
				result = Math.min(result, i+1-left);
				sum -= nums[left++];
			}
		}
		
		return result == Integer.MAX_VALUE ? 0 : result;

    }
	
}
