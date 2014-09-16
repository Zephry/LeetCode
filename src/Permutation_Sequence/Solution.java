package Permutation_Sequence;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String getPermutation(int n, int k) {
    	List<Integer> num = new ArrayList<Integer>();
    	
    	if(n == 1) {
    		return "1";
    	} else {
    		for(int i = 0;i < n;i++) {
    			num.add(i+1);
	        }
    		
    		
        }
    }
    
    public String getPermutAtIndex(List<Integer> num, int index, int count) {
    	if(num.size() == 1) {
    		return String.valueOf(num.get(0));
    	}
    	for(int i = 0;i < num.size();i++) {
    		
    	}
    }
    
    
}
