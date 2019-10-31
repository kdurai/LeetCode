package com.leetcode.problems;

import java.util.ArrayList;

/*
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		List<String> result = binaryTreePaths(root);
		
		for(String res : result)
			System.out.println(res);
		
	}

	private static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        
        if(root != null) 
        	searchBT(root, "", answer); 
        		
        return answer;
    }

	private static void searchBT(TreeNode root, String string, List<String> answer) {
		if(root.left == null && root.right == null) 
			answer.add(string + root.val);
		
		if(root.left != null)
			searchBT(root.left, string + root.val + "->", answer);
		
		if(root.right != null)
			searchBT(root.right,string + root.val + "->", answer);
		
	}
}
