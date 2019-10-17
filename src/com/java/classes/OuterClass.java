package com.java.classes;

public class OuterClass {
	
	class InnerClass {
		int val;
	}

	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.val = 10;
		
		System.out.println(inner.val);
	
	}

}
