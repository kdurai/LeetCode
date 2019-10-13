package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.datastructers.Node;

public class MaxLvelSum {

	public static void main(String[] args) {

	}

	public int maxLevelSum(Node root) {
		int max = Integer.MIN_VALUE, maxlevel = 1, level = 1;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int sum = 0;
			
			for(int sz = q.size(); sz > 0; --sz) {
				Node n = q.poll();
				sum += n.val;
				
				if(n.left != null) {
					q.offer(n.left);
				}
				
				if(n.right != null) {
					q.offer(n.right);
				}
				
			}
			
			if (max < sum)
			{
				max = sum;
				maxlevel = level;
			}
			
			level++;
			
		}
		
		return maxlevel;
	}
	
}
