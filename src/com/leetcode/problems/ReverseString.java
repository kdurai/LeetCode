package com.leetcode.problems;

import java.util.Arrays;

/*
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 * 
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] str = {'h','e','l','l','o'};
		System.out.println(Arrays.toString(str));
		reverseString(str);
		System.out.println(Arrays.toString(str));
	}

	private static void reverseString(char[] s) {
        
		int start = 0;
		int end = s.length-1;
		
		while(start < end) 
		{
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			
			start++;
			end--;
		}
				
    }
	
}
