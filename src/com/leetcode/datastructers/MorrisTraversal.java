package com.leetcode.datastructers;

import com.leetcode.problems.TreeNode;

public class MorrisTraversal {

	public static void main(String[] args) {

	}

	public void inOrder(TreeNode root) {
	
		TreeNode current = root;
		
		while(current != null) {
			
			if(current.left == null) {
				System.out.println(current.val + " ");
				current = current.right;
			}
			else
			{
				TreeNode predecessor = current.left;
				
				while(predecessor.right != current && predecessor != null)
					predecessor = predecessor.right;
				
				if(predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				}
				else
				{
					predecessor.right = null;
					System.out.println(current.val + " ");
					current = current.right;
				}
			}
		}
	}
	
}
