package com.leetcode.medium.dec201906;

import java.util.Arrays;

/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are
 not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border 
 will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or
  vertically.

 */
public class Solve {

	public static void main(String[] args) {

		char[][] board = {
				{'X','X','X','X'},
				{'X','X','O','X'},
				{'X','O','X','X'},
				{'X','O','X','X'}
				};
		System.out.println("Before");
		
		for(char[] array : board)
			System.out.println(Arrays.toString(array));
		
		solve(board);
		
		System.out.println("After");
		for(char[] array : board)
			System.out.println(Arrays.toString(array));
	}

	private static void solve(char[][] board) {
        int row = board.length;
        
        if(row == 0)
        	return;
        
        int col = board[0].length;
        
        for(int i = 0; i <row; i++)
        {
        	check(board, i, 0, row, col);
        	if(col > 1)
        		check(board, i, col - 1, row, col);
        }
        
        for(int j = 1; j + 1 < col; j++)
        {
        	check(board, 0, j, row, col);
        	if(row > 1)
        		check(board, row - 1, j, row, col);
        }
        
        for(int i = 0; i < row; i++)
        	for(int j = 0; j < col; j++)
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        
        for(int i = 0; i < row; i++)
        	for(int j = 0; j < col; j++)
        		if(board[i][j] == '1')
        			board[i][j] = 'O';
    }

	private static void check(char[][] board, int i, int j, int row, int col) {
		
		if(board[i][j] == 'O')
		{
			board[i][j] = '1';
			
			if(i > 1)
				check(board, i-1, j , row, col);
			
			if( j > 1)
				check(board, i, j-1 , row, col);
			
			if(i + 1 < row)
				check(board, i+1, j ,row, col);
			
			if(j + 1 < col)
				check(board, i , j + 1, row, col );
		}
	}
}
