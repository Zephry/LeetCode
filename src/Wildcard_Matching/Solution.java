package Wildcard_Matching;

import java.nio.charset.Charset;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	public static boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0 && sLen == 0) {
			return true;
		}else if(pLen == 0) {
			return false;
		}
		
		String pattern = String.valueOf(p.charAt(0));
		
		for(int i=1;i<pLen;i++) {
			if(p.charAt(i-1) == p.charAt(i) && p.charAt(i) == '*') {
				
			}else {
				pattern = pattern + String.valueOf(p.charAt(i));
			}
		}
		
		return Match(s, pattern, 0, 0, sLen, pattern.length());
		
    }

	public static boolean Match(String s, String p, int sPosition, int pPosition, int sLen, int pLen) {
		
		while(sPosition < sLen && pPosition < pLen) {
			Character letter = p.charAt(pPosition);
			Character target = s.charAt(sPosition);
			if(letter.equals('*')) {
				for(int i=sPosition;i<sLen;i++) {
					if(Match(s, p, i, pPosition+1, sLen, pLen)) {
						return true;
					}
				}
				return false;
			}else if(letter.equals('?')) {
				
			}else {
				if(!letter.equals(target)) {
					return false;
				}
				
			}
			
			sPosition++;
			pPosition++;
			
			
		}
		if(sPosition == sLen && (pPosition-pLen) == 1 && p.charAt(pPosition) == '*') {
			return true;
		}else if(sPosition == sLen && pPosition == pLen) {
			return true;
		}else {
			return false;
		}
		
	}
}


//Character letter = p.charAt(pPosition);
//if(letter.equals('?')) {
//	if(sLen == 0) {
//		return true;
//	}
//	for(int i=1;i<sLen;i++) {
//		if(Match(s.substring(i), p.substring(1))) {
//			return true;
//		}
//	}
//	return false;
//}else if(letter.equals('*')) {
//	if(sLen == 0) {
//		return false;
//	}
//	return Match(s.substring(1), p.substring(1));
//}else {
//	if(sLen == 0) {
//		return false;
//	}
//	if(letter.equals(s.charAt(0))) {
//		return Match(s.substring(1), p.substring(1));
//	}else {
//		return false;
//	}
//}


	
