package com.leetcode.medium.dec201901;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 
 * 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 */
public class GenerateTrees {

	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

	}

	private static List<TreeNode> generateTrees(int n) {
		if(n < 1)
            return new ArrayList<>();
		return helper(1, n);
    }

	private static List<TreeNode> helper(int start, int end) {
		
		List<TreeNode> result = new ArrayList();
		if(start > end) {
			result.add(null);
			return result;
		}
		
		if(start == end) {
            result.add(new TreeNode(start));
            return result;
        }
		
		for(int i = start; i <= end; i++)
		{
			List<TreeNode> leftSubTree = helper(start, i-1);
			List<TreeNode> rightSubTree = helper(i+1, end);
			
			for(TreeNode left: leftSubTree)
				for(TreeNode right: rightSubTree)
					{
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						result.add(root);
					}
		}
		return result;
	}
}
