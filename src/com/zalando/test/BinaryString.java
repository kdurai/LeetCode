package com.zalando.test;

public class BinaryString {

	public static void main(String[] args) {
		
		System.out.println(solution("1010"));

	}
	
	private static int solution(String S) {
		
		int decimal=Integer.parseInt(S,2);  
		System.out.println(decimal);
		
		int count = 0;
		while(decimal > 0)
		{
			if(decimal%2 == 0)
			{
				decimal = decimal/2;
				count++;
			}
			else
			{
				decimal = decimal -1;
				count++;
			}
			
		}
		
		return count;
    }

}
