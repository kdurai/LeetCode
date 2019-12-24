package com.leetcode.medium.dec201918;

public class Trie {
	
	static class TrieNode {
		char val;
		boolean isEnd;
		
		TrieNode[] children = new TrieNode[26];
		
		public TrieNode() {}
		
		public TrieNode(char c) {
			TrieNode node = new TrieNode();
			node.val = c;
		}
	};

	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
		root.val = ' ';
	}
	
	 public void insert(String word) {
		 
		 TrieNode current = root;
		 
		 for(int i = 0 ; i < word.length(); i++)
		 {
			 char c = word.charAt(i);
			 if(current.children[c - 'a'] == null) {
				 current.children[c-'a'] = new TrieNode(c);
			 }
			 
			 current = current.children[c-'a'];
		 }

		 current.isEnd = true;
	 }
	    
    public boolean search(String word) {
	      TrieNode current = root;
	      
	      for(int i = 0 ; i < word.length(); i++)
			 {
				 char c = word.charAt(i);
				 if(current.children[c - 'a'] == null) 
					 return false;
				 current = current.children[c-'a'];
			 }

		return current.isEnd;
	        
	    }
	    
    public boolean startsWith(String prefix) {
	        
	      TrieNode current = root;
	      
	      for(int i = 0 ; i < prefix.length(); i++)
			 {
				 char c = prefix.charAt(i);
				 if(current.children[c - 'a'] == null) 
					 return false;
				 current = current.children[c-'a'];
			 }

		return true;
	    }
	    
	public static void main(String[] args) {

		
	}

}
