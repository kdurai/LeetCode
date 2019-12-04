package com.leetcode.medium.dec201903;

import java.util.Deque;
import java.util.LinkedList;

import com.leetcode.medium.dec201903.PathSum.TreeNode;

/*
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
          
 */
public class Flatten {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	 static TreeNode previous = null;
	 
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flatten(root);
	}

	private static void flatten(TreeNode root) {
		if(root == null)
			return;
		
		flatten(root.right);
		flatten(root.left);
		root.right = previous;
		root.left = null;
		previous = root;
    }
	
}
