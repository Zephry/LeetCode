package Implement_strStr;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strStr("aaa", "a");
	}
	public static String strStr(String haystack, String needle) {
		if(needle == "") {
			return haystack;
		}
		if(haystack == "") {
		    return null;
		}
		Set<String> haystackLetter = new HashSet<String>();
		for(int i=0;i<haystack.length();i++) {
			haystackLetter.add(haystack.substring(i, i+1));
		}
		for(int i=0;i<needle.length();i++) {
			if(!haystackLetter.contains(needle.substring(i, i+1))) {
				return null;
			}
		}
		
        String result = null;
        String tmp = needle;
        int len = needle.length();
        Stack<Integer> position = new Stack<Integer>();
        Stack<String> resthay = new Stack<String>();
        Stack<String> restneedle = new Stack<String>();
        for(int i=0;i<haystack.length();i++) {
        	char letter = needle.substring(0, 1).charAt(0);
        	char hayletter = haystack.substring(i,i+1).charAt(0);
        	if(hayletter == letter) {
    			len = needle.substring(1).length();
    			if(haystack.substring(i+1).length() >= len) {
    				if(needle.length() == 1) {
        				result = tmp + haystack.substring(1);
        				return result;
    				}
    				position.add(Integer.valueOf(i));
        			resthay.add(haystack.substring(i+1));
        			restneedle.add(needle.substring(1));
            	}
    			
    		}
        }
        while(!resthay.isEmpty()) {
        	haystack = resthay.pop();
        	needle = restneedle.pop();
        	while(!haystack.isEmpty()) {

            	char letter = needle.substring(0, 1).charAt(0);
            	
        		char hayletter = haystack.substring(0,1).charAt(0);
        		if(hayletter == letter) {
        			if(needle.length() == 1) {
        				result = tmp + haystack.substring(1);
        				break;
        			} else {
        				len = needle.substring(1).length();
            			if(haystack.substring(1).length() >= len) {

            				haystack = (haystack.substring(1));
                			needle = (needle.substring(1));
                    	}
        			}
        		} else {
        			break;
        		}
            		
        	}
        

        }
        
        return result;
    }
}
