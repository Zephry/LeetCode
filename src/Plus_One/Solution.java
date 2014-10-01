package Plus_One;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] plusOne(int[] digits) {
        boolean up = false;
        
        int len = digits.length;
        if(len == 0) {
        	return digits;
        }
        if(digits[len-1] == 9) {
        	digits[len-1] = 0;
        	up = true;
        	for(int i=len-2;i>=0;i--) {
            	if(up) {
            		up = false;
            		if(digits[i] == 9) {
            			up = true;
            			digits[i] = 0;
            		} else {
            			digits[i]++;
            		}
            	} else {
            		break;
            	}
            }
        	if(up) {
        		digits = new int[len+1];
        		digits[0] = 1;
        		return digits;
        	}
        	
        	
        } else {
        	digits[len-1]++;
        	return digits;
        }
        
    	return digits;
    	
    	
    }
}
