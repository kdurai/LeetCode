package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

 */
public class UniqueOccurrences {

	public static void main(String[] args) {
		int[] arr = {1,2,2,3,3,3};
		System.out.println(uniqueOccurrences(arr));
	}

	private static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i< arr.length; i++)
			map.put(arr[i], ( 1 + map.getOrDefault(arr[i], 0) ));
		
		return map.size() == (new HashSet(map.values())).size();
	}
}
