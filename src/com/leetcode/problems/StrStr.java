package com.leetcode.problems;

public class StrStr {

	public static void main(String[] args) {

		String haystack = "hello";
		String needle = "ll";
		System.out.println(strStr(haystack, needle));
	}

	private static int strStr(String haystack, String needle) {
        
        if(needle == null || needle.equals(""))
            return 0;
        
        if(haystack == null)
        	return -1;
        
        if(haystack.equals("") && needle.length() != 0)
        	return -1;
        
        int N = haystack.length();
        int M = needle.length();
        
        int[] lps = new int[M];
        int j = 0;
        
        computeLPSArray(needle, M, lps);
        
        int i = 0;
        
        while(i  < N) {
        	
        	if(needle.charAt(j) == haystack.charAt(i)) {
        		i++;
        		j++;
        	}
        	
        	if(j == M) {
        		System.out.println("Found Pattern at Index: " + (i - j) );
        		return (i - j);
        		//j = lps[j-1];
        	}
        	
        	else
        		if( i < N && needle.charAt(j) != haystack.charAt(i)) {
        			if(j != 0)
        				j = lps[j - 1];
        			else
        				i = i + 1;
        		}
        	
        }
        
        return 0;
    }
	
	private static void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		
		lps[0] = 0;
		
		while( i < M) {
			
			if(pat.charAt(i) == pat.charAt(len))
			{
				len = len + 1;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
				{
					len = lps[len-1];
				}
				else
				{
					lps[i] = len;
					i++;
				}
			}
		}
		
	}
}
