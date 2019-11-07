package com.leetcode.problems;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 *Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 
 */
public class SumOfLeftLeaves {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(sumOfLeftLeaves(root));
		
	}

	private static int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
        	return 0;
        
        int ans = 0;
        if(root.left != null) {
        	if(root.left.left == null && root.left.right == null) ans += root.left.val;
        	else ans += sumOfLeftLeaves(root.left);
        }
        
        ans += sumOfLeftLeaves(root.right);
        
        return ans;
        
    }
}
