package Decode_Ways;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
//		numDecodings("27");
		int[] array = {1,2};
		change((array[0]), array[1]);
		System.out.println(array[0]);
	}
	
    public static int numDecodings(String s) {
    	String[] tmp = s.split("");
    	String[] nums = new String[tmp.length-1];
    	for(int i=1;i<tmp.length;i++) {
    		nums[i-1] = tmp[i];
    	}
    	int len = nums.length;
    	if(len == 0) {
    		return 0;
    	}
    	int now = -1;
    	int[] count = new int[2];
    	count[0] = 1;
    	if(nums[0].equals("0")) {
    		return 0;
    	}
    	count[1] = 1;
    	for(int i=1;i<len;i++) {
    		now = Integer.valueOf(nums[i]);
    		if(now == 0) {
    			count[1] = 0;
    		}
			int t = (count[1] * 10) + now;
			if(t>26) {
				count[0] = count[1];
				
			}else {
				int tmpCount = count[1];
				count[1] = count[0] + count[1];
				count[0] = tmpCount;
			}
    		
    		
    	}
    	return count[1];
    	
    	
    	
    	
    }
    
    public static void change(Integer a, Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Field f = a.getClass().getDeclaredField("value");
    	f.setAccessible(true);           
    	f.setInt(a, 2);
//    	f = b.getClass().getDeclaredField("value");
//    	f.setAccessible(true);           
//    	f.setInt(b, b);
//    	Node tmp = a;
//    	a.val = 2;
//    	a.val = b.val;
//    	b = tmp;
//    	a = 2;
    }

}
