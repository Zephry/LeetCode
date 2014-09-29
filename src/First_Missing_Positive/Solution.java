package First_Missing_Positive;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1};
		firstMissingPositive(A);
	}    
	public static int firstMissingPositive(int[] A) {
        int len = A.length;
        if(len == 0) {
        	return 1;
        }
        for(int i=0;i<len;i++) {
        	int current = A[i];
        	if(current < 1 || current > len) {
        		A[i] = 0;
        	} else if(current != (i+1)){
        		int tmp = A[current-1];
        		if(tmp != current) {
        			A[current-1] = current;
            		A[i] = tmp;
            		i--;
        		}
        		
        	}
        }
		
        for(int i=0;i<len;i++) {
        	int current = A[i];
        	if(current != (i+1)) {
        		return i+1;
        	}
        }
        return len+1;
        
        
    }

}
