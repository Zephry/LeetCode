package Unique_Binary_Search_Trees;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numTrees(int n) {
    	if(n==0) {
    		return 0;
    	}
        int[] count = new int[n+1];
        count[0] = 1;
        for(int i=1;i<n+1;i++) {
        	for(int j=0;j<i;j++) {
        		count[i] = count[i] + (count[j]*count[i-1-j]);
        	}
        	
        }
        
        return count[n];
        
    }

}
