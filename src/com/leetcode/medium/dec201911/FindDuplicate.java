package com.leetcode.medium.dec201911;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Given an array nums containing n + 1 integers where each integer is between 1 and n 
 * (inclusive), prove that at least one duplicate number must exist. Assume that there is 
 * only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {

		int n = nums.length;
		if (n > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}

			return slow;
		}
		return -1;
	}
}
