package com.leetcode.problems;

/*
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
import java.util.ArrayList;
import java.util.List;

public class Generate {

	public static void main(String[] args) {

		int numrows = 5;
		
		System.out.println(generate(numrows));
	}

	private static List<List<Integer>> mygenerate(int numRows) {
 
		List<List<Integer>> list = new ArrayList<>();
		
		if(numRows == 0)
			return null;
		
		if(numRows >= 1)
		{
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			list.add(temp);
		}
		
		if(numRows >= 2)
		{
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			temp.add(1);
			list.add(temp);
		}
		
		for(int i = 2; i < numRows; i++) {
			List<Integer> temp = list.get(i-1);
			
			List<Integer> l = new ArrayList<>();
			l.add(1);
			int prev = 1;
			for(int j = 1; j < temp.size(); j++) {
				int num = temp.get(j);
				int sum = num + prev;
				l.add(sum);
				prev = num;
			}
			
			l.add(1);
			list.add(l);
			
		}
		
		return list;
    }

	private static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < numRows; i++) {
			
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
		return result;
		
	}
}
