package com.leetcode.medium.dec201901;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to 
 * right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

	}
	
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		int size = 1;
		boolean order = true;
		
		while(!queue.isEmpty())
		{
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0 ; i < size; i++ ) 
			{
				if(queue.peek().left != null)
					queue.offer(queue.peek().left);
				
				if(queue.peek().right != null)
					queue.offer(queue.peek().right);
				
				if(order)
					list.add(queue.poll().val);
				else
					list.add(0,queue.poll().val);
			}
			result.add(list);
			size = queue.size();
			order = order ? false : true;
		}
		
		return result;
	}

}
