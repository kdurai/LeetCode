package com.leetcode.datastructers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	
	private Node root;
	
	public void insert(int data) {
		
		Node temp = new Node(data);
		
		if(root == null)
			root = temp;
		else
		{
			Node current = root;
			Node parent = null;
					
			while(true)
			{
				parent = current;
				
				if(data < parent.val)
				{
					current = current.left;
					
					if(current == null) {
						parent.left = temp;
						return;
					}
				}
				else
				{
					current = current.right;
					
					if(current == null) {
						parent.right = temp;
						return;
					}
				}
			}
		}
		
	}
	
	public void printInOrder()
	{
		Node current = root;
		
		Stack<Node> stack = new Stack<>();
		
		while(current != null || stack.size() > 0)
		{
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				current = stack.pop();
				System.out.print(current.val + " ");
				current = current.right;
			}
		}
	}
	
	public void printPreOrder()
	{
		Node current = root;
		
		Stack<Node> stack = new Stack<>();
		
		while(current != null || stack.size() > 0)
		{
			if(current != null) {
				stack.push(current);
				System.out.print(current.val + " ");
				current = current.left;
			}
			else {
				current = stack.pop();
				current = current.right;
				}
		}
	}
	
	public void printPostOrder()
	{
		Node current = root;
		
		Stack<Node> stack = new Stack<>();
		stack.push(current);
		
		Stack<Integer> result = new Stack<>();
		
		while(!stack.isEmpty())
		{
			current = stack.pop();
			result.push(current.val);
			
			if(current.left != null) {
				stack.push(current.left);
			}
			
			if(current.right != null) {
				stack.push(current.right);				
			}
		}
		
		while(!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}
	public Node getNode(int data) {
		Node current = root;
		
		while(current != null) {
			
			if(current.val == data)
				return current;
			
			if(current.val > data)
				current = current.left;
			else
				current = current.right;
		}
		
		return current;
	}

	public void printBFS() {
	
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.val + " ");
			
			if(node.left != null)
				queue.add(node.left);
			
			if(node.right != null)
				queue.add(node.right);
		}
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(5);
		bst.insert(3);
		bst.printInOrder();
		System.out.println();
		bst.printBFS();
		System.out.println();
		
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.root = new Node(10);
		bst1.root.left = new Node(8);
		bst1.root.right = new Node(2);
		bst1.root.left.left = new Node(3);
		bst1.root.left.right = new Node(5);
		bst1.root.right.left = new Node(2);
		bst1.printPreOrder();
		System.out.println();
		bst1.printBFS();
		System.out.println();
		
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.root = new Node(1);
		bst2.root.left = new Node(2);
		bst2.root.right = new Node(3);
		bst2.root.left.left = new Node(4);
		bst2.root.left.right = new Node(5);
		bst2.root.right.left = new Node(6);
		bst2.root.right.right = new Node(7);
		bst2.printPostOrder();
		
		Node temp = null;
		System.out.println("\nFind whether element exists: " + ( (temp = bst.getNode(5)) == null  ? "Element does not exist":temp.val));
	}

}
