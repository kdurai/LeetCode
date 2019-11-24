package com.leetcode.medium.nov201924;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique 
 * combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

 */
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {

		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = combinationSum2(candidates, target);
		
		System.out.println("Main");
		for(List<Integer> list : result)
			System.out.println(list);
	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(result, new ArrayList<>(), candidates, target, 0);
		return result;
    }

	private static void backtrack(List<List<Integer>> result, List<Integer> arrayList, int[] candidates, 
			int remaining, int start) {
		
		if(remaining < 0)
			return;
		else if (remaining == 0) 
			result.add(new ArrayList<>(arrayList));
		else
			for(int i=start; i<candidates.length; i++) {
				if( i > start && candidates[i] == candidates[i-1])
					continue;
				arrayList.add(candidates[i]);
				backtrack(result, arrayList, candidates, remaining-candidates[i], i+1);
				arrayList.remove(arrayList.size() - 1);
			}
				
	}
}
