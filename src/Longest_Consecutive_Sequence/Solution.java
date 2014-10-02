package Longest_Consecutive_Sequence;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int longestConsecutive(int[] num) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int len = num.length;
		
		if(len < 2) {
			return len;
		}
		
		int max = 1;
		
		
		for(int i=0;i<len;i++) {
			map.put(num[i], true);
		}
		
		for(int i=0;i<len;i++) {
			int current = num[i];
			int count = 1;
			int left = num[i]-1;
			int right = num[i] +1;
			while(map.containsKey(left) && map.get(left)) {
				count++;
				map.put(left, false);
				left--;
			}
			while(map.containsKey(right) && map.get(right)) {
				count++;
				map.put(right, false);
				right++;
			}
			
			if(count > max) {
				max = count;
			}
			
			
		}
		
		return max;
		
        
    }

}
