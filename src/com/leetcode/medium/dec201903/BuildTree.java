package com.leetcode.medium.dec201903;

import java.util.Arrays;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
 */

public class BuildTree {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode root  = buildTree(preorder, inorder);
		
		System.out.println(Arrays.toString(preorder));
		
		while(root != null)
		{
			System.out.println(root.val);
			
			if(root.left != null)
				root = root.left;
			else
				root = root.right;
		}
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		return helper(0, 0, inorder.length - 1, preorder, inorder );
		
    }

	private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		
		if(preStart > preorder.length - 1 || inStart > inEnd  )
			return null;
		
		TreeNode root = new TreeNode(preorder[preStart]);
		
		int inIndex = 0;
		
		for(int i = 0 ; i < inorder.length; i++)
			if(inorder[i] == root.val)
			{
				inIndex = i;
				break;
			}
						
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1,inEnd, preorder, inorder);
		return root;
	}
}
