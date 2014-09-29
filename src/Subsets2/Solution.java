package Subsets2;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,9,8,3,-1,0};
		subsetsWithDup(num);
	}
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> subSets = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        subSets.add(empty);
        if(num.length < 1) {
        	return subSets;
        }
        num = quickSort(num, 0, num.length-1);
        for(int i=0;i<num.length;i++) {
        	subSets = buildSubSet(subSets, new ArrayList<Integer>(), num, 0, i+1, new ArrayList<Integer>());
        }
        return subSets;
    }
    public static List<List<Integer>> buildSubSet(List<List<Integer>> subSet,List<Integer> current, int[] S, int position, int len, List<Integer> last) {
    	if(len ==0) {
    		return subSet;
    	}
    	for(int i=position;i<(S.length-len+1);i++) {
    		current.add(S[i]);
    		if(len == 1 && !current.equals(last)) {
    			subSet.add(new ArrayList<Integer>(current));
    			last = new ArrayList<Integer>(current);
    		}
    		subSet = buildSubSet(subSet, current, S, i+1, len-1, last);
    		last = new ArrayList<Integer>(subSet.get(subSet.size()-1));
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
			while(array[end] >= key) {
				end--;
				if(end < 0) {
					return array;
				}
			}
			if(end <= start) {
				end = start;
				break;
			} else {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
			while(array[start] <= key) {
				start++;
				if(start > array.length-1) {
					return array;
				}
			}
			if(end <= start) {
				end = start;
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
    
    
}
