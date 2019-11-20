package com.leetcode.problems.nov201920;

/*
 * Given an array consisting of n integers, find the contiguous subarray of given length k that
 *  has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

 */
public class FindMaxAverage {

	public static void main(String[] args) {

		int[] arr = {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage(arr, k));
		System.out.println(findMaxAverageAlternate(arr, k));
	}

	private static double findMaxAverage(int[] nums, int k) {
        
		int[] sums = new int[nums.length];
		
		sums[0] = nums[0];
		for(int i = 1; i < nums.length; i++ )
			sums[i] = nums[i] + sums[i-1];
		
		double result = sums[k-1] * 1.0 / k;
		for(int i = k; i < sums.length; i++)
			result = Math.max(result, (sums[i] - sums[i - k]) * 1.0/k);
		
		return result;
    }
	
	private static double findMaxAverageAlternate(int[] nums, int k) {
        
		double sum = 0;
		
		for(int i = 0; i < k; i++)
			sum = sum + nums[i];
		
		double result = sum;
		
		for(int i = k; i < nums.length; i++)
		{
			sum += nums[i] - nums[ i - k];
			result = Math.max(result, sum);
		}
		return result/k;
    }
}
