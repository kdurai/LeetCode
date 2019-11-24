package com.leetcode.medium.nov201924;

import java.util.ArrayList;
import java.util.List;

public class Pernute {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		
		List<List<Integer>> result = permute(arr);
		
		System.out.println("Main");
		for(List<Integer> list : result)
			System.out.println(list);
	}
	
	 private static List<List<Integer>> permute(int[] nums) {
	 
		 List<List<Integer>> result = new ArrayList<>();
		 
		 backtrack(result, new ArrayList<>(), nums);
		 
		 return result;
	 }

	private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
		
		if(list.size() == nums.length)
			result.add(new ArrayList<>(list));
		else
			for(int i = 0; i < nums.length; i++)
			{
				if(list.contains(nums[i]))
					continue;
				list.add(nums[i]);
				backtrack(result, list, nums);
				list.remove(list.size() - 1);
			}
		
	}

}
