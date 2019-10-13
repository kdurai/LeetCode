package com.leetcode.problems;

import com.leetcode.datastructers.MySinglyLinkedList;
import com.leetcode.datastructers.SingleNode;

public class DeleteDuplicates {

	public static void main(String[] args) {

		MySinglyLinkedList ll = new MySinglyLinkedList();

		ll.insertAtFront(10);
		ll.insertAtFront(20);
		ll.insertAtFront(20);
		ll.insertAtFront(40);
		ll.insertAtFront(50);
		ll.printList();
		/*
		 * ll.insertAtEnd(60); ll.insertAtEnd(70); ll.insertAtEnd(80);
		 * ll.insertAtEnd(90); ll.insertAtEnd(100); ll.printList();
		 */

		deleteDuplicates(ll.getHead());
		ll.printList();
	}

	private static SingleNode deleteDuplicates(SingleNode head) {

		SingleNode temp = head;

		while (temp != null && temp.getNext() != null) {

			if (temp.getData() == temp.getNext().getData()) {
				temp.setNext(temp.getNext().getNext());
			}

			temp = temp.getNext();
		}

		return head;
	}
}
