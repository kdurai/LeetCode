package com.google.l3;
/*
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might 
 * get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends
 name, with some characters (possibly none) being long pressed.

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.

Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

*/
public class IsLongPressedName {

	public static void main(String[] args) {

		String name = "alex", typed ="aaleex";
		System.out.println(isLongPressedName(name, typed));
		name = "saeed";
		typed ="aaleex";
		System.out.println(isLongPressedName(name, typed));
		name = "leelee";
		typed ="lleeelee";
		System.out.println(isLongPressedName(name, typed));
		name = "laiden";
		typed ="laiden";
		System.out.println(isLongPressedName(name, typed));
		
		name = "hello";
		typed ="hhheeeeloo";
		System.out.println(isLongPressedName(name, typed));
	}

	private static boolean isLongPressedName(String name, String typed) {
		
		int i = 0, m = name.length(), n = typed.length();
		
		char[] ch1 = name.toCharArray();
		char[] ch2 = typed.toCharArray();
		
		for(int j = 0 ; j < n; j++)
			if( i < m && ch1[i] == ch2[j])
				i++;
			else if(j == 0 || ch2[j] != ch2[j-1])
				return false;
		
		return i == m;
    }
}
