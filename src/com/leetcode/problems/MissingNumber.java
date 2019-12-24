package com.leetcode.problems;

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = {3,0,1};
		System.out.println(missingNumber(arr));
	}
	
	private static int missingNumber(int[] nums) {
	
		int expectedSum = nums.length * (nums.length + 1) / 2;
		int actualSum = 0;
		
		for(int num : nums) {
			actualSum += num;
		}
		
		return expectedSum - actualSum;
		
	}

}
