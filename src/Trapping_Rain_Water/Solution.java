package Trapping_Rain_Water;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,4,1,2};
		trap(A);
	}
	
	
    public static int trap(int[] A) {
        int len = A.length;
        if(len < 2) {
        	return 0;
        }
        int[] L = new int[len];
        boolean start = false;
        int last = 0;
        for(int i=0;i<len;i++) {
        	if(A[i] != 0 && start == false) {
        		last = A[i];
        		start = true;
        	}
        	if(start) {
        		if(A[i] > last) {
        			last = A[i];
        		} else {
        			L[i] = (last-A[i]);
        		}
        	}
        }
        
        start = false;
        for(int i=len-1;i>=0;i--) {
        	if(!start) {
        		L[i] = 0;
        	}
        	if(A[i] != 0 && start == false) {
        		last = A[i];
        		start = true;
        	}
        	if(start) {
        		if(A[i] > last) {
        			last = A[i];
        			L[i] = 0;
        		} else {
        			int now = (last-A[i]);
        			if(now < L[i]) {
        				L[i] = now;
        			}
        		}
        	}
        }
        
        int sum = 0;
        for(int i=0;i<len;i++) {
        	sum = sum + L[i];
        }
        
        return sum;
        
    }

}
