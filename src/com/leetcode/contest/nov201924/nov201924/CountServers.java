package com.leetcode.contest.nov201924;

/*
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that 
 * on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if 
 * they are on the same row or on the same column.

Return the number of servers that communicate with any other server.

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.

Example 2:
Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.

Example 3:
Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third 
column can communicate with each other. The server at right bottom corner can't communicate with any other 
server.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1

*/

public class CountServers {

	public static void main(String[] args) {

		int[][] grids1 = { { 1, 0 }, { 0, 1 } };
		System.out.println(countServers(grids1));

		int[][] grids2 = { { 1, 0 }, { 1, 1 } };
		System.out.println(countServers(grids2));

		int[][] grids3 = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		System.out.println(countServers(grids3));

	}

	private static int countServers(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;
		int[] rowCount = new int[rows];
		int[] colCount = new int[cols];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == 1) {
					rowCount[i]++;
					colCount[j]++;
				}
		
		int totalServers = 0;
		
		for (int i = 0; i < rows; i++)
		{
			if(rowCount[i] > 1)
				totalServers += rowCount[i];
			else if (rowCount[i] == 1)
			{
				for (int j = 0; j < cols; j++)
					if (grid[i][j] == 1)
					{
						if (colCount[j] > 1)
							totalServers++;
						break;
					}
			}
		}
		return totalServers;
	}
}
