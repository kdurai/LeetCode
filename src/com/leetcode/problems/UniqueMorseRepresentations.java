package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {

	public static void main(String[] args) {
		String[] arr = {"gin","zen","gig","msg"};
		System.out.println((uniqueMorseRepresentations(arr)));
	}

	private static int uniqueMorseRepresentations(String[] arr) 
	{
		String[] MORS = {
				".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."
		};
		
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < arr.length; i++) 
		{
			StringBuilder sb = new StringBuilder();
			for(char ch:arr[i].toCharArray())
				sb.append(MORS[ch - 'a']);
			
			set.add(sb.toString());
		}
		
		return set.size();
	}
}
