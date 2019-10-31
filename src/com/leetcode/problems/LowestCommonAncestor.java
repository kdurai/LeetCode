package com.leetcode.problems;

public class LowestCommonAncestor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		System.out.println(lowestCommonAncestor(root, p, q ).val);
	}
	
	 private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	     
		 if(root == null)
			 return root;
		 
		 int pVal = p.val;
		 int qVal = q.val;
		 
		 while(root != null) {
			 
			 int parentVal = root.val;
			 
			 if(qVal < parentVal && qVal < parentVal) {
				 root = root.left;
			 }
			 else if(qVal < parentVal && qVal < parentVal) {
				 root = root.right;
			 }
			 else
				 return root;
		 }
		 
		 return null;
	 }
	 
	 private static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
	     
		 return (root.val - p.val) * (root.val - q.val) < 0 ? root: lowestCommonAncestorRecursive(p.val < root.val ? root.left:root.right, p, q);
	 }

}
