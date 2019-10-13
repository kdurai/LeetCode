package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 118;
		
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	 private static int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < nums.length; i++) {
	        	int remaining = target - nums[i];
	        	
	        	if(map.get(remaining) != null) 
	        		return new int[] {map.get(remaining), i};
	        	else
	        		map.put(nums[i], i);
	        }
	        
	        throw new IllegalArgumentException("Target value does not exist in the array");
	        
	 }
}
