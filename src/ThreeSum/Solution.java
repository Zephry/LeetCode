package ThreeSum;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeSum(new int[]{11,2,-10,12,-10,11,9,4,2,-9,-12,-4,0,8,-6,-5,8,5,-15,-14,-1,14,-6,-12,3,-5,7,-3,9,-8,-3,-3,2,-6,-14,7,12,11,-4,-9,-13,-1,3,2,-8,12,4,7,-6,-4,1,8,-5,10,12,13,12,4,-13,-2,4,-9,10,-9,-8,4,5,-11,0,-13,-12,-6,-7,6,11,-7,-5,-8,-15,4,3,1,-11,13,-12,8,3,8,-10,5,-9,9,11,9,7,10,-2,-3,14,13});
		
		
//		List<Integer> a = new ArrayList<Integer>();
//		List<Integer> b = new ArrayList<Integer>();
//		a.add(1);
//		b.add(1);
//		List<List<Integer>> c = new ArrayList<List<Integer>>();
//		c.add(a);
//		if(!c.contains(b)) {
//			c.add(b);
//		}
//		Set<Integer> set = new HashSet<Integer>();
//		set.add(0);
//		
//		set.add(10);
//		set.add(8);
//		set.add(1);
//		set.add(3);
//		for(Integer a : set) {
//			System.out.println(a);
//		}
		
	}
	
    public static List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int len = num.length;
    	if(len <= 2) {
    		return result;
    	}
    	Arrays.sort(num);
    	
    	List<Integer> numList = new ArrayList<Integer>();

    	for(int i=0;i<len;i++) {
    		numList.add(num[i]);
    	}
    	int last = Integer.MIN_VALUE;
    	for(int i=0;i<len;i++) {
    		if(num[i] != last && num[i] <= 0) { 
	    		numList.remove((Integer)num[i]);
	    		result = twoSum(numList, -num[i], result);
	    		last = num[i];
	    		
    		}
    		numList.remove((Integer)num[i]);
    	}

    	return result;
    }
    
    public static List<List<Integer>> twoSum(List<Integer> num, int target, List<List<Integer>> result) {
    	int len = num.size();
    	if(len <= 1) {
    		return result;
    	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<len;i++) {
    		if(map.containsKey(num.get(i))) {
    			List<Integer> tmp = new ArrayList<Integer>();
    			if(-target < target-num.get(i)) {
    				tmp.add(-target);
        			tmp.add(target-num.get(i));
    			}else {
        			tmp.add(target-num.get(i));
        			tmp.add(-target);
    			}
    			
    			tmp.add(num.get(i));
    			if(!result.contains(tmp)) {
    				result.add(tmp);
    			}
    			
    		}else {
    			map.put(target-num.get(i), num.get(i));
    		}
    	}
    	return result;
    }
    

}
