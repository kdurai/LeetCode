package com.leetcode.medium.dec201910;

import java.util.ArrayList;
/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 *  from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {

	 int k = 3;
	 int n = 7;
	 
	 List<List<Integer>> result = combinationSum3(k, n);
	 
	 for(List<Integer> list : result)
		 System.out.println(list);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		backtracking(result, new ArrayList<>(), k, 1, n);
		
		return result;
        
    }

	private static void backtracking(List<List<Integer>> result, List<Integer> list, int k, 
			int start, int end) {
		
		if(list.size() > k)
			return;
		
		if(list.size() == k && end == 0)
		{
			result.add(new ArrayList(list));
			return;
		}
		
		for(int i = start; i <= end && i <= 9; i++)
		{
			list.add(i);
			backtracking(result, list, k, i+1, end-i);
			list.remove(list.size() - 1 );
		}
		
	}
}
