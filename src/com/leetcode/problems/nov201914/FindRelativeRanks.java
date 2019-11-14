package com.leetcode.problems.nov201914;

import java.util.Arrays;

/*
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

 */
public class FindRelativeRanks {

	public static void main(String[] args) {
		
		int[] nums = {5,4,3,2,1};
		System.out.println(Arrays.toString(findRelativeRanks(nums)));
	}

	private static String[] findRelativeRanksOld(int[] nums) {
     
		int goldMedalIndex = 0;
		int silverMedalIndex = 0;
		int bronzeMedalIndex = 0;
		
		int goldMedal = Integer.MAX_VALUE;
		int silverMedal = Integer.MAX_VALUE;
		int bronzeMedal = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] < goldMedal)
			{
				silverMedalIndex = goldMedalIndex;
				bronzeMedalIndex = silverMedalIndex;
				goldMedalIndex = i;
				silverMedal = goldMedal;
				bronzeMedal = silverMedal;
				goldMedal = nums[i];
			}
			else if(nums[i] < silverMedal && nums[i] != goldMedal)
			{
				bronzeMedalIndex = silverMedalIndex;
				silverMedalIndex = i;
				bronzeMedal = silverMedal;
				silverMedal = nums[i];
			}
			else if(nums[i] < bronzeMedal && nums[i] != goldMedal && nums[i] != silverMedal)
			{
				bronzeMedalIndex = i;
				bronzeMedal = nums[i];
			}
		}
		
		String[] str = new String[nums.length];
		
		for(int i = 0; i < nums.length; i++)
			if(i == goldMedalIndex)
				str[i] = "Gold Medal";
			else if(i == silverMedalIndex)
				str[i] = "Silver Medal";
			else if(i == bronzeMedalIndex)
				str[i] = "Bronze Medal";
			else
				str[i] = nums[i] + "";
		
		return str;
		
    }
	
	private static String[] findRelativeRanks(int[] nums) {
		int[][] pair = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
	}
}
