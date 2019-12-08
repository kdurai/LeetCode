package com.leetcode.medium.dec201908;

/*
 * Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains 
only the first element in the list. With each iteration one element (red) is removed from
 the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted
 output list. At each iteration, insertion sort removes one element from the input data,
  finds the location it belongs within the sorted list, and inserts it there. It repeats 
  until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

*/

public class InsertionSortList {

	static public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 };
	 
	public static void main(String[] args) {

		ListNode root = new ListNode(5);
		root.next = new ListNode(2);
		root.next.next = new ListNode(4);
		root.next.next.next = new ListNode(1);
		insertionSortList(root);
	}

	public static ListNode insertionSortList(ListNode head) {
		
		if(head == null)
			return head;
		
		ListNode dummyNode = new ListNode(0);
		ListNode current = head;
		ListNode pre = dummyNode;
		ListNode next = null;
		
		while(current != null)
		{
			next = current.next;
			
			while(pre.next != null && pre.next.val < current.val)
				pre = pre.next;
			
			current.next = pre.next;
			pre.next = current;
			pre = dummyNode;
			current = next;
		}
		
		return dummyNode.next;

    }
}
