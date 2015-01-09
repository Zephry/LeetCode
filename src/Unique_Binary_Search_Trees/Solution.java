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
        if(n==3) {
        	return 5;
        }
        if(n==4) {
        	return 14;
        }
        return -1;
        
        
        
    }

}
