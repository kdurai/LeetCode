package com.leetcode.problems;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */
public class ReverseVowels {

	public static void main(String[] args) {
		
		String str = "hello";
		System.out.println(str);
		System.out.println(reverseVowels(str));
		str = "leetcode";
		System.out.println(str);
		System.out.println(reverseVowels(str));

	}
	
	private static String reverseVowels(String s) {
		if(s == null || s.length() == 0)
			return s;
		
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
        	while(start < end && !vowels.contains(chars[start] + "")) 
        		start++;
        	
        	while(start < end && !vowels.contains(chars[end] + "")) 
        		end--;
        	
        	char temp = chars[start];
        	chars[start] = chars[end];
        	chars[end] = temp;
        	
        	start++;
        	end--;
        }
        
        return new String(chars);
    }
	
	
}
