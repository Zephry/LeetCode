package Wildcard_Matching;

import java.nio.charset.Charset;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("abcderfgislghtnxl", "a*c***********************************************************f*isl*gh?nxl"));
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
		
		
		boolean[] last = new boolean[sLen];
		boolean[] next = new boolean[sLen];
		
		if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*') {
			last[0] = true;
		}else {
			return false;
		}
		
		for(int j = 0;j<pLen;j++) {
			for(int i = 0;i<sLen;i++) {
			
				if(last[i]) {
					if(p.charAt(j) == '*') {
						if(i<sLen-1) {
							last[i+1] = true;
						}
					}
					if(j<pLen-1 && i<sLen-1) {
						if(s.charAt(i+1) == p.charAt(j+1) || p.charAt(j+1) == '?') {
							next[i+1] = true;
						}
					}
					if(j<pLen-1) {
						if(p.charAt(j+1) == '*') {
							next[i] = true;
							
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




	
