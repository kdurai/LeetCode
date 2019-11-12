package com.leetcode.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 */

public class MinMoves {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		System.out.println(minMoves(arr));
	}

	private static int minMoves(int[] nums) {
		
		int sum = IntStream.of(nums).sum();
		int minValue = IntStream.of(nums).min().getAsInt();
		
		return sum - minValue * nums.length;
		
        
    }
}
