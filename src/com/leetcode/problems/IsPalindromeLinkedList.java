package com.leetcode.problems;

public class IsPalindromeLinkedList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		System.out.println(isPalindrome(head));
	}

	private static boolean isPalindrome(ListNode head) {
		
		if(head == null)
			return false;
		
		ListNode walker = head;
		ListNode runner = head;
		
		while(runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		
		if(runner != null) {
			walker = walker.next;
		}
		
		walker = reverse(walker);
		runner = head;
		
		while(walker != null) {
			if(walker.val != runner.val)
				return false;
			
			walker = walker.next;
			runner = runner.next;
		}
		
		return true;
        
    }

	private static ListNode reverse(ListNode walker) {
		
		ListNode newHead = null;
		
		while(walker != null) {
			ListNode next = walker.next;
			walker.next = newHead;
			newHead = walker;
			walker = next;
		}
		
		return newHead;
	}
}
