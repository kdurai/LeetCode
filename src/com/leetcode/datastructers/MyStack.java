package com.leetcode.datastructers;

public class MyStack {
	
	private static int MAX=100;
	private int data[] = new int[MAX];
	private int top;
	
	public MyStack() {
		top = -1;
	}

	public void push(int data) {
		if(top == MAX)
		{
			System.out.println("Stack Overflow");
			return;
		}
		
		this.data[++top] = data;
	}
	
	public int pop() {
		if(top < 0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		return this.data[top--];
	}
	
	public int peek() {
		if(top < 0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		
		return this.data[top];
		
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public static void main(String[] args) {
	
		MyStack stack = new MyStack();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
