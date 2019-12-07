package com.leetcode.medium.dec201907;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.medium.dec201906.CloneGraph.Node;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to
 *  any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

 */

public class CopyRandomList {
	
	static class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};

	private static Map<Integer, Node> map = new HashMap<>();
	
	public static void main(String[] args) {

	}

	private static Node copyRandomList(Node head) {
		
		if(head == null)
			return head;
		
		Node c = head;
		
		while(c != null)
		{
			Node next = c.next;
			c.next = new Node();
			c.next.val = c.val;
			c.next.next = next;
			c = next;
		}
		
		c = head;
		
		while(c != null)
		{
			if(c.random != null)
				c.next.random = c.random.next;
			c = c.next.next;
		}
		
		c = head;
		Node copyHead = head.next;
		Node copy = copyHead;
		
		while(copy.next != null)
		{
			c.next = c.next.next;
			c = c.next;
			
			copy.next = copy.next.next;
			copy = copy.next;
		}
		
		c.next = c.next.next;
		
		return copyHead;
    }
}
