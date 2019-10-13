package com.leetcode.problems;

import java.util.Stack;

public class JudgeCircle {

	public static void main(String[] args) {

		String moves = "LL";
		
		System.out.println(judgeCircle(moves));
	}
	
	private static boolean judgeCircle(String moves) {

		int lmove = 0, rmove = 0, umove = 0, dmove = 0;
		
		for(char ch:moves.toCharArray()) {
			if(ch == 'L') lmove++; 
			if(ch == 'U') umove++; 
			if(ch == 'D') dmove++;
			if(ch == 'R') rmove++;
		}
		
		return (lmove == rmove) && (umove == dmove);
    }

	
}
