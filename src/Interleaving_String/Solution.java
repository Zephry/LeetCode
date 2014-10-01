package Interleaving_String;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isInterleave("a", "b", "ab"));
	}
	
//    public static boolean isInterleave(String s1, String s2, String s3) {
//    	if(s1.length() == 0) {
//    		if(s3.equals(s2)) {
//    			return true;
//    		} else {
//    			return false;
//    		}
//    	} else if(s2.length() == 0){
//    		if(s3.equals(s1)) {
//    			return true;
//    		} else {
//    			return false;
//    		}
//    	} else if(s3.length() < (s1.length()+s2.length())){
//    		return false;
//    	} else {
//    		Stack<String> restS1 = new Stack<String>();
//    		Stack<String> restS2 = new Stack<String>();
//    		Stack<String> restS3 = new Stack<String>();
//    		restS3.add(s3);
//    		restS2.add(s2);
//    		restS1.add(s1);
//    		
//    		while(!restS3.empty()) {
//    			s3 = restS3.pop();
//    			s2 = restS2.pop();
//    			s1 = restS1.pop();
//    			
//
//    			
//    			while(s3 != null) {
//    				if(s1.length() == 0) {
//    		    		if(s3.equals(s2)) {
//    		    			return true;
//    		    		} else {
//    		    			return false;
//    		    		}
//    		    	} else if(s2.length() == 0){
//    		    		if(s3.equals(s1)) {
//    		    			return true;
//    		    		} else {
//    		    			return false;
//    		    		}
//    		    	}
//    				if(s3.charAt(0) == s1.charAt(0) && s3.charAt(0) == s2.charAt(0)) {
//    					restS1.add(s1);
//    					restS2.add(s2.substring(1));
//    					restS3.add(s3.substring(1));
//    					restS1.add(s1.substring(1));
//    					restS2.add(s2);
//    					restS3.add(s3.substring(1));
//    					break;
//    				} else if(s3.charAt(0) == s2.charAt(0)) {
//    					s3 = s3.substring(1);
//    					s2 = s2.substring(1);
//    					
//    				} else if(s3.charAt(0) == s1.charAt(0)) {
//    					s3 = s3.substring(1);
//    					s1 = s1.substring(1);
//    				} else {
//    					break;
//    				}
//    			}
//    			
//    			if(s3 == null) {
//    				return true;
//    			}
//    		}
//    		return false;
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    	}
//    	
//    	
//        
//    }
	
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() == 0) {
    		if(s3.equals(s2)) {
    			return true;
    		} else {
    			return false;
    		}
    	} else if(s2.length() == 0){
    		if(s3.equals(s1)) {
    			return true;
    		} else {
    			return false;
    		}
    	} else if(s3.length() != (s1.length()+s2.length())){
    		return false;
    	} else {
    		int[][] matrix = new int[s2.length()+1][s1.length()+1];
    		matrix[0][0] = 1;
    		int s3P = 0;
    		for(int i=1;i<s1.length()+1;i++) {
    			if(s1.charAt(i-1) == s3.charAt(s3P)) {
    				matrix[0][i] = 1;
    				s3P++;
    			} else {
    				break;
    			}

    		}
    		
    		for(int m=1;m<s2.length()+1;m++) {
    			
    			for(int n=0;n<s1.length()+1;n++) {
    				
    				if(matrix[m-1][n] == 1) {
    					if(s2.charAt(m-1) == s3.charAt(m+n-1)) {
    						matrix[m][n] = 1;
    						
    					}
    				}
    				if(n >=1) {
						if(matrix[m][n-1] == 1) {
							if(s1.charAt(n-1) == s3.charAt(m+n-1)) {
								matrix[m][n] = 1;
							}
						}
    				}
    			
    			}
    		}
    		
    		
    		if(matrix[s2.length()][s1.length()] == 1) {
    			return true;
    		} else {
    			return false;
    		}
    		
    		
    	}
	}

}
