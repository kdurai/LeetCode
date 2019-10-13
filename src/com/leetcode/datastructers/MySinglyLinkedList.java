package com.leetcode.datastructers;

public class MySinglyLinkedList {
	
	private SingleNode head;
	
	public void insertAtFront(int data) {
		SingleNode temp = new SingleNode(data);
		
		if(head == null)
		{
			head = temp;
			return;
		}
		
		temp.setNext(head);
		head = temp;
	}
	
	public void insertAtEnd(int data) {
		SingleNode temp = new SingleNode(data);
		
		if(head == null)
		{
			head = temp;
			return;
		}
		
		SingleNode current = head;
		
		while(current.getNext() != null)
			current = current.getNext();
		
		current.setNext(temp);
	}
	
	public void printList() {
		SingleNode current = head;
		
		while(current != null)
		{
			System.out.print(current.getData() + " --> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
	
	public void insertAfter(SingleNode node, int data) {

		if(node == null)
		{
			System.out.println("Previous node can not be empty");
			return;
		}
		
		
		SingleNode temp = new SingleNode(data);
		temp.setNext(node.getNext());
		node.setNext(temp);
		
	}
	
	public void deleteNode(int data) {
		SingleNode current = head, prev = null;
		
		if(current != null && current.getData() == data)
		{
			head = head.getNext();
			return;
		}
		
		while(current != null && current.getData() != data)
		{
			prev = current;
			current = current.getNext();
		}
		
		if(current == null)
			return;
		
		prev.setNext(current.getNext());
	}
	
	public void deleteNodeAtPosition(int position) {
			
		if(head == null)
		{
			System.out.println("Empty List.");
			return;
		}
		
		if(position == 0 && head != null)
		{
			head = head.getNext();
			return;
		}
		
		SingleNode current = head, prev = null;

		for(int i = 1; i<=position && current != null; i++)
		{
			prev = current;
			current = current.getNext();
		}
		
		if(current == null)
		{
			System.out.println("Reached end of the list");
			return;
		}
		
		prev.setNext(current.getNext());
	}
	
	public int size(char flag)
	{
		if (head == null)
			return 0;
		
		SingleNode current = head;
		int count = 0;
		
		if(flag == 'i')
		{
			while(current != null)
			{
				current = current.getNext();
				count++;
			}
			return count;
		}
		else
		{
			return getRecursiveSize(head);
		}
	}
	
	private int getRecursiveSize(SingleNode node) {
		if(node == null)
			return 0;
		
		return 1 + getRecursiveSize(node.getNext());
	}

	public SingleNode getHead()
	{
		return head;
	}
	
	public static void main(String[] args) {
		
		MySinglyLinkedList ll = new MySinglyLinkedList();
		
		ll.insertAtFront(10);
		ll.insertAtFront(20);
		ll.insertAtFront(30);
		ll.insertAtFront(40);
		ll.insertAtFront(50);
		ll.printList();
		ll.insertAtEnd(60);
		ll.insertAtEnd(70);
		ll.insertAtEnd(80);
		ll.insertAtEnd(90);
		ll.insertAtEnd(100);
		ll.printList();
		ll.insertAfter(ll.head, 100);
		ll.printList();
		ll.deleteNode(100);
		ll.printList();
		ll.deleteNode(100);
		ll.printList();
		ll.deleteNode(100);
		ll.printList();
		ll.deleteNodeAtPosition(2);
		ll.printList();
		ll.deleteNodeAtPosition(10);
		ll.printList();
		ll.deleteNodeAtPosition(5);
		ll.printList();
		ll.deleteNodeAtPosition(0);
		ll.printList();
		System.out.println("Size of the linkedlist: " + ll.size('c'));
		System.out.println("Size of the linkedlist: " + ll.size('i'));
	}

}
