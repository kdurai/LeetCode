package com.leetcode.datastructers;

public class Node {

	public int val;
	public Node left;
	public Node right;
	int height;

	public Node(int val) {
		this.val = val;
		this.height = 1;
	}
}
