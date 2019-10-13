package com.zalando.test;

import java.util.HashMap;
import java.util.Map;

public class IdenticalPairs {

	public static void main(String[] args) {
		
		int[] A = {3,5,6,3,3,5};
		
		System.out.println(solution(A));

	}

	private static int solution(int[] A) {
		
		int MAX_LIMIT=1000000000;
		Map<Integer,Integer> map = new HashMap<>(); 
        
        // Find the frequency of each number 
        for(int i = 0; i < A.length; i++) 
        { 
        if(map.containsKey(A[i])) 
            map.put(A[i],map.get(A[i]) + 1); 
        else
            map.put(A[i], 1);  
        } 
        int ans=0;  
         
        // Calculate the count of equal pairs
        for(Map.Entry<Integer,Integer> it : map.entrySet()) 
        {  
            int count = it.getValue(); 
            ans += (count * (count - 1)) / 2; 
        }
        return ans > MAX_LIMIT? MAX_LIMIT: ans; 
    }
	
}
