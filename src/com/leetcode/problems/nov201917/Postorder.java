package com.leetcode.problems.nov201917;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.problems.nov201917.Preorder.Node;

/*
 * Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Follow up:

Recursive solution is trivial, could you do it iteratively?

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Explanation: Representation of 3-ary tree.
Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 
Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
 */

public class Postorder {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

	public static void main(String[] args) {

	}
	
	private static List<Integer> postorder(Node root) {
        
		List<Integer> list = new ArrayList<>();
		
		if(root == null)
			return list;
		
		Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        Stack<Integer> result = new Stack<>();
        
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            result.push(node.val);
            for(int i = 0; i < node.children.size(); i++)
                stack.push(node.children.get(i));
        }
        
        while(!result.isEmpty())
        	list.add(result.pop());
        
        return list;
    }

}
