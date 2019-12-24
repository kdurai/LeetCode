package com.leetcode.contest.dec201908;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four 
 *neighbours of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called 
 *neighboors if they share one edge.

Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.

Binary matrix is a matrix with all cells equal to 0 or 1 only.

Zero matrix is a matrix with all cells equal to 0.

Example 1:

Input: mat = [[0,0],[0,1]]
Output: 3
Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.
Example 2:

Input: mat = [[0]]
Output: 0
Explanation: Given matrix is a zero matrix. We don't need to change it.
Example 3:

Input: mat = [[1,1,1],[1,0,1],[0,0,0]]
Output: 6
Example 4:

Input: mat = [[1,0,0],[1,0,0]]
Output: -1
Explanation: Given matrix can't be a zero matrix
 

Constraints:

m == mat.length
n == mat[0].length
1 <= m <= 3
1 <= n <= 3
mat[i][j] is 0 or 1.
 
*/

public class MinFlips {

	public static void main(String[] args) {

		int[][] mat = {
				{0,0},
				{0,1}
		};
		
		System.out.println(minFlips(mat));
	}
	
	public static int minFlips(int[][] mat) {
		
		int m = mat.length;
		int n = mat[0].length;
		Map<String, Integer> map = new HashMap<>();
		int ans = func(mat, m, n, new HashSet<>(), map);
		return ans == Integer.MAX_VALUE ? -1 : ans;
    }

	private static int func(int[][] mat, int m, int n, Set<String> set, Map<String, Integer> map) {
		
		if(check(mat, m, n))
			return 0;
		
		String t = "";
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				t += String.valueOf(mat[i][j]);
		
		if(map.containsKey(t))
			return map.get(t);
		
		if(set.contains(t))
			return Integer.MAX_VALUE;
		
		set.add(t);
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
			{
				mat[i][j] = mat[i][j] ^ 1;
				
				if(i - 1 >= 0)
					mat[i-1][j] ^= 1;
				if(j - 1 >= 0)
					mat[i][j-1] ^= 1;
				if(i + 1 < n)
					mat[i+1][j] ^= 1;
				if(j + 1 < m)
					mat[i][j+1] ^= 1;
				
				int small = func(mat, m, n, set, map);
				System.out.println("small = " + small + " min = " + min);
				if(small != Integer.MAX_VALUE)
					min = Math.min(min, 1 + small);
				
				mat[i][j] = mat[i][j] ^ 1;
				
				if(i - 1 >= 0)
					mat[i-1][j] ^= 1;
				if(j - 1 >= 0)
					mat[i][j-1] ^= 1;
				if(i + 1 < n)
					mat[i+1][j] ^= 1;
				if(j + 1 < m)
					mat[i][j+1] ^= 1;
			}
		
		set.remove(t);
		map.put(t, min);
		return min;
	}

	private static boolean check(int[][] mat, int m, int n) {
		
		for(int i = 0; i < m; i++ )
			for(int j = 0; j < n; j++)
				if(mat[i][j] == 1)
						return false;
		return true;
	}

}
