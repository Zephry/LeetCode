package Combinations;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine(3,6);
	}
	public static List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		return build(n,k,result,tmp, 1);
    }
	
	public static List<List<Integer>> build(int n, int k, List<List<Integer>> result, List<Integer> tmp, int position) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(tmp));
			return result;
		}
		for(int i=position;i<n+2-k;i++) {
			tmp.add(i);
			result = build(n,k-1,result,tmp,(i+1));
			tmp.remove(tmp.size()-1);
		}
		return result;
		
	}

}
