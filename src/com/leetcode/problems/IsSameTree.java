package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.datastructers.BinarySearchTree;
import com.leetcode.datastructers.Node;

public class IsSameTree {

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
		bst1.insert(10);
		bst1.insert(2);
		bst1.insert(5);
		bst1.insert(3);
		bst1.printPreOrder();
		System.out.println();
		bst1.printBFS();
		System.out.println();
		
		System.out.println(isSameTree(bst.getRoot(), bst1.getRoot()));
	}

	private static boolean isSameTree(Node p, Node q) {
        
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if(p.val == q.val ) 
			return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
		
		return false;
    }
	
	public boolean isSameTree1(Node p, Node q) {        
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
        	Node f = queue.poll();
        	Node s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }
}
