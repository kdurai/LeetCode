package com.leetcode.medium.nov201927;

/*
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

 */
public class RotateRight {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	};
	
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		
		ListNode current = head;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println();
		
		ListNode rotatedHead = rotateRight(head, k);
		
		current = rotatedHead;
		
		while(current != null)
		{
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	private static ListNode rotateRight(ListNode head, int k) {

		if(head == null)
            return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		int i = 1;
		
		while(fast.next != null)
		{
			fast = fast.next;
			i++;
		}
		
		for(int j = i - k%i; j > 1; j--)
			slow = slow.next;
		
		fast.next = head;
		head = slow.next;
		slow.next = null;
		
		return head;
		
    }
}
