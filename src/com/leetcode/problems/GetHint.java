package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class GetHint {

	public static void main(String[] args) {

		String secret = "1123";
		String guess = "0111";
		System.out.println(getHint(secret, guess));
	}
	
	private static String getHint(String secret, String guess) {
        
		int bulls = 0, cows = 0;
		int[] numbers = new int[10];
		
		for(int i = 0 ; i < secret.length(); i++) {
			int s = Character.getNumericValue(secret.charAt(i));
			int g = Character.getNumericValue(guess.charAt(i));
			
			if(s == g) 
				bulls++;
			else
			{
				if(numbers[s]++ < 0 ) cows++;
				if(numbers[g]-- > 0 ) cows++;
			}
		}
		
		
		return bulls+"A"+cows+"B";
		
		
    }

}
