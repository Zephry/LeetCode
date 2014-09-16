package Permutation_Sequence;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String getPermutation(int n, int k) {
    	List<Integer> num = new ArrayList<Integer>();
    	List<String> Permutation = new ArrayList<String>();
    	
    	if(n == 1) {
    		return "1";
    	} else {
    		for(int i = 0;i < n;i++) {
    			num.add(i+1);
	        }
    		
    		
        }
    }
    
    public List<String> getPermutAtIndex(List<Integer> num, int count, List<String> Permutation, String currentPermutation) {
    	if(num.size() == 1) {
    		currentPermutation += String.valueOf(num.get(0));
    		Permutation.add(currentPermutation);
//    		if(Permutation.size() == count) {
    			return Permutation;
//    		}
    	} else {
	    	for(int i = 0;i < num.size();i++) {
	    		currentPermutation += String.valueOf(num.get(i));
	    		num.remove(i);
	    		Permutation = getPermutAtIndex(num, count, Permutation, currentPermutation);
	    	}
    	}
    }
    
    
}
