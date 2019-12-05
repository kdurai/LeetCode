package com.leetcode.medium.dec201905;

import com.leetcode.medium.dec201903.Connect.Node;

/*
 *Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next 
pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this
 problem.
 

Example 1:

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to
 point to its next right node, just like in Figure B. The serialized output is in level order as
  connected by the next pointers, with '#' signifying the end of each level.
 
 */

public class Connect {

	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		connect(root);
	}

	private static Node connect(Node root) {
        
		Node head = null;
		Node previous = null;
		Node current = root;
		
		while(current != null)
		{
			
			while(current != null) 
			{
				if(current.left != null)
				{
					if(previous != null)
						previous.next = current.left;
					else
						head = current.left;
					
					previous = current.left;
				}
				
				if(current.right != null)
				{
					if(previous != null)
						previous.next = current.right;
					else
						head = current.right;
					
					previous = current.right;
				}
				
				current = current.next;
							
			}
			
			current = head;
			head = null;
			previous = null;
		}
		
		return root;
    }
}
