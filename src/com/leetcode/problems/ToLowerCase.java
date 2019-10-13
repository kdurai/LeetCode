package com.leetcode.problems;

public class ToLowerCase {

	public static void main(String[] args) {
		System.out.println('a' - 'A');
		System.out.println('b' - 'B');
		System.out.println('c' - 'C');
		System.out.println('d' - 'D');
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println(toLowerCase("Hello"));
		System.out.println(toLowerCase("here"));
		System.out.println(toLowerCase("LOVELY"));
		System.out.println(toLowerCase("Hello"));
	}

	private static String toLowerCase(String string) {
		String ret="";
		for(char ch:string.toCharArray())
		{
			if(ch >='A' && ch <= 'Z')
				ret = ret + ((char)(ch+32));
			else
				ret = ret + ch;
		}
		return ret;
	}

	
}
