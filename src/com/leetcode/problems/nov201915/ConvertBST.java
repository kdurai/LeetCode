package com.leetcode.problems.nov201915;

/*
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
          
 */

import com.leetcode.problems.TreeNode;

public class ConvertBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(13);
		root.left = new TreeNode(2);
		
		TreeNode root1 = convertBST(root);
	}

	    /* Get the node with the smallest value greater than this one. */
	    private static TreeNode getSuccessor(TreeNode node) {
	        TreeNode succ = node.right;
	        while (succ.left != null && succ.left != node) {
	            succ = succ.left;
	        }
	        return succ;
	    }

	    private static TreeNode convertBST(TreeNode root) {
	        int sum = 0;
	        TreeNode node = root;

	        while (node != null) {
	            /* 
	             * If there is no right subtree, then we can visit this node and
	             * continue traversing left.
	             */
	            if (node.right == null) {
	                sum += node.val;
	                node.val = sum;
	                node = node.left;
	            }
	            /* 
	             * If there is a right subtree, then there is at least one node that
	             * has a greater value than the current one. therefore, we must
	             * traverse that subtree first.
	             */
	            else {
	                TreeNode succ = getSuccessor(node);
	                /* 
	                 * If the left subtree is null, then we have never been here before.
	                 */
	                if (succ.left == null) {
	                    succ.left = node;
	                    node = node.right;
	                }
	                /* 
	                 * If there is a left subtree, it is a link that we created on a
	                 * previous pass, so we should unlink it and visit this node.
	                 */
	                else {
	                    succ.left = null;
	                    sum += node.val;
	                    node.val = sum;
	                    node = node.left;
	                }
	            }
	        }
	        
	        return root;
	    }
}
