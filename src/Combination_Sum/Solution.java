package Combination_Sum;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,2,7,5,6};
		combinationSum(a, 16);
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	candidates = quickSort(candidates, 0, candidates.length-1);
    	return findNextNum(candidates, target, result, tmp, 0);
    	
    	
    }
    
    public static List<List<Integer>> findNextNum(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int index) {
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(tmp));
    		return result;
    	}
    	if(target < candidates[index]) {
    		return result;
    	}
    	int len = candidates.length;
    	
    	for(int i=index;i<len;i++) {
    		if(target >= candidates[i]) {
    			tmp.add(candidates[i]);
    			result = findNextNum(candidates, target-candidates[i], result, tmp, i);
    			tmp.remove(tmp.size()-1);
    			
    		}
    	}
    	
    	return result;
    }
    
    public static int[] quickSort(int[] candidates, int start, int end) {
    	if(start >= end) {
    		return candidates;
    	}
    	int i = start;
    	int j =end;
    	int mid = candidates[start];
    	while(i < j) {
    		while(j>=start &&candidates[j] > mid) {
    			j--;
    		}
    		if(i>=j) {
    			break;
    		}else {
    			int tmp = candidates[i];
    			candidates[i] = candidates[j];
    			candidates[j] = tmp;
    		}
    		while( i<=end && candidates[i] < mid) {
    			i++;
    		}
    		if(i>=j) {
    			break;
    		}else {
    			int tmp = candidates[i];
    			candidates[i] = candidates[j];
    			candidates[j] = tmp;
    		}
    	}
    	
    	candidates = quickSort(candidates, i+1, end);
    	candidates = quickSort(candidates, start, i-1);
    	return candidates;
    	
    	
    	
    }

}
