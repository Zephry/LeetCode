package Climbing_Stairs;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int climbStairs(int n) {
		int[] count = new int[n];
        if(n==0) {
        	return 1;
        }
        if(n==1) {
        	return 1;
        }
        if(n==2) {
        	return 2;
        }
        count[0] = 1;
        count[1] = 2;
        
        for(int i=2;i<n;i++) {
        	count[i] = count[i-1] + count[i-2];
        }
        return count[n-1];
        
    }

}
