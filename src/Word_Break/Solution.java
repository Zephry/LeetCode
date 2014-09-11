package Word_Break;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a = "abc";
//		System.out.print(a = a.substring(3));
//		if(a.isEmpty()) {
//			int b = 1;
//		}
			Set<String> dict = new HashSet<String>();
			dict.add("a");
			dict.add("b");
			wordBreak("ab", dict);
	}
	public static boolean wordBreak(String s, Set<String> dict) {
        if(dict.isEmpty()) {
        	return false;
        }
        Set<Character> letterDict = new HashSet<Character>();
        for(String word : dict) {
        	char[] letters = word.toCharArray();
        	for(char letter : letters) {
        		letterDict.add(Character.valueOf(letter));
        	}
    	}
        Set<Character> letterString = new HashSet<Character>();
        char[] string = s.toCharArray();
        for(char letter : string) {
        	letterString.add(Character.valueOf(letter));
        }
        for(Character letter : letterString) {
        	if(!letterDict.contains(letter)) {
        		return false;
        	}
        }
        Stack<String> lasts = new Stack<String>();
        Stack<String> otherword = new Stack<String>();
        while(!s.isEmpty()) {
//        	String last = s;
        	for(String word : dict) {
        		if(s.startsWith(word)) {
//        			s = s.substring(word.length());
        			otherword.add(word);
        			lasts.add(s);
        		}
        		
        	}
        	if(!otherword.isEmpty()) {
    			String MatchWord = otherword.pop();
    			String Lasts = lasts.pop();
    			s = Lasts.substring(MatchWord.length());
    		} else {
    			return false;
    		}
        }
        
        return true;
        
    }
	
	
	
	
	
}
