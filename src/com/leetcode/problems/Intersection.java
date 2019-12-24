package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.

 */
public class Intersection {

	public static void main(String[] args) {

		int[] arr1 = {1,2,2,1};
		int[] arr2 = {2,2};
		
		System.out.println(Arrays.toString(intersection(arr1, arr2)));
	}

	private static int[] intersection(int[] nums1, int[] nums2) {
        
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < nums1.length; i++)
			for(int j = 0; j < nums2.length; j++) {
				if(set.contains(nums1[i]) && nums1[i] == nums2[j])
					set.add(nums1[i]);
			}
		
		int[] result = new int[set.size()];
		
		int i = 0;
		Integer[] nums = (Integer[]) set.toArray();
		for(int num : nums) {
			result[i] = num;
			i++;
		}
		
		return result;
    }
}
