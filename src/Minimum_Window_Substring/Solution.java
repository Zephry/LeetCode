package Minimum_Window_Substring;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow("", "2123s");
	}
	
	public static String minWindow(String S, String T) {
		int len = S.length();
        String[] letters = new String[len];
        Map<String, Integer> target = new HashMap<String, Integer>();
        Map<String, Integer> first = new HashMap<String, Integer>();
        for(int i=0;i<len;i++) {
        	letters[i] = S.substring(i, i+1);
        }
        String[] t = T.split("");
        for(String l : t) {
        	if(!l.equals("")) {
        		
            	if(first.containsKey(l)) {
            		first.put(l, first.get(l)+1);
            		target.put(l, target.get(l)+1);
            	}else {
            		first.put(l, 1);
            		target.put(l, 1);
            	}
        	}
        }
        
        int slow = 0;
        Map<String, Integer> table = new HashMap<String, Integer>();
        int minWindow = Integer.MAX_VALUE;
        int minStart = 0, minEnd = -1;
        
        for(int i=0;i<len;i++) {
        	String cur = letters[i];
        	if(target.containsKey(cur)) {
        		if(first.containsKey(cur)) {
        			if(first.get(cur) == 1) {
        				first.remove(cur);
        			}else {
        				first.put(cur, first.get(cur)-1);
        			}
        			if(table.containsKey(cur)) {
        				table.put(cur, table.get(cur)+1);
        			}else {
        				table.put(cur, 1);
        			}
        		}else {
        			table.put(letters[i], table.get(letters[i])+1);
        		}
        		
        		if(first.isEmpty()) {
        			while(slow <= i) {
        				if(target.containsKey(letters[slow])) {
        					if(table.get(letters[slow]) > target.get(letters[slow])) {
        						
        						table.put(letters[slow], table.get(letters[slow])-1);
        						slow++;
        						
        					}else {
        						break;
        					}
        				}else {
        					slow++;
        				}
        			}
        			
        			int tmp = i-slow+1;
        			if(tmp < minWindow) {
        				minWindow = tmp;
        				minStart = slow;
        				minEnd = i;
        			}
        		}
        		
        	}
        }
        
        return S.substring(minStart, minEnd+1);
        
    }
	

}
