package com.leetcode.problems;

public class AddStrings {

	public static void main(String[] args) {

		String num1 = "1234567";
		String num2 = "10";
		System.out.println(addStrings(num1, num2));
	}

	private static String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int carryover = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while(i >= 0 || j >= 0) {
        	
        	int sum = carryover;
        	
        	if(i >= 0)
        		sum += num1.charAt(i--) - '0';
        	
        	if(j >= 0)
        		sum += num2.charAt(j--) - '0';
        	
        	str.append(sum%10);
        	carryover = sum / 10;
        }
        
        if(carryover != 0)
        	str.append(carryover);
        
        return str.reverse().toString();
		
    }
}
