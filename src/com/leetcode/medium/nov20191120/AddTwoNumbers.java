package com.leetcode.medium.nov20191120;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
import com.leetcode.problems.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(4);
		l2.next.next.next.next = new ListNode(6);
		
		ListNode current = addTwoNumbers(l1, l2);;
		
		while(current != null)
		{
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode result = new ListNode(0);
		ListNode curr = result;
	
		while(l1 != null || l2 != null) {
			int sum = 0;
			
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			curr.next = curr.next == null ? new ListNode(0): curr.next;
			curr = curr.next;
			sum += curr.val;
			curr.val = sum%10;
			curr.next = sum/10 == 0 ? null: new ListNode(sum/10);
		}
		
		return result.next;
	}

}
