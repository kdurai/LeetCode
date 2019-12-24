package com.leetcode.contest.nov162019;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 

Example 1:

Input:
synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
text = "I am happy today but was sad yesterday"
Output:
["I am cheerful today but was sad yesterday",
​​​​​​​"I am cheerful today but was sorrow yesterday",
"I am happy today but was sad yesterday",
"I am happy today but was sorrow yesterday",
"I am joy today but was sad yesterday",
"I am joy today but was sorrow yesterday"]
 

Constraints:

0 <= synonyms.length <= 10
synonyms[i].length == 2
synonyms[0] != synonyms[1]
All words consist of at most 10 English letters only.
text is a single space separated sentence of at most 10 words.

 */
import java.util.List;
import java.util.TreeSet;

public class GenerateSentences {

	public static void main(String[] args) {
		
		List<List<String>> synonyms = new ArrayList<>();
		String text = "I am happy today but was sad yesterday";
		
		List<String> list1 = new ArrayList<>();
		list1.add("happy");
		list1.add("joy");
		
		List<String> list2 = new ArrayList<>();
		list2.add("sad");
		list2.add("sorrow");
		
		List<String> list3 = new ArrayList<>();
		list3.add("joy");
		list3.add("cheerful");
		
		synonyms.add(list1);
		synonyms.add(list2);
		synonyms.add(list3);
		
		System.out.println(generateSentences(synonyms, text).toString());
	}
	
	private static List<String> generateSentences(List<List<String>> synonyms, String text) {
		TreeSet<String> set = new TreeSet<>();
		
//		System.out.println(synonyms.size());
		
		for (String s : text.split(" ")) {
			synonyms.add(Arrays.asList(s));
		}
		
//		System.out.println(synonyms.size());
		/*
		 * for(List<String> list: synonyms ) for(String str: list)
		 * System.out.println(str);
		 */
		
		generateSentences(set, "", 0, text.split(" "), synonyms);
		return new ArrayList<>(set);
	}

	private static void generateSentences(TreeSet<String> set, String curr, int index, 
			String[] text, List<List<String>> synonyms) {
		if (index == text.length) {
			if (!set.contains(curr.substring(1))) {
				set.add(curr.substring(1));
				generateSentences(set, "", 0, curr.substring(1).split(" "), synonyms);
			}
		} else {
			for (List<String> list : synonyms) {
				for (String s : list) {
					if (text[index].equals(s)) {
						for (String s1 : list) {
							generateSentences(set, curr + ' ' + s1, index + 1, text, synonyms);
						}
					}
				}
			}
		}
	}

}
