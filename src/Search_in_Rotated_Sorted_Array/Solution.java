package Search_in_Rotated_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int search(int[] A, int target) {
        int len = A.length;
        if(len == 0) {
        	return -1;
        }
        int start = 0;
        int end = len-1;
        int mid;
        
        while(start < end) {
        	mid = (start+end+1)/2;
        	if(target > A[mid]) {
        		start = mid;
        	}else if(target == A[mid]){
        		return mid;
        	}else {
        		if(target > A[len-1]) {
        			end = mid - 1;
        		}else {
        			start = mid;
        		}
        	}
        }
        if(A[start] != target) {
        	return -1;
        }else {
        	return start;
		}
    }

}
