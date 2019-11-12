package com.leetcode.problems;

/*
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern {

	public static void main(String[] args) {

		String s = "abab";
		System.out.println(repeatedSubstringPattern(s));
		s = "aba";
		System.out.println(repeatedSubstringPattern(s));
		s = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern(s));
	}

	private static boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i = l/2; i>=1; i--)
        {
        	if(l%i == 0) {
        		int m = l/i;
        		String subs = s.substring(0,i);
        		StringBuilder sb = new StringBuilder();
        		for(int j = 0; j < m; j++)
        			sb.append(subs);
        		
        		if(sb.toString().equals(s)) return true;
        	}
        	
        }
        
        return false;
    }
}
