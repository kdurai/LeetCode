package com.leetcode.problems;

import java.util.Arrays;

/*
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.

	A defanged IP address replaces every period "." with "[.]".
 */


public class DefangIPaddr {

	public static void main(String[] args) {
		
		System.out.println(defangIPaddr("1.1.1.1"));
		System.out.println(Arrays.toString("1.1.1.1".split("\\.")));
		System.out.println(Arrays.toString("1.1.1.1".split("1")));
		
	}

	public static String defangIPaddr(String address)
	{
		//return address.replace(".", "[.]");
		return String.join("[.]", address.split("\\."));
	}
	
}
