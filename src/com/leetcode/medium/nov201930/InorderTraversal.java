package com.leetcode.medium.nov201930;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
	
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	public static void main(String[] args) {

	}

	private static List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> result = new ArrayList<>();
		
		Deque<TreeNode> queue = new LinkedList<>();
		
		while(root != null || !queue.isEmpty())
		{
			if(root != null)
			{
				queue.push(root);
				root = root.left;
				
			}
			else
			{
				root = queue.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		
		return result;
    }
}
