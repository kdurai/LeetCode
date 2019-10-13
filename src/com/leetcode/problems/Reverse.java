package com.leetcode.problems;

public class Reverse {

	public static void main(String[] args) {

		int num = -12345;
		System.out.println(reverse(num));
	}

	 private static int reverse(int x) {
	        
		 int result = 0;
		 boolean negative = false;
		 
		 if(x < 0 )
		 {
			 negative = true;
			 x = -x;
		 }
		 
		 while(x > 0) 
		 {
			 result = result * 10 + x % 10;
			 x = x / 10;
		 }
		
		 return negative == true? -result: result;
	 }
}
