package com.leetcode.problems.nov201919;

import java.util.Stack;

import com.leetcode.problems.TreeNode;

/*
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the
 *  two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node 
values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new 
tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.
 * 
 */
public class MergeTrees {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		TreeNode T = mergeTrees(t1, t2);;
		T = t1;
		 Stack<TreeNode> stack = new Stack<>();
		stack.push(T);
		while(T != null || !stack.isEmpty()) {
			if(T != null)
			{
				stack.push(T.left);
				System.out.print(T.val + " ");
				T = T.left;
			}
			else
			{
				T = stack.pop();
				T = T.right;
			}
		} 
		
	}

	private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
		if(t1 == null)
			return t2;
		
		Stack<TreeNode[]> stack = new Stack<>();
		stack.push(new TreeNode[]{t1,t2});
		
		while(!stack.isEmpty())
		{
			TreeNode[] t = stack.pop();
			
			/*
			 * if(t[0] != null) System.out.print("t[0].val: " + t[0].val);
			 * 
			 * if(t[1] != null) System.out.print("t[1].val: " + t[1].val);
			 */
			
			System.out.println();
			
			if(t[0] == null || t[1] == null)
				continue;
			
			t[0].val += t[1].val;
			
			if(t[0].left == null)
				t[0].left = t[1].left;
			else
				stack.push(new TreeNode[] {t[0].left, t[1].left });
			
			if(t[0].right == null)
				t[0].right = t[1].right;
			else
				stack.push(new TreeNode[] {t[0].right,t[1].right});
		}
		
		return t1;
    }
	
}
