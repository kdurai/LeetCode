package com.leetcode.medium.dec201921;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a 
 * certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses 
 * have security system connected and it will automatically contact the police if two 
 * adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
             
*/

public class Rob {

	public static void main(String[] args) {
		
		int[] nums = { 1, 2,3,  1};
		System.out.println(rob(nums));

	}

	public static int rob(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		if(nums.length == 2)
			return Math.max(nums[0], nums[1]);
		
		int lootWithFirst = robHelper(nums,0, nums.length-2);
		int lootWithOutFirst = robHelper(nums,1, nums.length-1);
		
		return Math.max(lootWithFirst, lootWithOutFirst);
					
    }

	private static int robHelper(int[] nums, int start, int end) {
		int first =nums[start];
		int second =Math.max(first, nums[start+1]);
		int maxLoot = second;
		
		for(int i = start + 2; i <= end; i++)
		{
			maxLoot = Math.max(first + nums[i], second);
			first = second;
			second = maxLoot;
		}
		
		return maxLoot;
	}
}
