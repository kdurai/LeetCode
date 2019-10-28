package com.leetcode.problems;

/*
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

public class RemoveElements {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(7);
		int val = 7;
		
		ListNode current = head;
		
		while(current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println(" null ");
		
		head = removeElements(head, val);
		
		current = head;
		
		while(current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println(" null ");
		
		head = removeElementsAlternate(head, val);
		
		current = head;
		
		while(current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println(" null ");
	}

	private static ListNode removeElements(ListNode head, int val) {

		if(head == null)
			return head;
		
		ListNode current = head, previous = null;
		
		while(current != null)
		{
			if(current.val == val && current == head)
			{
				current = current.next;
				head = current;
			}
			else if(current.val == val) {
				previous.next = current.next;
			}
			
			previous = current;
			current = current.next;
			
		}
		
		return head;
    }
	
	private static ListNode removeElementsAlternate(ListNode head, int val) {

		if(head == null)
			return head;
		
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode current = head, previous = fakeHead;
		
		while(current != null)
		{
			if(current.val == val)
				previous.next = current.next;
			else
				previous = previous.next;
			current = current.next;
			
		}
		
		return fakeHead.next;
    }
	
}
