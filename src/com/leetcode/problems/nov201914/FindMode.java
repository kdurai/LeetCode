package com.leetcode.problems.nov201914;

import java.util.Arrays;

import com.leetcode.problems.TreeNode;

/*
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

 */

public class FindMode {
	
	private static int[] modes;
	private static int maxCount = 0;
	private static int modeCount = 0;
	private static int currCount = 0;
	private static int currVal;

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(2);
		
		System.out.println(Arrays.toString(findMode(node)));
		
	}

	private static int[] findMode(TreeNode root) {
		inOrder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inOrder(root);
		return modes;
    }
	
	private static void inOrder(TreeNode root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		handleValue(root.val);
		inOrder(root.right);
	}

	private static void handleValue(int val) {
		
		if(val != currVal) {
			currVal = val;
			currCount = 0;
		}
		
		currCount++;
		
		if(currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		}
		else if(currCount == maxCount) {
			if(modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
		
	}
}
