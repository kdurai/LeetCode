package com.leetcode.problems.nov201916;

import java.util.StringTokenizer;

/*
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 */
public class ReverseWords {

	public static void main(String[] args) {

		String str = "Let's take LeetCode contest";
		System.out.println(reverseWords(str));
	}

	private static String reverseWords(String s) {
		
		char[] ca = s.toCharArray();
		
		for(int i = 0 ; i < ca.length;i++) 
			if(ca[i] != ' ')
			{
				int j = i;
				while( (j+1) < ca.length && ca[j + 1] != ' ') j++;
				reverse(ca, i ,j);
				i = j;
			}

		return new String(ca);
        
    }
	
	private static void reverse(char[] ca, int i, int j)
	{
		for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
	}
}
