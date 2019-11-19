package com.leetcode.problems.nov201918;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with
 no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.

 */
public class FindRestaurant {

	public static void main(String[] args) {

		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		System.out.println(findRestaurant(list1, list2));
	}

	private static String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> map = new HashMap<>();
		
		List<String> result = new LinkedList<>();
		
		for(int i = 0; i < list1.length; i++)
			map.put(list1[i], i);
		
		int min_sum = Integer.MAX_VALUE;
		
		for(int i = 0; i < list2.length; i++) {
			Integer j = map.get(list2[i]);
			if( j != null && i+ j <= min_sum) {
				if( i + j  < min_sum )
				{
					result.clear();
					min_sum = i + j;
				}
				result.add(list2[i]);
			}
		}
		
		return result.toArray(new String[result.size()]);
		
    }
}
