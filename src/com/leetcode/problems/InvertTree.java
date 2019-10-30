package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			
		}
		
		root = invertTree(root);
	}

	private static TreeNode invertTree(TreeNode root) {
     
		if(root == null)
			return root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			
			if(current.left != null) queue.add(current.left);
			if(current.right != null) queue.add(current.right);
		}
		
		return root;
    }
}
