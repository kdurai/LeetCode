package com.leetcode.medium.nov201921;

import com.leetcode.problems.ListNode;

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode current = head;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		
		System.out.println("null");
		
		head = removeNthFromEnd(head ,2);
		
		current = head;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}

		System.out.println("null");
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
        
		if(head == null || n == 0)
			return head;
		
		ListNode current = head;
		ListNode previous = head;
		
		int i = 0;
		
		while(i++ < n)
			current = current.next;

		if(current == null)
		{
			head = previous.next;
			return head;
		}
		
		while(current.next != null)
		{
			previous = previous.next;
			current = current.next;
		}
		
		if(previous != null)
			previous.next = previous.next.next;
		
		return head;
    }
}
