package com.leetcode.medium.dec201905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent 
 * numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows 
in the triangle.

 */
public class MinimumTotal {

	public static void main(String[] args) {

		List<List<Integer>> numbers = new ArrayList<>();
		List<Integer> int1 = new ArrayList<>();
		int1.add(2);
		List<Integer> int2 = new ArrayList<>();
		int2.add(3);
		int2.add(4);
		List<Integer> int3 = new ArrayList<>();
		int3.add(6);
		int3.add(5);
		int3.add(7);
		List<Integer> int4 = new ArrayList<>();
		int4.add(4);
		int4.add(1);
		int4.add(8);
		int4.add(3);
		numbers.add(int1);
		numbers.add(int2);
		numbers.add(int3);
		numbers.add(int4);
		System.out.println(minimumTotal(numbers));
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		
		int[] dp = new int[triangle.size() + 1];
		
		for(int i = triangle.size()-1; i >= 0; i--)
			for(int j = 0; j < triangle.get(i).size(); j++)
				dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        
		return dp[0];
    }
}
