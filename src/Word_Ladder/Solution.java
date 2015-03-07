package Word_Ladder;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength("hit", "cog", set));
	}
	
    public static int ladderLength(String start, String end, Set<String> dict) {
    	int maxLen = dict.size();
    	Queue<String> startPoints = new LinkedList<String>();
    	Queue<Integer> distances = new LinkedList<Integer>();
    	dict.remove(start);
    	startPoints.add(start);
    	distances.add(0);
    	
    	while(!startPoints.isEmpty()) {
    		String startPoint = startPoints.poll();
    		int distance = distances.poll();
    		int len = startPoint.length();
    		String tmp = "";
    		
    		for(int j=0;j<len;j++) {
    			char[] tmpWord = startPoint.toCharArray();;
	    		for(int i=0;i<26;i++) {
	    			tmpWord[j] = (char)(97+i);
	    			tmp = new String(tmpWord);
	        		if(tmp.equals(end)) {
	        			return distance+2;
	        		}else {
	        			if(dict.contains(tmp)) {
	        				dict.remove(tmp);
	        				startPoints.add(tmp);
	        				distances.add(distance+1);
	        				
	        			}
	        		}
	    		}
    		}
    	}
    	
    	return 0;
    	
    }
    
//    public int findNext(String start, String end, Set<String> dict, int len) {
//    	
//    	String tmp = "";
//    	for(int i=0;i<26;i++) {
//    		tmp = String.valueOf((char)97) + start.substring(1);
//    		if(tmp.equals(end)) {
//    			return len+1;
//    		}else {
//    			if(dict.contains(tmp)) {
//    				dict.remove(tmp);
//    				return findNext(tmp, end, dict, len+1);
//    			}else {
//    				
//    			}
//    		}
//    	}
//    	return 0;
//    }

}
