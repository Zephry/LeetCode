package Unique_Binary_Search_Trees;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numTrees(int n) {
        if(n==1) {
        	return 1;
        }
        if(n==2) {
        	return 2;
        }
        int result = 2;
        for(int i=2;i<n;i++) {
        	if(result % 2 == 0) {
        		result = result * (result) + 1;
        	}else {
        		result = result * (result + 1);
        	}
        }
        return result;
        
        
        
    }

}
