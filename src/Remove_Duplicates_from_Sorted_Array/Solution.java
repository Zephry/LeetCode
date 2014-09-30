package Remove_Duplicates_from_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,2};
		removeDuplicates(A);
	}
	
	
    public static int removeDuplicates(int[] A) {
    	int len = A.length;
    	if(len < 2) {
    		return len;
    	}
    	int count = 1;
    	int last = A[0];
    	int lastPosition = len+1;
    	for(int i=1;i<len;i++) {
    		int current = A[i];
    		if(current == last) {
    			A[i] = 0;
    			if(i <= lastPosition) {
    				lastPosition = i;
    			}
    		} else {
    			if(lastPosition != (len+1)) {
    				A[lastPosition] = current;
    				A[i] = 0;
    				lastPosition++;
    			}
    			
    			last = current;
    			count++;
    		}
    	}

    	

    	return count;
    	
    }
    
    
    
    
    
    
}
