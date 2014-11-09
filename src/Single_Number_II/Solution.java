package Single_Number_II;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] A) {
    	int three, two, one;
    	three = two = one = 0;
    	for(int i=0;i<A.length;i++) {
    		three = two & A[i];
    		two = two | (one & A[i]);
    		one = one | A[i];
    		
    		one = one & ~three;
    		two = two & ~three;
    	}
    	return one;
        
    }

}
