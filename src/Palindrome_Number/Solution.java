package Palindrome_Number;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome(1000000001);
	}
	
    public static boolean isPalindrome(int x) {
    	if(x == 0) {
    		return true;
    	}
    	if(x < 0) {
    		return false;
    	}
        int len = 1;
        int tmp = x;
        while((tmp/10) >= 1) {
        	len++;
        	tmp = tmp/10;
        }
        int[] position = new int[len];
        for(int i=len;i>0;i--) {
        	int mod = (int) Math.pow(10,len-i+1);
        	position[i-1] = (x % mod)/(int) Math.pow(10,len-i);
        	x = x - (x % mod);
        }
        for(int i=0;i<len;i++) {
        	if(position[i] != position[len-1-i]) {
        		return false;
        	}
        }
        
        return true;
        
        
    }

}
