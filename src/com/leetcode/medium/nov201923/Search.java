package com.leetcode.medium.nov201923;

import java.util.HashMap;
import java.util.Map;

/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 * 
 */
public class Search {

	public static void main(String[] args) {
		
		int[] arr = {1,3};
		//int[] arr = {10,0,1};
		//System.out.println(search(arr, 0));
		System.out.println(search(arr, 3));

	}

	private static int search(int[] nums, int target) {
		
		/*
		 * int start = 0, end = nums.length - 1; int pivot = findPivotIndex(nums, start,
		 * end);
		 */
		
		int start = 0, end = nums.length - 1;
        
        while(start < end)
        {
            int mid = (start + end)/2;
            
            if(nums[mid] < nums[end])
                end = mid;
            else
                start = mid+1;
        }
        
		int pivot = start;
		
		start = 0;
		end = nums.length - 1;
		System.out.println("Pivot= " + pivot);
		
		if(pivot == -1)
			return -1;
		if(target == nums[pivot])
		{
			System.out.println("pivot: " + pivot);
			return pivot;
		}
		
		if(target > nums[pivot] && target <= nums[end])
		{
			int index = binarySearch(nums, pivot, end, target);
			System.out.println("index1: " + index);
			return index;
		}
		else
		{
			int index = binarySearch(nums, start, pivot, target);
			System.out.println("index2: " + index);
			return index;
		}
    }

	private static int binarySearch(int[] nums, int start, int end, int target) {
		
		while(start < end)
		{
			int mid = (start + end)/2;
			
			if(nums[mid] == target)
				return mid;
			
			if(target < nums[mid])
				end = mid-1;
			else
				start = mid+1;
		}
		
		return -1;
	}

	private static int findPivotIndex(int[] nums, int start, int end) {
		
		int pivot = (start + end)/2;
		
		if((pivot + 1) == nums.length)
			return -1;
		
		if(nums[pivot] > nums[pivot + 1] )
			return pivot + 1;
		
		if(nums[start] > nums[pivot])
			end = pivot-1;
		else
			start = pivot + 1;
		
		return findPivotIndex(nums, start,end);
		
	}
	
	
}
