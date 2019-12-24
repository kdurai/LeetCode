package com.leetcode.datastructers;

public class AVLTree {

	Node root;

	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	Node rotateRight(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		/* Perform Rotation */
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	int getBalance(Node N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	Node rotateLeft(Node y) {
		Node x = y.right;
		Node T2 = x.left;

		/* Perform Rotation */
		x.left = y;
		y.right = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	Node insert(Node node, int key) {

		if (node == null)
			return (new Node(key));

		if (key < node.val)
			node.left = insert(node.left, key);
		else if (key > node.val)
			node.right = insert(node.right, key);
		else
			return node;

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.val)
			return rotateRight(node);

		if (balance < -1 && key > node.right.val)
			return rotateLeft(node);

		if (balance > 1 && key > node.left.val) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && key < node.right.val) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		
		return node;
	}
	
	void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.val + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 

	public static void main(String[] args) {

		AVLTree tree = new AVLTree(); 
		  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25);
        
        System.out.println("Preorder traversal" + 
                " of constructed tree is : "); 
        tree.preOrder(tree.root); 

	}

}
