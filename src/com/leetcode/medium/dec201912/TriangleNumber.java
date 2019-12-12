package com.leetcode.medium.dec201912;

import java.util.Arrays;

/*
 * Given an array consists of non-negative integers, your task is to count the number of triplets
 *  chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *  
Example 1:
Input: [2,2,3,4]
Output: 3

Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].

 */
public class TriangleNumber {

	public static void main(String[] args) {

		int[] nums = { 1,2,3,4};
		
		System.out.println(triangleNumber(nums));
	}

	public static int triangleNumber(int[] nums) {
        
		Arrays.sort(nums);
		
		int result = 0;
		int n = nums.length;
		for(int i = n - 1; i >= 0; i-- )
		{
			int start = 0, end = i-1;
			
			while(end > start)
				if(nums[start] + nums[end] > nums[i])
				{
					result += end - start;
					end--;
				}
				else
					start++;
		}
		
		return result;
    }
}
