package Subsets;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,3};
		subsets(S);
	}
	
	
	
    public static List<List<Integer>> subsets(int[] S) {
    	int len = S.length;
    	List<Integer> empty = new ArrayList<Integer>();
    	List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    	subsets.add(empty);
    	if(len < 1) {
    		return subsets;
    	}
    	S = quickSort(S, 0, S.length-1);
    	for(int i =0;i<len;i++) {
    		buildSubSet(subsets, empty, S, 0, i+1);
    	}
    	return subsets;
    }
    
    public static List<List<Integer>> buildSubSet(List<List<Integer>> subSet,List<Integer> current, int[] S, int position, int len) {
    	if(len == 0) {
    		return subSet;
    	}
    	for(int i=(position);i<(S.length-len+1);i++) {
    		current.add(S[i]);
    		if(len == 1) {
    			subSet.add(new ArrayList<Integer>(current));
    		}
    		subSet = buildSubSet(subSet, current, S, i + 1, len-1);
    		current.remove(current.size()-1);
    	}
    	return subSet;
    	
    }
    
    public static int[] quickSort(int[] array, int start, int end) {
		int s = start;
		int e = end;
		if(end-start < 1) {
			return array;
		}
		if(end-start == 1) {
			if(array[start] > array[end]) {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
				
			}
			return array;
		}
		int key = array[start];
		
		while(start < end) {
			while(array[end] > key) {
				end--;
			}
			if(end <= start) {
				break;
			} else {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
			while(array[start] < key) {
				start++;
			}
			if(end <= start) {
				break;
			} else {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
		}
		array = quickSort(array, s, end);
		array = quickSort(array, end+1, e);
		return array;
	}
    
//	for(int i =0;i<len;i++) {
//		buildSubSet(subsets, empty, S, len-1, i+1);
//	}
//	return subsets;
//}
//
//public static List<List<Integer>> buildSubSet(List<List<Integer>> subSet,List<Integer> current, int[] S, int position, int len) {
//	if(len == 0) {
//		return subSet;
//	}
//	for(int i=(position);i>=(len-1);i--) {
//		current.add(S[i]);
//		if(len == 1) {
//			subSet.add(new ArrayList<Integer>(current));
//		}
//		subSet = buildSubSet(subSet, current, S, i - 1, len-1);
    
    

}
