package com.google.l3;

/*
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending 
 * multiple copies of the substring together. You may assume the given string consists of lowercase
 *  English letters only and its length will not exceed 10000.

 

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
   
        int len = s.length();
        
        for(int i = len/2; i >= 1; i--)
        {
            if(len % i == 0)
            {
                String subs = s.substring(0, i);
                int numsOfTimes = len/i;
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < numsOfTimes; k++)
                	sb.append(subs);
                
                if(sb.toString().equals(s)) 
                	return true;
                
            }
        }
		return false;
    }
}
