package com.leetcode.problems.nov201920;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Given a non-empty binary tree, return the average value of the nodes on each level in the 
 * form of an array.
	Example 1:
	Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.

 */
import java.util.List;
import java.util.Queue;

import com.leetcode.problems.TreeNode;

public class AverageOfLevels {

	public static void main(String[] args) {
			TreeNode root = new TreeNode(3);
			root.left = new TreeNode(9);
			root.right = new TreeNode(20);
			root.right.left = new TreeNode(15);
			root.right.right = new TreeNode(7);
			System.out.println(averageOfLevels(root));
			System.out.println(averageOfLevelsDFS(root));
	}

	private static List<Double> averageOfLevels(TreeNode root) {
		
        List<Double> list = new ArrayList<>();
        
		if(root == null)
			return list;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			for(int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				sum += temp.val;
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			
			list.add(sum/size);
		}
		
		return list;
    }
	
	private static List<Double> averageOfLevelsDFS(TreeNode root) {
		
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        
		if(root == null)
			return result;
		
		average(root, 0, result, count);
		
		for(int i = 0 ; i < result.size(); i++)
			result.set(i, result.get(i)/count.get(i));
		
		return result;
    }

	private static void average(TreeNode root, int i, List<Double> result, List<Integer> count) {
		if(root == null)
			return;
		
		if(i < result.size())
		{
			result.set(i, result.get(i) + root.val);
			count.set(i, count.get(i) + 1);
		}
		else {
			result.add(1.0 * root.val);
			count.add(1);
		}
		
		average(root.left, i+1, result, count);
		average(root.right, i+1, result, count);
	}
	
	
}
