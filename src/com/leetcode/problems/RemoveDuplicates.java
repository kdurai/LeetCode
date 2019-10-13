package com.leetcode.problems;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));
	}
	
	 private static int removeDuplicates(int[] nums) {
		 
		 if(nums.length == 0) return 0;
	        
		 int i = 0;
		 for(int j = 1; j < nums.length; j++) {
			 if(nums[j] != nums[i]) {
				 i++;
				 nums[i] = nums[j];
			 }
		 }
		 
		 return i+1;
	 }	

}
