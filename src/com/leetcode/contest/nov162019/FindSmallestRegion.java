package com.leetcode.contest.nov162019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * 	1257. Smallest Common Region
 * 
 * You are given some lists of regions where the first region of each list includes all other regions in 
 * that list.

Naturally, if a region X contains another region Y then X is bigger than Y.

Given two regions region1, region2, find out the smallest region that contains both of them.

If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such 
that r2 includes r3.

It's guaranteed the smallest region exists.

 */

public class FindSmallestRegion {

	public static void main(String[] args) {

		List<List<String>> regions = new ArrayList<>();
		String region1 = "Quebec";
		String region2 = "New York";
		
		List<String> list1 = new ArrayList<>();
		list1.add("Earth");
		list1.add("North America");
		list1.add("South America");
		List<String> list2 = new ArrayList<>();
		list2.add("North America");
		list2.add("United States");
		list2.add("Canada");
		List<String> list3 = new ArrayList<>();
		list3.add("United States");
		list3.add("New York");
		list3.add("Boston");
		List<String> list4 = new ArrayList<>();
		list4.add("Canada");
		list4.add("Ontario");
		list4.add("Quebec");
		List<String> list5 = new ArrayList<>();
		list5.add("South America");
		list5.add("Brazil");
		
		regions.add(list1);
		regions.add(list2);
		regions.add(list3);
		regions.add(list4);
		regions.add(list5);
		
		System.out.println(findSmallestRegion(regions, region1, region2));
	}
	
	private static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		
		HashMap<String, String> map = new HashMap<>();
		for (List<String> region : regions) {
			for (int i = 1; i < region.size(); i++) {
				map.put(region.get(i), region.get(0));
			}
		}
		HashSet<String> set = new HashSet<>();
		while (region1 != null) {
			set.add(region1);
			region1 = map.get(region1);
		}
		while (!set.contains(region2)) {
			region2 = map.get(region2);
		}
		return region2;
		
    }

}
