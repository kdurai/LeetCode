package com.google.l3;

public class DocLines {

	public static void main(String[] args) {

		String str = "I love jerkyverymuch";
		int num = 10;
		System.out.println(docLines(str, num));
	}
	
	private static int docLines(String str, int num)
	{
		int lines = 1;
		int currIdx = str.length() - 1;
		
		while(currIdx < str.length())
		{
			char ch = str.charAt(currIdx);
			
			while(ch != ' ')
			{
				currIdx--;
				ch = str.charAt(currIdx);
			}
			lines++;
			currIdx += num;
		}
		
		return lines;
	}

}
