package Longest_Substring_Without_Repeating_Characters;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")) {
        	return 0;
        }
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        int tmpLen = 0;
        int maxLen = 0;
        int start = 1;
        String[] subStrings = s.split("");
        int len = subStrings.length;
        for(int i=0;i<len;i++) {
        	if(!subStrings[i].equals("")) {
        		if(!table.containsKey(subStrings[i])) {
        			tmpLen++;
        			table.put(subStrings[i], i);
        		}else {
        			if(tmpLen > maxLen) {
        				maxLen = tmpLen;
        			}
        			int index = table.get(subStrings[i]);
        			tmpLen = tmpLen - (index-start);
        			for(int j=start;j<=index;j++) {
        				table.remove(subStrings[j]);
        			}
        			table.put(subStrings[i], i);
        			start = index+1;
        			
        			
        			
        		}
        	}
        }
        if(tmpLen > maxLen) {
        	maxLen = tmpLen;
        }
        return maxLen;
        
        
        
    }

}
