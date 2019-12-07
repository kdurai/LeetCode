package com.leetcode.medium.dec201907;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {
	
	 static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 };

	public static void main(String[] args) {

		ListNode root = new ListNode(3);
		root.next = new ListNode(2);
		root.next.next = new ListNode(0);
		root.next.next.next = new ListNode(-1);
		root.next.next.next.next = root.next;
		
		detectCycle(root);
	}

	private static ListNode detectCycle(ListNode head) {
        
		if(head == null || head.next == null)
			return null;
		
		boolean isCycle = false;
		
		ListNode first = head;
		ListNode second = head;
		
		while(first != null && second != null)
		{
			first = first.next;
			if(second.next == null)
				return null;
			second = second.next.next;
			
			if(first == second)
			{
				isCycle = true;
				break;
			}
		}
		
		if(!isCycle)
			return null;
		
		first = head;
		
		while(first != second)
		{
			first = first.next;
			second = second.next;
		}
		
		return first;
    }
}
