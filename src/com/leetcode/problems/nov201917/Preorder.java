package com.leetcode.problems.nov201917;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Follow up:

Recursive solution is trivial, could you do it iteratively?

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 

Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]

 */
public class Preorder {
	
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

		Node root = new Preorder().new Node();
		root.val = 1;
		Node child1 = new Preorder().new Node();
		child1.val = 3;
		Node child2 = new Preorder().new Node();
		child2.val = 2;
		Node child3 = new Preorder().new Node();
		child3.val = 4;
		Node child4 = new Preorder().new Node();
		child4.val = 5;
		Node child5 = new Preorder().new Node();
		child5.val = 6;
		
		List<Node> list2 = new ArrayList<>();
		list2.add(child4);
		list2.add(child5);
		
		child1.children = list2;
		
		List<Node> list1 = new ArrayList<>();
		list1.add(child1);
		list1.add(child2);
		list1.add(child3);

		root.children = list1;
		
		System.out.println(preorder(root));
	}

	
	 private static List<Integer> preorder(Node root) {
	        List<Integer> list = new ArrayList<>();
	        
	        if(root == null)
	            return list;
	        
	        Stack<Node> stack = new Stack<>();
	        stack.push(root);
	        
	        while(!stack.isEmpty())
	        {
	            Node node = stack.pop();
	            list.add(node.val);
	            for(int i = node.children.size() - 1; i >= 0; i--)
	            {
	                stack.push(node.children.get(i));
	            }
	        }
	        
	        return list;
	    }
	
}
