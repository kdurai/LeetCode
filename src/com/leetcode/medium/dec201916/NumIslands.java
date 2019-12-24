package com.leetcode.medium.dec201916;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 */

public class NumIslands {

	public static void main(String[] args) {

	}

	public static int numIslands(char[][] grid) {
		
		if(grid == null || grid.length == 0)
            return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				if(grid[i][j] == '1')
				{
					dfs(grid, i, j, m, n);
					++count;
				}
		
		return count;
    }

	private static void dfs(char[][] grid, int i, int j, int m, int n) {
		
		if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
			return;
		
		grid[i][j] = '0';
		
		dfs(grid, i-1, j, m, n);
		dfs(grid, i+1, j, m, n);
		dfs(grid, i, j-1, m, n);
		dfs(grid, i, j+1, m, n);
	}
	
}
