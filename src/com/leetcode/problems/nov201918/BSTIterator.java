package com.leetcode.problems.nov201918;

import java.util.Stack;

import com.leetcode.problems.TreeNode;

public class BSTIterator {
	
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		this.stack = new Stack<>();
	
		pushAll(root);
    }
    
    private void pushAll(TreeNode root) {
    	
    	for(; root != null; stack.push(root), root = root.left);
		
	}

	/** @return the next smallest number */
    public int next() {
    	
    	TreeNode node = stack.pop();
    	pushAll(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
	
    public static void main(String[] args) {
    	
    	TreeNode root = new TreeNode(7);
    	root.left = new TreeNode(3);
    	root.right = new TreeNode(15);
    	root.right.left = new TreeNode(9);
    	root.right.right = new TreeNode(20);
    	
    	BSTIterator bstIterator = new BSTIterator(root);
    	
    	while(bstIterator.hasNext())
    		System.out.print(bstIterator.next() + " ");
	}

}
