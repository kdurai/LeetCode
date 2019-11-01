package com.leetcode.problems;

import java.util.Arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		System.out.println(Arrays.toString(arr));
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void moveZeroes(int[] nums) {
        
	for(int lastNonZeroIndex = 0, curr = 0; curr < nums.length; curr++) {
		if(nums[curr] != 0) {
			int temp = nums[lastNonZeroIndex];
			nums[lastNonZeroIndex] = nums[curr];
			nums[curr] = temp;
			lastNonZeroIndex++;
		}
		
	}
	
    }

}
