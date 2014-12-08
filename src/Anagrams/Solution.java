package Anagrams;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a","a"};
		anagrams(strs);
	}
    public static List<String> anagrams(String[] strs) {
    	List<String> result = new ArrayList<String>();
    	Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    	int len = strs.length;
    	
    	for(int i=0;i<len;i++) {
    		List<Integer> pattern = new ArrayList<Integer>();
    		for(int j=0;j<26;j++) {
    			pattern.add(0);
    		}
    		char[] letters = strs[i].toLowerCase().toCharArray();
    		for(char letter : letters) {
    			pattern.set(Integer.valueOf(letter)-97, pattern.get(Integer.valueOf(letter)-97)+1);
    			
    		}
    		if(!map.containsKey(pattern)) {
    			map.put(pattern, i);
    		}else {
    			if(map.get(pattern) != -1) {
	    			result.add(strs[map.get(pattern)]);
	    			result.add(strs[i]);
	    			map.put(pattern, -1);
    			}else {
    				result.add(strs[i]);
    			}
    		}
    	}
    	
    	
    	return result;
    }
    

}
