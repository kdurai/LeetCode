package com.leetcode.medium.nov201930;

import java.util.ArrayList;
/*
 * Given a string containing only digits, restore it by returning all possible valid IP address 
 * combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

 */
import java.util.List;

public class RestoreIpAddresses {

	public static void main(String[] args) {

		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}

	private static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        for(int i = 1; i <= 3; i++)
        	for(int j = 1; j <= 3; j++)
        		for(int k = 1; k <= 3; k++)
        			for(int l = 1; l <= 3; l++)
        				if(i+j+k+l == s.length())
        				{
        					int a = Integer.valueOf(s.substring(0, i));
        					int b = Integer.valueOf(s.substring(i, i+j));
        					int c = Integer.valueOf(s.substring(i+j, i+j+k));
        					int d = Integer.valueOf(s.substring(i+j+k));
        					
        					if( a <= 255 && b <= 255 & c <= 255 & d <= 255)
        					{
        						StringBuilder sb = new StringBuilder();
        						if(sb.append(a+"").append(".").append(b+"").append(".")
        							.append(c+"").append(".").append(d+"").length() == s.length() + 3)
        							result.add(sb.toString());
        					}
        				}
        return result;
    }
	
}
