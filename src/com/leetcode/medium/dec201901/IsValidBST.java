package com.leetcode.medium.dec201901;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */
public class IsValidBST {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

	}

	private static boolean isValidBST(TreeNode root) {
        
		Deque<TreeNode> stack = new LinkedList<>();
		
		TreeNode prev = null;
		
		while(root != null || !stack.isEmpty())
		{
			if(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			else
			{
				root = stack.pop();
				
				if(prev != null && prev.val <= root.val)
					return false;
				
				prev = root;
				
				root = root.right;
			}
		}
		
		return true;
    }
}
