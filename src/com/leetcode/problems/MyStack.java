package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	Queue<Integer> queue;
	
	/** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i = 0 ; i < queue.size() - 1; i ++)
        	queue.add(queue.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
    
	public static void main(String[] args) {

		MyStack mystack = new MyStack();
		
		mystack.push(10);
		mystack.push(20);
		mystack.push(30);
		mystack.push(40);
		mystack.push(50);
		
		System.out.println("Poping from stack: " + mystack.pop());
		System.out.println("Is stack empty: " + mystack.empty());
		System.out.println("Top element in stack: " + mystack.top());
	}

}
