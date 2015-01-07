package Decode_Ways;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("100"));
		

	}
	
    public static int numDecodings(String s) {

    	int len = s.length();
    	if(len == 0) {
    		return 0;
    	}
    	String[] tmp = s.split("");
    	int[] nums  = new int[len];
    	
    	for(int i=1;i<len+1;i++) {
    		nums[i-1] = Integer.valueOf(tmp[i]);
    	}
    	
    	if(nums[0] == 0) {
    		return 0;
    	}
    	
    	int[] count = new int[len+1];
    	count[0] = 1;
    	count[1] = 1;
    	
    	for(int i=2;i<len+1;i++) {
    		if(nums[i-1] == 0) {
    			if(nums[i-2] == 0) {
    				return 0;
    			}
    			if((nums[i-2]*10)+nums[i-1] > 26) {
    				return 0;
    			}else {
    				count[i] = count[i-2];
    				
    			}
    		}else {
    			if(nums[i-2] == 0) {
    				count[i] = count[i-1];
    			}else {
	    			if((nums[i-2]*10)+nums[i-1] > 26) {
	    				count[i] = count[i-1];
	    			}else {
	    				count[i] = count[i-1] + count[i-2];
	    			}
    			}
    		}
    	}
    	
    	
    	return count[len];
    }
    
    

}
