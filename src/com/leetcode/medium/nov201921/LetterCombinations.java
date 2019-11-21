package com.leetcode.medium.nov201921;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent. A mapping of digit to letters (just like on the telephone
 *  buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {

	public static void main(String[] args) {
		
		String digits = "22";
		System.out.println(letterCombinations(digits));

	}

	private static List<String> letterCombinations(String digits) {
        
		LinkedList<String> result = new LinkedList<>();
		
		if(digits == null || digits.length() == 0)
			return result;
		
		String[] mapping = {"0", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		result.add("");
		
		for(int i = 0 ; i < digits.length(); i++) {
			int x = digits.charAt(i) - '0';
			while(result.peek().length() == i) {
				String t = result.remove();
				for(char c: mapping[x].toCharArray())
					result.add(t+c);
			}
		}
		
		return result;
    }
}
