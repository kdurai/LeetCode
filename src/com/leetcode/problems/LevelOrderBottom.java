package com.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) 
		{
			this.val = val;
		}
	}

	public static void main(String[] args) {

		LevelOrderBottom instance = new LevelOrderBottom();
		LevelOrderBottom.TreeNode root = instance.new TreeNode(3);
		root.left = instance.new TreeNode(9);
		root.right = instance.new TreeNode(20);
		root.right.left = instance.new TreeNode(15);
		root.right.right = instance.new TreeNode(7);
		
		System.out.println(levelOrderBottomDFS(root));
	}
	
	private static List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        
		Queue<TreeNode> queue = new LinkedList<>();
		
		List<List<Integer>> result = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<>();
			for(int i = 0; i < levelNum; i++) 
			{
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			result.add(0,subList);
		}
		
		return result;
		
		
    }
	
	private static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        
		List<List<Integer>> result = new LinkedList<>();
		levelMaker(result, root, 0);
		return result;
    }

	private static void levelMaker(List<List<Integer>> result, TreeNode root, int i) {
		
		if(root == null)
			return;
		
		if(i >= result.size())
			result.add(0, new LinkedList<Integer>());
		
		
		levelMaker(result, root.left,i + 1);
		levelMaker(result, root.right,i + 1);
		result.get(result.size() - i - 1).add(root.val);
		
	}

}
