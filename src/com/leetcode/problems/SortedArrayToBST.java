package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {

	public static void printLevelOrder(TreeNode head) {

		/*
		 * TreeNode curr = head;
		 * 
		 * Stack<TreeNode> stack = new Stack<>();
		 * 
		 * stack.push(curr);
		 * 
		 * while(!stack.isEmpty()) {
		 * 
		 * TreeNode temp = stack.pop();
		 * 
		 * System.out.println(temp.val + " ");
		 * 
		 * if(temp.right != null) stack.push(temp.right); if(temp.left != null)
		 * stack.push(temp.left); }
		 */

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(head);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");

			if (node.left != null)
				queue.add(node.left);

			if (node.right != null)
				queue.add(node.right);
		}

	}

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode head = sortedArrayToBST(nums);

		printLevelOrder(head);
	}

	private static TreeNode sortedArrayToBST(int[] nums) {

		if (nums.length == 0)
			return null;

		TreeNode head = helper(nums, 0, nums.length - 1);
		return head;
	}

	private static TreeNode helper(int[] nums, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, start, mid - 1);
		node.right = helper(nums, mid + 1, end);

		return node;
	}
}
