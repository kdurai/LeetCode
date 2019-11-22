package com.leetcode.medium.nov201921;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

 */
import com.leetcode.problems.ListNode;

public class SwapPairs {

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
		
		head = swapPairs(head);
		
		current = head;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}

		System.out.println("null");
		
		head = swapPairsAlternate(head);
		
		current = head;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}

		System.out.println("null");
	}

	private static ListNode swapPairs(ListNode head) {
 
		if(head == null || head.next == null)
			return head;
		
		ListNode current = head;
		ListNode newHead = head.next;
		
		while(true) {
			ListNode next = current.next;
			ListNode temp = next.next;
			next.next = current;
			if(temp == null || temp.next == null)
			{
				current.next = temp;
				break;
			}
			current.next = temp.next;
			current = temp;
		}
		
		return newHead;
    }
	
	private static ListNode swapPairsAlternate(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
        ListNode remaining = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairsAlternate(remaining);
		return newHead;
	}
}
