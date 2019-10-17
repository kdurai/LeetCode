package com.leetcode.medium;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect {

	public static void main(String[] args) {
		
		Node root = new Node();
	}
	
	private static Node connect(Node root) {
        
		Node level_start = root;
		
		while(level_start != null) {
		
			Node curr = level_start;
			
			while(curr != null) {
				if(curr.left != null) curr.left.next  = curr.right;
				if(curr.right != null && curr.left != null) curr.right.next = curr.next.left;
				curr = curr.next;
			}
			
			level_start = level_start.left;		
		}
		
		return root;
    }
	
}
