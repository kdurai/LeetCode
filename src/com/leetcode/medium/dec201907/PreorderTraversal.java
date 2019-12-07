package com.leetcode.medium.dec201907;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

	static public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	};
	
	public static void main(String[] args) {

	}

	 private static List<Integer> preorderTraversal(TreeNode root) {
	  
		 List<Integer> list = new LinkedList<>();
		 Deque<TreeNode> queue = new ArrayDeque<>();
		 
		 while(root != null)
		 {
			 list.add(root.val);
			 if(root.right != null)
				 queue.offer(root.right);
			 root = root.left;
			 if(root == null && !queue.isEmpty())
				 root = queue.pollLast();
		 }
		 return list;
	 }
}
