package com.leetcode.problems;

import java.util.Stack;

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
	
	private static int maxDepthIterativeDFS(Node root) {

		if(root == null)
			return 0;
		
		Stack<Node> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;
		
		while(!stack.isEmpty()) {
			
			Node node = stack.pop();
			int depth = value.pop();
			
		}
		
		return max;
    }
	
}
