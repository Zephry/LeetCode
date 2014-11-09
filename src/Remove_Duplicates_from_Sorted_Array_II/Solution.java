package Remove_Duplicates_from_Sorted_Array_II;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,2,2,2,3,4,4,4};
		removeDuplicates(A);
	}
	
    public static int removeDuplicates(int[] A) {
    	int len = A.length;
    	if(len < 3) {
    		return len;
    	}
        int lastposition = 1;
        int last = A[0];
        int count = 1;
        for(int i=1;i<len;i++) {
        	if(A[i] == last) {
        		if(count == 1) {
        			A[lastposition] = A[i];
        			count++;
        			lastposition++;
        		}else {
        			
        		}
        	}else {
        		A[lastposition] = A[i];
        		last = A[i];
        		lastposition++;
        		count = 1;
        	}
        }
        return lastposition;
    }
    

}
