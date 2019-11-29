package com.leetcode.medium.nov201929;
/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

public class Exist {

	char[][] board;
	char[] word;
	int n;
	int m;
	public static void main(String[] args) {

		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		String word = "ABCCED";
		
		System.out.println(new Exist().exist(board, word));
	}

	private boolean exist(char[][] board, String word) {
		
		this.board = board;
		this.word = word.toCharArray();
		this.m = board.length;
		this.n = board[0].length;
		
		if(m == 0 )
			return false;
		
		boolean result = false;
		
		for(int i = 0; i < m; i++)
			for(int j = 0; j<n; j++)
				if(dfs(i, j,0))
					return true;
		
		return result;
    }

	private boolean dfs(int i, int j, int index) {
		
		if(i < 0 || i >= m || j < 0 || j >= n)
			return false;
		
		if(board[i][j] != word[index])
			return false;
		
		if(index == word.length - 1)
			return true;
		
		char tmp = board[i][j];
		board[i][j] = '$';
		if(dfs(i+1, j, index+1))
			return true;
		
		if(dfs(i, j+1, index+1))
			return true;
		
		if(dfs(i-1, j, index+1))
			return true;
		
		if(dfs(i, j-1, index+1))
			return true;
		
		board[i][j] = tmp;
		
		return false;
	}
}
