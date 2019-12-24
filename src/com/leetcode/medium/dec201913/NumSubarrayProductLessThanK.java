package com.leetcode.medium.dec201913;

/*
 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the 
subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], 
[5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.

 */

public class NumSubarrayProductLessThanK {

	public static void main(String[] args) {
		
		int[] nums = {10,5,2,6};
		System.out.println(numSubarrayProductLessThanK(nums, 100));
	}
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		
		if(k <= 1)
			return 0;
        
		int result = 0;
		int n = nums.length;
		int product = 1;
        int left = 0;
		for(int start = 0;  start < n; start++)
		{
            product *= nums[start];
            
            while(product >= k) 
                product /= nums[left++];
            
			result += start - left + 1; 
		}
		
		return result;   
    }

}
