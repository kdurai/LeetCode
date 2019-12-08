package com.leetcode.medium.dec201908;

/*
 * Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain
 leading or trailing spaces. You need to reduce multiple spaces between two words to a single space in the
  reversed string.
 * 
 */

public class ReverseWords {

	public static void main(String[] args) {
		
		String s = "the sky is blue";
		System.out.println(reverseWords(s));

	}
	
	public static String reverseWords(String s) {
		
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int i = n -1;
		while( i >= 0) 
		{
			if(s.charAt(i) == ' ') 
			{
				i--;
				continue;
			}
			
			int j = i-1;
			
			while( j >= 0 && s.charAt(j) != ' ')
				j--;
			
			sb.append(" ").append(s.substring(j+1, i+1));
			i = j-1;
		}
		
		if(sb.length() > 0)
			sb.deleteCharAt(0);
		
		return sb.toString();
        
    }


}
