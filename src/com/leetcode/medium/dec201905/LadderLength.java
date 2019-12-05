package com.leetcode.medium.dec201905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/

public class LadderLength {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(words));

		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		Set<String> dict = new HashSet<>(wordList);
		
		queue.offer(beginWord);
		
		for(int len = 1; !queue.isEmpty(); len++)
			for(int i = queue.size(); i > 0 ; i--)
			{
				String word = queue.poll();
				
				if(word.equals(endWord))
					return len;
				
				for(int j = 0 ; j < word.length(); j++)
				{
					char[] ch = word.toCharArray();
					
					for(char k = 'a'; k <= 'z'; k++ )
					{
						if(ch[j] == k)
							continue;
						ch[j] = k;
						
						String newWord = String.valueOf(ch);
						if(dict.contains(newWord) && set.add(newWord))
							queue.offer(newWord);
					}
				}
			}
		
		return 0;
		
    }
	
}
