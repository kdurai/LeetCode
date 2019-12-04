package com.leetcode.medium.dec201903;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
 */

import java.util.Arrays;

import com.leetcode.medium.dec201903.BuildTree.TreeNode;

public class buildTreePostOrder {
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };

	public static void main(String[] args) {
		int[] postorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode root  = buildTree(inorder, postorder);
		
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder );
    }

	private static TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
		
		if(postEnd < 0 || inStart > inEnd)
			return null;
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		
		for(int i = 0; i <= inorder.length; i++ )
			if(inorder[i] == root.val)
			{
				inIndex = i;
				break;
			}
		
		root.left = helper(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, postorder, inorder);
		root.right = helper(postEnd - 1, inIndex + 1, inEnd, postorder, inorder);
		
		return root;
	}
}
