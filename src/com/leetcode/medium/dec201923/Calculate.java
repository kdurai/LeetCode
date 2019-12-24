package com.leetcode.medium.dec201923;

import java.util.Stack;

/*
 * mplement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 */
public class Calculate {

	public static void main(String[] args) {

	}

	public static int calculate(String s) {
        
		int result = 0 ;
		
		if(s == null || s.length() == 0)
			return result;
		
		char[] arr = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < arr.length; i++)
		{
			if(arr[i] == ' ')
				continue;
			
			if(arr[i] == '+')
			{
				result += (arr[i+1]  - '0');
				i++;
				continue;
			}
			
			if(arr[i] == '-')
			{
				result -= (arr[i+1]  - '0');
				i++;
				continue;
			}
			
			if(arr[i] == '*')
			{
				result -= arr[i-1];
				int temp = (arr[i-1]  - '0') * (arr[i+1]  - '0');
				result += temp;
				i++;
				continue;
			}
			
			if(arr[i] == '/')
			{
				result -= arr[i-1];
				int temp = (arr[i-1]  - '0') / (arr[i+1]  - '0');
				result += temp;
				i++;
				continue;
			}
			
			result += arr[i];
		}
		return result;
    }
	
}
