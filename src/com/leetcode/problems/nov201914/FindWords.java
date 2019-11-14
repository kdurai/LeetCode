package com.leetcode.problems.nov201914;

/*
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 

Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FindWords {

	public static void main(String[] args) {
		
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		
		System.out.println(Arrays.toString(findWords(words)));

	}

	private static String[] findWords(String[] words) {
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0 ; i < words.length; i++) {
			String str = words[i].toLowerCase();
			if(str.matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
				list.add(str);
		}
		
		String[] result = new String[list.size()];
		
		for(int i = 0 ; i < list.size(); i++) 
			result[i] = list.get(i);
		
		return result;
		
        //return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}


