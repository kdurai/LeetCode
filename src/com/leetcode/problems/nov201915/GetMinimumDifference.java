package com.leetcode.problems.nov201915;

import com.leetcode.problems.TreeNode;

/*
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:


Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 

Note: There are at least two nodes in this BST.
 */
public class GetMinimumDifference {

	private static int min = Integer.MAX_VALUE;
	private static Integer prev = null;
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		
		System.out.println(getMinimumDifference(root));
	}

	private static int getMinimumDifference(TreeNode root) {
        if(root == null)
        	return min;
        
        getMinimumDifference(root.left);
        
        if(prev != null)
        	min = Math.min(min,  root.val-prev);
        
        prev = root.val;

        getMinimumDifference(root.right);
        
        return min;
    }
}
