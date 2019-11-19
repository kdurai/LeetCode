package com.leetcode.problems.nov201919;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.leetcode.problems.TreeNode;

/*
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

 */

public class Tree2str {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		
		System.out.println(tree2str(root));
		System.out.println(tree2strIterative(root));
	}
	
	private static String tree2str(TreeNode t) {
        if(t == null)
        	return "";
        
        if(t.left == null && t.right == null)
        	return t.val + "";
        
        if(t.right == null)
        	return t.val + "(" + tree2str(t.left) + ")";
        
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        
    }

	private static String tree2strIterative(TreeNode t) {
        if(t == null)
        	return "";
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
        	t = stack.peek();
        	if(visited.contains(t)) {
        		stack.pop();
        		sb.append(")");
        	}
        	else
        	{
        		visited.add(t);
        		sb.append("(" + t.val);
        		if(t.left == null  && t.right != null)
        			sb.append("()");
        		if(t.right != null)
        			stack.push(t.right);
        		if(t.left != null)
        			stack.push(t.left);
        	}
        }
        
        return sb.substring(1, sb.length() - 1);
    }
}
