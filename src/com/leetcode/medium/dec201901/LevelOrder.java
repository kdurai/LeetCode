package com.leetcode.medium.dec201901;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right,
 *  level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.problems.TreeNode;

public class LevelOrder {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

	}
	
	private List<List<Integer>> levelOrder(TreeNode root) {
     
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			int numOfNodesAtLevel  = queue.size();
		
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0 ; i < numOfNodesAtLevel; i++) {
				if(queue.peek().left != null)
					queue.offer(queue.peek().left);
				if(queue.peek().right != null)
					queue.offer(queue.peek().right);
				list.add(queue.poll().val);
			}
			
			result.add(list);
		}
		
		return result;
    }

}
