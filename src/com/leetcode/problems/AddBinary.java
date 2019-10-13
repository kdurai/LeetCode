package com.leetcode.problems;

public class AddBinary {

	public static void main(String[] args) {

		String a = "11";
		String b = "1";
		
		System.out.println(addBinary(a, b));
		
		a = "1010";
		b = "1011";
		
		System.out.println(addBinary(a, b));
	}
	
	private static String addBinary(String a, String b)
	{
		StringBuilder result = new StringBuilder();
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carryover = 0;
		
		while( i >= 0 || j >= 0)
		{
			int sum = carryover;
			
			if(i >= 0)
				sum += a.charAt(i--) - '0';
			if(j >= 0)
				sum += b.charAt(j--) - '0';
			
			result.append(sum%2);
			carryover = sum/2;
		}
		
		if(carryover != 0)
			result.append(carryover);
		
		return result.reverse().toString();
		
	}

	private static String addBinary1(String a, String b) {
		
		StringBuilder result = new StringBuilder();
		int carryover = 0;
		int i = a.length() - 1, j = b.length() - 1;
		for(; i >= 0 && j >= 0; i--, j--) {
			int ia = a.charAt(i) == '1' ? 1: 0;
			int ib = a.charAt(j) == '1' ? 1: 0;
			
			int ires = ia + ib + carryover;
			
			if(ires >= 2)
			{
				result.append((ires - 2) + "");
				carryover = ires / 2;
			}
			else
			{
				result.append(ires + "");
				carryover = 0;
			}
			
		}
		
		System.out.println("Index: " + i + "Carryover: " + carryover);
		while(i >= 0)
		{
			int ia = a.charAt(i) == '1' ? 1: 0;
			int ires = ia + carryover;
			
			if(ires >= 2)
			{
				result.append((ires - 2) + "");
				carryover = ires / 2;
			}
			else
			{
				result.append(ires + "");
				carryover = 0;
			}
			
			i--;
		}
		
		if(carryover == 1)
			result.append(1 + "");
		
		return result.toString();
	}
}
