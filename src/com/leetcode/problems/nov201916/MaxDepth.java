package com.leetcode.problems.nov201916;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

We should return its max depth, which is 3.

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
 * 
 */

public class MaxDepth {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

	public static void main(String[] args) {

		Node root = new MaxDepth().new Node();
		root.val = 1;
		Node child1 = new MaxDepth().new Node();
		child1.val = 2;
		Node child2 = new MaxDepth().new Node();
		child2.val = 3;
		Node child3 = new MaxDepth().new Node();
		child3.val = 4;
		Node child4 = new MaxDepth().new Node();
		child4.val = 5;
		Node child5 = new MaxDepth().new Node();
		child5.val = 6;
		
		List<Node> list2 = new ArrayList<>();
		list2.add(child4);
		list2.add(child5);
		
		child3.children = list2;
		
		List<Node> list1 = new ArrayList<>();
		list1.add(child1);
		list1.add(child2);
		list1.add(child3);

		root.children = list1;
		
		System.out.println(maxDepth(root));
	}
	
	private static int maxDepth(Node root) {
        if(root == null)
        	return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        int height = 0;
        
        while(!queue.isEmpty()) 
        {
        	int size = queue.size();
        	
        	for(int i = 0 ; i < size; i++)
        	{
        		Node current = queue.poll();
        		for(Node node : current.children) queue.offer(node);
        	}
        	
        	height++;
        }
        
        return height;
    }

}
