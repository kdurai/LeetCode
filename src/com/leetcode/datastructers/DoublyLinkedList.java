package com.leetcode.datastructers;

public class DoublyLinkedList {
	
	private Node head;
	
	public void insertAtEnd(int data) {
		
		Node temp = new Node(data);
		
		if(head == null)
		{
			head = temp;
			return;
		}
		
		Node current = head;
		
		while(current.right != null)
			current = current.right;
		
		current.right = temp;
		temp.left = current;
	}

	public void insertAtFront(int data) {
		Node temp = new Node(data);
		
		if(head == null)
		{
			head = temp;
			return;
		}
		
		temp.right = head;
		head.left = temp;
		
		head = temp;
	}
	
	public void insertAfter(Node node, int data) {
		
		if(node == null)
		{
			System.out.println("Previous node is null. so can't be inserted");
			return;
		}
		
		Node temp = new Node(data);
		temp.right = node.right;
		node.right = temp;
		temp.left = node;
		
		if(temp.right != null)
			temp.right.left = temp;
	}
	
	public void printList() {
		Node current = head;
		
		if(current == null) {
			System.out.println("Empty List...");
			return;
		}
		
		while(current != null)
		{
			System.out.print(current.val + " --> ");
			current = current.right;
		}
		
		System.out.println();
	}
	
	public void delete(int data) {
		Node current = head;
		
		if(current == null ) {
			System.out.println("Empty List..");
			return;
		}
		
		while(current != null && current.val != data)
		{
			current = current.right;
		}
		
		if(current == null) {
			System.out.println("Data is not found");
			return;
		}
		
		if(current == head)
		{
			head = current.right;
			head.left = null;
			return;
		}
		
		if(current.right == null)
		{
			current.left.right = null;
			current.left = null;
			return;
		}
		
		current.right.left = current.left;
		current.left.right = current.right;
		
	}
	
	public static void main(String[] args) {
	
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.insertAtFront(10);
		dll.insertAtFront(20);
		dll.insertAtFront(30);
		dll.insertAtFront(40);
		dll.insertAtFront(50);
		dll.printList();
		
		dll.insertAtEnd(60);
		dll.insertAtEnd(70);
		dll.printList();
		
		dll.insertAfter(dll.head, 60);
		dll.printList();
		dll.delete(40);
		dll.printList();
		dll.insertAfter(dll.head.right.right.right,70);
		dll.printList();
		dll.delete(60);
		dll.printList();
		dll.delete(50);
		dll.printList();
		dll.delete(70);
		dll.printList();
		dll.delete(70);
		dll.printList();
	}
	
}
