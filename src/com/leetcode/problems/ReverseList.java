package com.leetcode.problems;

public class ReverseList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println(" null ");
		
		head = reverseList(head);
		
		curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println(" null ");
		
		head = reverseListRecursive(head);
		
		curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println(" null ");
		
		head = reverseListAlt(head);
		
		curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println(" null ");
	}

	private static ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		
		return prev;
        
    }
	
	private static ListNode reverseListRecursive(ListNode head) {
		
		if(head == null || head.next == null) 
			return head;
		
		ListNode curr = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		
		return curr;
		
    }
	
	private static ListNode reverseListAlt(ListNode head) {
		
		ListNode newHead = null;
		
		while(head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		
		return newHead;
        
    }
}
