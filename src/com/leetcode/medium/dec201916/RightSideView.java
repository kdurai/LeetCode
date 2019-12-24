package com.leetcode.medium.dec201916;

import java.util.ArrayList;
/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of
 *  the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
 */
import java.util.List;

public class RightSideView {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	};

	public static void main(String[] args) {

	}

	public static List<Integer> rightSideView(TreeNode root) {
        
		List<Integer> result = new ArrayList<>();
		rightView(root, result, 0);
		return result;
    }

	private static void rightView(TreeNode root, List<Integer> result, int i) {
		
		if(root == null)
			return;
		
		if(i == result.size())
			result.add(root.val);
		
		rightView(root.right, result, i+1);
		rightView(root.left, result, i+1);
		
	}
}
