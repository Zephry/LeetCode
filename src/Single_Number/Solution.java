package Single_Number;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[5];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 3;
		A[4] = 1;
		System.out.println(singleNumber(A));
	}
	 static int singleNumber(int A[])   
	    {  
	        int ans = 0;  
	        for (int i = 0; i < A.length; i++) {
	        	ans ^= A[i];  
	        }
	        
	        return ans;  
	    }  
}
