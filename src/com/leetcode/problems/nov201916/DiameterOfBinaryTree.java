package com.leetcode.problems.nov201916;

import com.leetcode.problems.TreeNode;

/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path 
 * between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
	
	private static int ans;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		
		System.out.println(diameterOfBinaryTree(root));
		
		TreeNode root1 = new TreeNode(2);
		System.out.println(diameterOfBinaryTree(root1));
	}

	private static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }
	
	private static int depth(TreeNode root) {
		
		if(root == null) return 0;
		
		int L = depth(root.left);
		int R = depth(root.right);
		ans = Math.max(ans,  L+R);
		return Math.max(L, R) + 1;
	}
}
