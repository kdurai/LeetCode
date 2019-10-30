package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {

	public static void main(String[] args) {

		int[] arr = {1,2,3,1};
		int k = 3;
		System.out.println(containsNearbyDuplicate(arr,k));
		int[] arr1 = {1,0,1,1};
		k = 1;
		System.out.println(containsNearbyDuplicate(arr1,k));
	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {

		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			if( i > k )
				hs.remove(nums[i - k - 1]);
			if(!hs.add(nums[i]))
				return true;
		}
		
		return false;
    }
}
