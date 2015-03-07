package Majority_Element;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int majorityElement(int[] num) {
        int len = num.length;
        if(len == 1) {
        	return num[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<len;i++) {
        	if(!map.containsKey(num[i])) {
        		map.put(num[i], 1);
        	}else {
        		int count = map.get(num[i]) + 1;
        		if(count > len/2) {
        			return num[i];
        		}else {
        			map.put(num[i], count);
        		}
        	}
        }
        return 0;
    }

}
