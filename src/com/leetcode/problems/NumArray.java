package com.leetcode.problems;
/*
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

public class NumArray {

	/*
	 * int[] nums;

public NumArray(int[] nums) {
    for(int i = 1; i < nums.length; i++)
        nums[i] += nums[i - 1];
    
    this.nums = nums;
}

public int sumRange(int i, int j) {
    if(i == 0)
        return nums[j];
    
    return nums[j] - nums[i - 1];
}
	 */
	int[] sum;
	
	public NumArray(int[] nums) {
		sum = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) 
			sum[i + 1] = sum[i] + nums[i];
		
    }
    
    public int sumRange(int i, int j) {
    	return sum[j+1] - sum[i];
    }
    
	public static void main(String[] args) {

		int[] arr = {-2, 0, 3, -5, 2, -1};
		NumArray numarray = new NumArray(arr);
		
		System.out.println();
		System.out.println(numarray.sumRange(1,2));
	}
	
}
