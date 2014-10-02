package Search_for_a_Range;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		searchRange(A,2);
	}
	
	
    public static int[] searchRange(int[] A, int target) {
    	int[] result = new int[2];
    	
    	int len = A.length;
    	if(len < 1) {
    		return result;
    	}
    	if(len == 1) {
    		if(A[0] == target) {
    			return result;
    		} else {
    			result[0] = -1;
    			result[1] = -1;
    			return result;
    		}
    	}
    	
    	result[0] = -1;
    	result[1] = -1;
    	
    	int start = 0;
    	int end = len-1;
    	int mid = (end-start)/2;
    	boolean left = false;
    	boolean right = false;
    	
    	while(A[mid] != target || !left) {
    		if(A[mid] == target) {
    			if(mid == 0) {
    				result[0] = mid;
    				left = true;
    			} else if(A[mid-1] < target) {
    				result[0] = mid;
    				left = true;
    			} else {
    				end = mid;
    				mid = (start+end)/2;
    			}
    		} else if(A[mid] < target) {
    			start = mid+1;
    			mid = (start+end)/2;
    			if(mid == start-1) {
    				return result;
    			}
    			
    		} else {
    			end = mid;
    			mid = (start+end)/2;
    			if(mid == end) {
    				return result;
    			}
    		}
    	}
    	
    	start = 0;
    	end = len-1;
    	mid = (end-start)/2;
    	while(A[mid] != target || !right) {
    		if(A[mid] == target) {
    			if(mid == len-1) {
    				result[1] = mid;
    				right = true;
    			} else if(A[mid+1] > target) {
    				result[1] = mid;
    				right = true;
    			} else {
    				start = mid+1;
    				mid = (start+end)/2;
    			}
    		} else if(A[mid] < target) {
    			start = mid+1;
    			mid = (start+end)/2;
    			if(mid == start-1) {
    				return result;
    			}
    			
    		} else {
    			end = mid;
    			mid = (start+end)/2;
    			if(mid == end) {
    				return result;
    			}
    		}
    	}
    	
    	
    	
    	return result;
    	
    	
        
    }

}
