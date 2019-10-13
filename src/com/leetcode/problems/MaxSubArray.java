package com.leetcode.problems;

public class MaxSubArray {

	public static void main(String[] args) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	private static int maxSubArray(int[] nums) {
        
		int maxEndingHere = nums[0], maxSoFar = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i],  nums[i]);
			maxSoFar = Math.max(maxEndingHere,  maxSoFar);
		}
		
		return maxSoFar;
    }

}
