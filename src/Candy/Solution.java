package Candy;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int candy(int[] ratings) {
    	int len = ratings.length;
    	int[] nums = new int[len];
    	int count = len;
    	
    	for(int i=1;i<len;i++) {
    		if(ratings[i] > ratings[i-1]) {
    			if(nums[i] <= nums[i-1]) {
    				nums[i] = nums[i-1]+1;
    			}
    		}
    	}
    	
    	for(int i=len-2;i>=0;i--) {
    		if(ratings[i] > ratings[i+1]) {
    			if(nums[i] <= nums[i+1]) {
    				nums[i] = nums[i+1]+1;
    			}
    		}
    	}
    	
    	for(int num : nums) {
    		count = count + num;
    	}
    	return count;
    	
    }
    
	
	

}
