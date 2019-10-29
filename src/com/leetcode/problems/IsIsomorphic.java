package com.leetcode.problems;

/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */
public class IsIsomorphic {

	public static void main(String[] args) {
		
		String s = "egg";
		String t = "add";
		
		System.out.println(isIsomorphic(s, t));
	}

	private static boolean isIsomorphic(String s, String t) {
     
		int[] m = new int[512];
		
		for(int i = 0 ; i < s.length(); i++) 
		{
			if(m[s.charAt(i)] != m[t.charAt(i) + 256] )
				return false;
			m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
		}
		
		return true;
    }
}
