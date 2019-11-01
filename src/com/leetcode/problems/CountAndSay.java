package com.leetcode.problems;

public class CountAndSay {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(countAndSay(n));
	}
	
	private static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();;
        
        String temp = "1";
        if(n <= 1)
        {
        	return temp;
        }
        
        for(int i = 2; i <= n; i++)
        {
        	for(int j = 0; j < temp.length(); j++ ) {
        		int count = 1;
        		char ts = temp.charAt(j);
        		
        		while(j < temp.length()-1 && temp.charAt(j) == temp.charAt(j + 1)) {
        			j++;
        			count++;
        		}
        		
        		result.append(count + "" + ts );
        	}
        	
        	temp = result.toString();
        	result = new StringBuilder();
        }
        
        return temp;
    }

}
