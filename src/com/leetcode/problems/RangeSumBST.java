package com.leetcode.problems;

import com.leetcode.datastructers.Node;

public class RangeSumBST {

	public static void main(String[] args) {

	}
	
	public static int rangeSumBST(Node root, int L, int R) {
		int sum = 0;
		
		if(root.val < L)
		{
			System.out.println("Root is smaller than left value. There won't be ");
			return 0;
		}
		
		return sum;
	}
}
