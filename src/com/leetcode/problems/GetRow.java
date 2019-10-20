package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * iven a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */
public class GetRow {

	public static void main(String[] args) {

		int numrows = 5;
		
		System.out.println(getRow(numrows));
		System.out.println(myGetRow(3));
	}

	private static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < rowIndex + 1; i++) {
			
			List<Integer> list = new ArrayList<>();
			
			for(int j = 0; j < i + 1; j++) {
				
				if( j == 0 || i == j) {
					list.add(1);
				}
				else 
				{
					int a = result.get(i - 1).get( j -1);
					int b = result.get(i - 1).get( j);
					list.add(a + b);
				}
			}
			
			result.add(list);
		}
		return result.get(rowIndex);
	}
	
	private static List<Integer> myGetRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		
		if(rowIndex < 0)
			return null;
		
		for(int i = 0; i < rowIndex + 1; i++) {
			result.add(0,1);
			for(int j = 1; j < result.size() - 1; j++)
				result.set(j, result.get(j) + result.get(j + 1));
		}
		
		return result;
	}
}
