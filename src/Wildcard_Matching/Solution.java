package Wildcard_Matching;

import java.nio.charset.Charset;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("a", "**a"));
	}
	
	public static boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0 && sLen == 0) {
			return true;
		}else if(pLen == 0) {
			return false;
		}else if(sLen == 0 && p.equals("*")) {
			return true;
		}else if(sLen == 0) {
			return false;
		}
		
		String pattern = p.substring(0, 1);
		for(int i=1;i<pLen;i++) {
			if(p.charAt(i) == p.charAt(i-1)  && p.charAt(i) == '*') {
				
			}else {
				pattern = pattern + p.substring(i, i+1);
			}
		}
		pLen = pattern.length();
		
		int sCount = 0;
		int pCount = 0;
		for(int i=0;i<sLen;i++) {
			if(s.charAt(i) != '*') {
				sCount++;
			}
		}
		for(int i=0;i<pLen;i++) {
			if(pattern.charAt(i) != '*') {
				pCount++;
			}
		}
		if(pCount > sCount) {
			return false;
		}
		boolean[] last = new boolean[sLen];
		boolean[] next = new boolean[sLen];
		boolean first = false;
		if(s.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?') {
			last[0] = true;
		}else if(pattern.charAt(0) == '*') {
			last[0] = true;
			first = true;
		}else {
			return false;
		}
		
		for(int j = 0;j<pLen;j++) {
			for(int i = 0;i<sLen;i++) {
				
				if(last[i]) {
					if(pattern.charAt(j) == '*') {
						if(i<sLen-1) {
							last[i+1] = true;
						}
						if(first) {
							
							if(j<pLen-1 && (s.charAt(i) == pattern.charAt(j+1) || pattern.charAt(j+1) == '?')) {
								next[i] = true;
							}
							first = false;
						}
					}
					if(j<pLen-1) {
						if(pattern.charAt(j+1) == '*') {
							next[i] = true;
						}
					}
					if(j<pLen-1 && i<sLen-1) {
						
						if(s.charAt(i+1) == pattern.charAt(j+1) || pattern.charAt(j+1) == '?' || pattern.charAt(j+1) == '*') {
							next[i+1] = true;
						}
					}
					
				}
			}
			if(j<pLen-1) {
				last = next;
				next = new boolean[sLen];
			}
		}
		
		return last[sLen-1];
		
		
    }

	
	
	
	
	
}




	
