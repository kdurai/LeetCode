package com.leetcode.medium.dec201912;

/*
 * Given an array of integers and an integer k, you need to find the total number of 
 * continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is
 [-1e7, 1e7].

 */
public class SubarraySum {

	public static void main(String[] args) {

		int[] nums = { 4, 5, 8};
		System.out.println(subarraySum(nums, 13));
	}

	public static int subarraySum(int[] nums, int k) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
        int count= 0 ; 
        int sum = 0;
    
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            
            if(map.containsKey(sum - k))
                count += map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
