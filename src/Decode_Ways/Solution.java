package Decode_Ways;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numDecodings("27");
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

}
