package com.leetcode.medium.nov201923;

import java.util.Arrays;

/*
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 *  of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * 
 */

public class SearchRange {

	public static void main(String[] args) {
		int[] arr = {1,1,2};
		int[] result = searchRange(arr, 1);
		System.out.println(Arrays.toString(result));
	}

	private static int[] searchRange(int[] nums, int target) {
		
		int[] result = {-1, -1};
		
		/*
		 * while(left <= right) { int mid = (left + right)/2;
		 * 
		 * if(nums[mid] < target) left = mid + 1; else if (nums[mid] > target ) right =
		 * mid - 1; else return new int[] {findLeft(nums, 0, mid, target),
		 * findRight(nums, mid, nums.length - 1, target)}; }
		 */
		
		
		result[0] = findFirstOccurance(nums, 0, nums.length-1, target);
		result[1] = findLastOccurance(nums, 0, nums.length-1, target);
		
		return result;

	}
	
	private static int findFirstOccurance(int[] nums, int left, int right, int target)
	{
		int result = -1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			
			if(nums[mid] == target)
			{
				result = mid;
				right = mid - 1;
			}
			else if(target < nums[mid])
				right = mid-1;
			else
				left = mid + 1;
		}
		
		return result;
	}
	
	private static int findLastOccurance(int[] nums, int left, int right, int target)
	{
		int result = -1;
		
		while(left <= right)
		{
			int mid = (left + right)/2;
			
			if(nums[mid] == target)
			{
				result = mid;
				left = mid + 1;
			}
			else if(target < nums[mid])
				right = mid-1;
			else
				left = mid + 1;
		}
		
		return result;
	}
	
	/*
	 * private static int findLeft(int[] nums, int left, int right, int target) {
	 * 
	 * while(left < right) { int mid = (left + right)/2;
	 * 
	 * if(nums[mid] < target) left = mid + 1; else if (nums[mid-1] < target ) return
	 * mid; else right = mid - 1; }
	 * 
	 * return left; }
	 * 
	 * private static int findRight(int[] nums, int left, int right, int target) {
	 * 
	 * while(left < right) { int mid = (left + right)/2;
	 * 
	 * if(nums[mid] > target) right = mid - 1; else if (nums[mid+1] > target )
	 * return mid; else left = mid + 1; }
	 * 
	 * return right; }
	 */
	
}
