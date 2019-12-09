package com.leetcode.medium.dec201909;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in 
 * string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

 */
public class FractionToDecimal {

	public static void main(String[] args) {
		
		System.out.println(fractionToDecimal(-50,8));
		/*
		 * String decimal = "6666666666666666"; System.out.println(decimal.length() <=
		 * 10 ? Integer.valueOf(decimal) : 0);
		 */
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		
		if(numerator == 0)
			return "0";
        
		StringBuilder sb = new StringBuilder();
		sb.append( (numerator > 0) ^ (denominator > 0) ? "-": "");

		Long num = Math.abs((long)numerator);
		Long den = Math.abs((long)denominator);
		
		sb.append(num/den);

		num = num % den;
		if(num == 0)
			return sb.toString();

		sb.append(".");
		
		Map<Long, Integer> map = new HashMap<>();
				
		while(num > 0)
		{
			map.put(num, sb.length());
			
			num *= 10;
			sb.append(num/den);
			num %= den;
			
			if(map.containsKey(num))
			{
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			}
		}
		
		return sb.toString();
		
    }
	
}
