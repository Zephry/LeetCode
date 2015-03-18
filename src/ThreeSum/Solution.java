package ThreeSum;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int len = num.length;
    	if(len <= 2) {
    		return result;
    	}
    	List<Integer> numList = new ArrayList<Integer>();
    	Set<Set<Integer>> tmp = new HashSet<Set<Integer>>();
    	List<Set<Integer>> tmpResult = null;
    	for(int i=0;i<len;i++) {
    		numList.add(num[i]);
    	}
    	for(int i=0;i<len;i++) {
    		numList.remove(num[i]);
    		tmp = twoSum(numList, -num[i], tmp);
    	}
    	tmpResult = new ArrayList<Set<Integer>>(tmp);
    	for(Set<Integer> tmpSet : tmpResult) {
    		result.add(new ArrayList<Integer>(tmpSet));
    	}
    	return result;
    }
    
    public Set<Set<Integer>> twoSum(List<Integer> num, int target, Set<Set<Integer>> result) {
    	int len = num.size();
    	if(len <= 1) {
    		return result;
    	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<len;i++) {
    		if(map.containsKey(num.get(i))) {
    			Set<Integer> tmp = new HashSet<Integer>();
    			tmp.add(-target);
    			tmp.add(num.get(i));
    			tmp.add(target-num.get(i));
    			result.add(tmp);
    			
    		}else {
    			map.put(target-num.get(i), num.get(i));
    		}
    	}
    	return result;
    }
    

}
