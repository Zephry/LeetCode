package Maximum_Subarray;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int maxSubArray(int[] A) {
        int max = 0;
        int NegetiveMax = Integer.MIN_VALUE;
        int len = A.length;
        
        boolean allNegetive = true;
        for(int i=0;i<len;i++) {
        	if(A[i] > 0) {
        		allNegetive = false;
        	} else {
        		if(A[i] > NegetiveMax) {
        			NegetiveMax = A[i];
        		}
        	}
        }
        
        if(allNegetive) {
        	return NegetiveMax;
        } else {
        	

        	int tmpSum = 0;
        	
        	for(int i=0;i<len;i++) {
        		tmpSum = tmpSum + A[i];
        		if(tmpSum <= 0) {
        			tmpSum = 0;
        		} else {
        			if(tmpSum > max) {
        				max = tmpSum;
        			}
        		}
        	}
        	return max;
        	
        	
        	
        	
        	
        	
        	
        	
        }
    }
    
    
    
    
}
