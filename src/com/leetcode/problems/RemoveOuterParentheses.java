package com.leetcode.problems;

import java.util.Stack;

public class RemoveOuterParentheses {

	public static void main(String[] args) {

		System.out.println(removeOuterParentheses("(()())(())"));
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses("()()"));
	}

	private static String removeOuterParentheses(String S) {

		if (S == null || S == "")
			return "";

		StringBuilder sb = new StringBuilder();
		int open = 0, close = 0, start = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(')
				open++;
			else if (S.charAt(i) == ')')
				close++;

			if (open == close) {
				sb.append(S.substring(start + 1, i));
				start = i + 1;
			}
		}

		return sb.toString();
	}

}
