package com.leetcode.medium.dec201921;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest 
 * element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */

public class FindKthLargest {

	public static void main(String[] args) {
		
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		
		System.out.println(findKthLargest(nums, k));

	}

	public static int findKthLargest(int[] nums, int k) {
        
		k = nums.length - k;
		
		int start = 0;
		int end = nums.length - 1;
		
		while(start < end)
		{
			int pivot = partition(nums, start, end);
			
			if(pivot < k)
				start = pivot + 1;
			else if(pivot > k)
				end = pivot - 1;
			else
				break;
		}
		
		return nums[k];
    }

	private static int partition(int[] nums, int start, int end) {
		
		int i = start;
		int j = end + 1;
		
		while(true)
		{
			while(i < end && isLow(nums[++i], nums[start]));
			while(j > start && isLow(nums[start], nums[--j]));
			
			if(i >= j)
				break;
			
			swap(nums, i, j);
		}
		
		swap(nums, start, j);
		
		return j;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static boolean isLow(int i, int j) {
		return i < j;
	}
}
