package Merge_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,0,0,0};
		int[] B = {2,5,6};
		merge(A,3,B,3);
	}
	
	
	
    public static void merge(int A[], int m, int B[], int n) {
        int currentA = 0;
        int currentB = 0;
        int count = 0;
        while(currentA < m && currentB < n) {
        	if(A[currentA] < B[currentB]) {
        		
        		count++;
        		currentA++;
        	} else {

        		for(int i=A.length-1;i>count;i--) {
        			A[i] = A[i-1];
        		}
        		A[count] = B[currentB];
        		count++;
        		currentB++;
        		currentA++;
        		m++;
        	}
        }
        
        
        while(currentB < n) {

        	for(int i=A.length-1;i>count;i--) {
    			A[i] = A[i-1];
    		}
    		A[count] = B[currentB];
        	count++;
        	currentB++;
        }
        
    }
    
    
    
    
}
