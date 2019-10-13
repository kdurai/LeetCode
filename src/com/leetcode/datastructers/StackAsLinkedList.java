package com.leetcode.datastructers;

public class StackAsLinkedList {

	StackNode root;
	
	static class StackNode {
		int data;
		StackNode next;
		
		StackNode(int data) {
			this.data = data;
		}
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void push(int data) {
		
		StackNode newnode = new StackNode(data);
		
		if(root == null) {
			root = newnode;
		}
		else {
			StackNode temp = root;
			root = newnode;
			newnode.next = temp;
		}
	}
	
	public int pop( ) {
		
		int popped = Integer.MIN_VALUE;
		
		if(root == null) {
			System.out.println("Stack is empty");
			return popped;
		}
		
		popped = root.data;
		root = root.next;
		return popped;
	}
	
	public int peek( ) {
		
		if(root == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		return root.data;
	}

	public static void main(String[] args) {

		StackAsLinkedList stack = new  StackAsLinkedList();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
