package Permutations_II;

import java.util.*;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {3,3,0,0,2,3,2};
		permuteUnique(a);
	}
	public static List<List<Integer>> permuteUnique(int[] num) {
		int len = num.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] used = new boolean[len];
		Set<List<Integer>> map = new HashSet<List<Integer>>();
		
        build(num,used, 0, tmp, result, map);
        return result;
    }
	
	public static void build(int[] num, boolean[] used, int position, List<Integer> cur, List<List<Integer>> result, Set<List<Integer>> map) {
		int len = num.length;
		if(position == len) {
			if(!map.contains(cur)) {
				result.add(new ArrayList<Integer>(cur));
				map.add(new ArrayList<Integer>(cur));
			}
			return;

		}
		Set<Integer> positionMap = new HashSet<Integer>();
		for(int i=0;i<len;i++) {
			if(!used[i] && !positionMap.contains(num[i])) {
				cur.add(num[i]);
				
				used[i] = true;
				build(num, used, position+1, cur, result, map);
				used[i] = false;

				cur.remove(cur.size()-1);
				positionMap.add(num[i]);
			}
		}
	}

}
