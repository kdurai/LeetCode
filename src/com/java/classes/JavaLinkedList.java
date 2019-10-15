package com.java.classes;

import java.util.LinkedList;
import java.util.List;

public class JavaLinkedList {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		list.add(0,1);
		
		System.out.println(list);
		
		list.add(0,2);
		
		System.out.println(list);
	}

}
