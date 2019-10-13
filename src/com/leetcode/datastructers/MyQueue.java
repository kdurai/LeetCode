package com.leetcode.datastructers;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void enQueue(int data) {
		stack1.push(data);
	}
	
	public int deQueue() {
		
		if(stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				int item = stack1.pop();
				stack2.push(item);
			}
		}
		
		return stack2.pop();
	}
	
	public static void main(String[] args) {

		MyQueue mq = new MyQueue();
		mq.enQueue(10);
		mq.enQueue(20);
		mq.enQueue(30);
		mq.enQueue(40);
		mq.enQueue(50);
		
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
	}

}
