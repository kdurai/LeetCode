package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.datastructers.BinarySearchTree;
import com.leetcode.datastructers.Node;

public class IsSymmetric {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(5);
		bst.insert(3);
		
		System.out.println(isSymmetric(bst.getRoot()));
		System.out.println(isSymmetricIteration(bst.getRoot()));
	}

	private static boolean isSymmetric(Node root) {
        
		return root == null || isSymmetricHelp(root.left, root.right);
    }

	private static boolean isSymmetricHelp(Node left, Node right) {
		
		if(left == null || right == null)
			return left == right;
		else if(left.val != right.val)
			return false;
		
		return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
	}
	
	private static boolean isSymmetricIteration(Node root) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		
		while(!queue.isEmpty()) {
		
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null || right == null)
				return left == right;
			
			if(left.val != right.val)
				return false;
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		
		return true;
		
		
	}
	
}
