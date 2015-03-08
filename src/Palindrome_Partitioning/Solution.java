package Palindrome_Partitioning;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partition("cbbbcc");
	}
	
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        
        
        return findPalindorm(s, result ,tmp);
        
        
        
    }
    public static List<List<String>> findPalindorm(String s, List<List<String>> result, List<String> tmp) {
    	
    	int len = s.length();
    	if(len == 1) {
    		
    		tmp.add(s);
    		result.add(new ArrayList<String>(tmp));
    		tmp.remove(tmp.size()-1);
    		return result;
    	}
    	if(len == 0) {
    		result.add(new ArrayList<String>(tmp));
    		return result;
    	}
    	
    	for(int j=1;j<len+1;j++) {
    		
    		String subString = s.substring(0, j);
    		if(isPalindorm(subString)) {
    			tmp.add(subString);
    			result = findPalindorm(s.substring(j), result, tmp);
    			tmp.remove(tmp.size()-1);
    		}
    	}
        return result;
    }
    
    public static boolean isPalindorm(String s) {
    	char[] letters = s.toCharArray();
    	int len = s.length();
    	for(int i=0;i<len/2;i++) {
    		if(letters[i] != letters[len-1-i]) {
    			return false;
    		}
    	}
    	return true;
    }

}
