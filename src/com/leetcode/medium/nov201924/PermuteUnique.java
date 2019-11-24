package com.leetcode.medium.nov201924;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2 };
		
		List<List<Integer>> result = permuteUnique(arr);
		
		System.out.println("Main");
		for(List<Integer> list : result)
			System.out.println(list);
	}
	
	private static List<List<Integer>> permuteUnique(int[] nums) {
        
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
    }

	private static void backtrack(List<List<Integer>> list, List<Integer> arrayList, int[] nums, boolean[] used) {

		if(arrayList.size() == nums.length)
			list.add(new ArrayList<>(arrayList));
		else
			for(int i = 0 ; i < nums.length; i++)
			{
				if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) 
					continue;
				used[i] = true;
				arrayList.add(nums[i]);
				backtrack(list, arrayList, nums, used);
				used[i] = false;
				arrayList.remove(arrayList.size()-1);
			}
	}

}
