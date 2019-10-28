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
	 
	 private static int[] twoSumAlt(int[] numbers, int target) {
		 
		    int[] result = new int[2];
		    
		    if(numbers == null || numbers.length < 2)
		 		return result;
		    
		    int left = 0; 
		    int right = numbers.length - 1;
	        
	        while(left < right) {
	        	
	        	int total = numbers[left] + numbers[right];
	        	
	        	if(total == target) {
	        		result[0] = left + 1;
	        		result[1] = right + 1;
	        		break;
	        	}
	        	
	        	if(total > target)
	        		right--;
	        	else
	        		left++;
	        	
	        }
	        
	        return result;
	        
	 }
}
