package com.leetcode.datastructers;

public class CiricularLinkedList {

	private SingleNode head, head1, head2;
	
	public void add(int data) {
	
		SingleNode temp = new SingleNode(data);
		temp.setNext(head);
		SingleNode current = head;
		if(head != null) {
			while(current.getNext() != head)
				current = current.getNext();
			current.setNext(temp);
		}
		else
			temp.setNext(temp);
		
		head = temp;
		
	}
	
	public void printList() {
		SingleNode current = head;
		
		if(current != null) {
			do {
				System.out.print(current.getData() + " ");
				current = current.getNext();
			}
			while(current != head);
		}
		
	}
	
	public void splitList() {
		SingleNode slow_ptr = head;
		SingleNode fast_ptr = head;
		
		if(head == null)
			return;
		
		while(fast_ptr.getNext() != head && fast_ptr.getNext().getNext() != head ) {
			fast_ptr = fast_ptr.getNext().getNext();
			slow_ptr = slow_ptr.getNext();
		}
		
		if(fast_ptr.getNext().getNext() == head)
			fast_ptr = fast_ptr.getNext();
		
		head1 = head;
		
		if(head.getNext() != head)
			head2 = slow_ptr.getNext();
		
		fast_ptr.setNext(slow_ptr.getNext());
		slow_ptr.setNext(head);
				
	}
	
	public void delete(int data) {
		
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		SingleNode current = head, previous = new SingleNode(data);
		
		if(current == null)
		{
			System.out.println("Empty List");
			return;
		}
		
		if(current.getData() == data && current.getNext() == head)
			head = null;
		
		do {
				current = current.getNext();
		}while(current != head && current.getNext().getData() != data);
		
		if(current.getNext().getData() == data)
		{
			current = current.getNext();
		}
	}
	public static void main(String[] args) {

		CiricularLinkedList cll = new CiricularLinkedList();
		cll.add(10);
		cll.add(20);
		cll.add(30);
		cll.add(40);
		cll.add(50);
		cll.printList();
		
	}

}
