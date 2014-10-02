package Jump_Game;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean canJump(int[] A) {
    	int len = A.length;
    	if(len < 2) {
    		return true;
    	}
    	
    	int maxRange = A[0];
    	for(int i=0;i<maxRange;i++) {
    		if(i >= len) {
    			return true;
    		}
    		int current = A[i];
    		if((current+i) > maxRange) {
    			maxRange = current + i;
    		}
    	}
    	if(maxRange >= len-1) {
    		return true;
    	} else {
    		return false;
    	}
    	
        
    }

}
