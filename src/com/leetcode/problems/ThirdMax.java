package com.leetcode.problems;

import java.util.Arrays;
import java.util.TreeSet;

/*
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 */

public class ThirdMax {

	public static void main(String[] args) {

		int[] arr = {3,2,1};
		System.out.println(thirdMax(arr));
	}

	private static int thirdMax(int[] nums) {
        
		if(nums.length < 3)
			return nums[0] > nums[1] ? nums[0]: nums[1];
		
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0 ; i < nums.length; i++) 
			set.add(nums[i]);

		if(set.size() < 3)
			return set.last();
		
		set.remove(set.last());
		set.remove(set.last());
		return set.last();
		
    }
	
}
