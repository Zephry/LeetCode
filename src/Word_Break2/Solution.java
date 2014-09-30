package Word_Break2;

import java.util.*;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("abc");
		dict.add("b");
		dict.add("cd");
		wordBreak(s, dict);
	}
    public static List<String> wordBreak(String s, Set<String> dict) {
    	List<String> result = new ArrayList<String>();
    	if(dict.isEmpty()) {
        	return result;
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
        		return result;
        	}
        }
        
        
        
        Stack<String> lasts = new Stack<String>();
        Stack<String> path = new Stack<String>();
        lasts.add(s);
        path.add("");
        while(!lasts.empty()) {
        	s = lasts.pop();
        	String lastpath = path.pop();
        	for(String word : dict) {
        		if(s.startsWith(word)) {
        			String tmp = lastpath;
        			if(lastpath == "") {
        				lastpath = word;
        			}else {
        				lastpath = lastpath + " " + word;
        			}
        			String tmps = s;
        			s = s.substring(word.length());
        			if(s.isEmpty()) {
        				result.add(lastpath);
        			} else {
        				lasts.add(s);
        				path.add(lastpath);
        			}
        			lastpath = tmp;
        			s =tmps;
        		}
        		
        		
        	}
        	
        	
        	
        }
        return result;

        
        
    }
    

}
