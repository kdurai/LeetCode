package com.leetcode.problems;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class IsPalindrome {

	public static void main(String[] args) {

		String str = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(str));
		str = "race a car";
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String s) {
        
		if(s.isEmpty())
			return true;
		
		int head = 0;
		int tail = s.length() - 1;
		
		while(head < tail) {
			char cHead = s.charAt(head);
			char cTail = s.charAt(tail);
			
			if(!Character.isLetterOrDigit(cHead))
				head++;
			else if(!Character.isLetterOrDigit(cTail))
				tail--;
			else
			{
				if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
					return false;
				
				head++;
				tail--;
			}
		}
		return true;
    }
}
