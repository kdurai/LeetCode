package com.leetcode.contest.nov201930;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * A decimal number can be converted to its Hexspeak representation by first converting it to an 
 * uppercase hexadecimal string, then replacing all occurrences of the digit 0 with the letter O, 
 * and the digit 1 with the letter I.  Such a representation is valid if and only if it consists only 
 * of the letters in the set {"A", "B", "C", "D", "E", "F", "I", "O"}.

Given a string num representing a decimal integer N, return the Hexspeak representation of N if it is 
valid, otherwise return "ERROR".

Example 1:

Input: num = "257"
Output: "IOI"
Explanation:  257 is 101 in hexadecimal.
Example 2:

Input: num = "3"
Output: "ERROR"

Constraints:

1 <= N <= 10^12
There are no leading zeros in the given string.
All answers must be in uppercase letters.
*/
public class ToHexspeak {

	public static void main(String[] args) {

		String num = "257";
		System.out.println(toHexspeak(num));
		num = "3";
		System.out.println(toHexspeak(num));
		
	}
	
	private static String toHexspeak(String num) {
        
		Long value = Long.parseLong(num);
		StringBuilder sb = new StringBuilder();
		
		while(value > 0)
		{
			int remainder = (int)(value % 16);
			sb.append((char)(remainder<10 ? remainder + '0':remainder - 10 + 'A'));
			value = value/16;
		}
		
		String str = sb.reverse().toString();
		str = str.replaceAll("0", "O").replaceAll("1", "I");
		Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F", "I", "O"));
		
		char[] ch = str.toCharArray();
		
		for(int i = 0 ; i < ch.length; i++)
			if(!set.contains(ch[i] + ""))
					return "ERROR";
		
		return str;
    }

}
