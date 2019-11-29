package com.leetcode.medium.nov201929;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct 
 * numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

 */
public class DeleteDuplicates {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {

	}

	private static ListNode deleteDuplicates(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode lastKnownGoodNode = null;
		ListNode current = head;
		
		while(current != null && current.next != null) {
			
			if(current.val == current.next.val) {
				
				while(current != null && current.next != null && current.val == current.next.val)
					current = current.next;
				
				if(lastKnownGoodNode != null)
					lastKnownGoodNode.next = current.next;
				else
					head = current.next;
			}
			else
				lastKnownGoodNode = current;
			
			current = current.next;
		}
        
		return head;
    }
}
