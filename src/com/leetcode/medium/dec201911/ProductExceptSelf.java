package com.leetcode.medium.dec201911;

import java.util.Arrays;

/*
 * Given an array nums of n integers where n > 1,  return an array output such 
 * that output[i] is equal to the product of all the elements of nums except 
 * nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not 
count as extra space for the purpose of space complexity analysis.)

*/

public class ProductExceptSelf {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {
        
		int n = nums.length;
		
		/*
		 * int[] left = new int[n]; left[0] = 1;
		 * 
		 * for(int i = 1; i < n-1; i++) left[i] = nums[i-1] * left[i-1];
		 */
		
		int[] ans = new int[n];
		ans[n-1] = 1;
		
		for(int i = n-2; i >= 0; i--)
			ans[i] = nums[i+1] * ans[i+1];
		
		int left= 1;
		for(int i = 0; i < n; i++)
		{
			ans[i] = left * ans[i];
			left = left * nums[i];
		}
		
		return ans;
    }
}
