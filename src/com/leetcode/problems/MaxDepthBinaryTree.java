package com.leetcode.problems;

import com.leetcode.datastructers.BinarySearchTree;
import com.leetcode.datastructers.Node;
/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */

public class MaxDepthBinaryTree {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(5);
		bst.insert(3);
		
		System.out.println(maxDepth(bst.getRoot()));
	}

	private static int maxDepth(Node root) {
		
		return root == null ? 0: 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
