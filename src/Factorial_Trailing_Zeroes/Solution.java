package Factorial_Trailing_Zeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trailingZeroes(125);
	}
	
    public static int trailingZeroes(int n) {
    	int count = 0;
    	while(n != 0) {
    		
    		count += (int)n/5;
    		n = n/5;
    	}
    	return count;
    }

}
