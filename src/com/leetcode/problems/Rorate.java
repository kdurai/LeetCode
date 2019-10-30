package com.leetcode.problems;

import java.util.Arrays;

public class Rorate {

	public static void main(String[] args) {

		int[] arr = {1,2};
		
		System.out.println(Arrays.toString(arr));
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] nums, int k) {
        
		if(nums == null || nums.length == 0 )
			return;
		
		for(int i = 1; i <= k; i++)
		{
			int temp = nums[nums.length - 1];
			int j = nums.length;
			for(; j > 1; j-- )
				nums[j-1] = nums[j-2];
			nums[0] = temp;
		}
    }
}
