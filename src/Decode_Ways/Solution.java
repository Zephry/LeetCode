package Decode_Ways;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numDecodings(String s) {
    	String[] tmp = s.split("");
    	String[] nums = new String[tmp.length-1];
    	for(int i=1;i<tmp.length;i++) {
    		nums[i-1] = tmp[i];
    	}
    	int len = nums.length;
    	int last = -1;
    	int now = -1;
    	int[] count = new int[len];
    	
    	for(int i=0;i<len;i++) {
    		now = Integer.valueOf(nums[i]);
    		if(last == -1) {
    			count[i] = 1;
    		}else {
    			int t = (last * 10) + now;
    			if(t>26) {
    				count[i] = count[i-1];
    			}else {
    				count[i] = count[i-1] + count[i-2];//TODO
    			}
    		}
    		
    	}
    	
    	
    	
    	
    }

}
