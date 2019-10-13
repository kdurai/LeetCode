package com.leetcode.problems;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */

public class LengthOfLastWord {

	public static void main(String[] args) {

		String str = "HelloWorld";
		System.out.println(lengthOfLastWord(str));
	}
	
	private static int lengthOfLastWord(String s) {
        int result = 0;
        
        for(int i = s.length() - 1; i >= 0; )
        {
        	if(s.charAt(i) == ' ' && result == 0)
        		i--;
        	else 
        		if(s.charAt(i) == ' ' && result != 0)
        			return result;
        		else
        		{
        			i--;
        			result++;
        		}
        }
        return result;
    }

}
