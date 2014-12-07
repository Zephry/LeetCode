package Permutations;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		permute(a);
	}
	
	public static List<List<Integer>> permute(int[] num) {
		int len = num.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] used = new boolean[len];
        return build(num,used, 0, tmp, result);
    }
	
	public static List<List<Integer>> build(int[] num, boolean[] used, int position, List<Integer> cur, List<List<Integer>> result) {
		
		int len = num.length;
		if(position == len) {
			
			result.add(new ArrayList<Integer>(cur));
			return result;
		}
		for(int i=0;i<len;i++) {
			if(!used[i]) {
				cur.add(num[i]);
				used[i] = true;
				build(num, used, position+1, cur, result);
				used[i] = false;
				cur.remove(cur.size()-1);
			}
		}
		return result;
	}

}
