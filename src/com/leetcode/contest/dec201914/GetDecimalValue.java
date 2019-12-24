package com.leetcode.contest.dec201914;

/*
 * Given head which is a reference node to a singly-linked list. The value of each node in the 
 * linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0
 
Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 * 
 */

public class GetDecimalValue {

	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 };
	
	public static void main(String[] args) {

		ListNode root = new ListNode(1);
		root.next = new ListNode(0);
		root.next.next = new ListNode(0);
		root.next.next.next = new ListNode(1);
		root.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next = new ListNode(1);
		root.next.next.next.next.next.next.next = new ListNode(1);
		root.next.next.next.next.next.next.next.next = new ListNode(1);
		root.next.next.next.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		
		System.out.println(getDecimalValue(root));
	}

	public static int getDecimalValue(ListNode head) {
       
		StringBuilder sb = new StringBuilder();
		ListNode current = head;
		
		while(current != null) 
		{
			sb.append(current.val + "");
			current = current.next;
		}
		
		System.out.println(sb.toString());
		return binaryToInt(sb);
		
    }

	private static int binaryToInt(StringBuilder sb) {
		int n = sb.length();
		int ans = 0;
		
		for(int i = 0; i < n; i++ )
			ans += ( ( sb.charAt(i) - '0' )  * Math.pow(2, (n-i-1)) );
		
		return ans;
	}
}
