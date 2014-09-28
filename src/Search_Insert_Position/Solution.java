package Search_Insert_Position;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1};
		System.out.print(searchInsert(A, 1));
	}
	
	
    public static int searchInsert(int[] A, int target) {
        return search(A, target, 0, A.length-1);
    }
    
    public static int search(int[] A, int target, int start, int end) {
        int current = A[start];
        int len = end - start + 1;
        if(len == 1) {
        	if(A[start] > target) {
        		return start;
        	} else if(A[start] < target) {
        		return start+1;
        	} else {
        		return start;
        	}
        }
        if(len == 2) {
        	if(A[start] >= target) {
        		return start;
        	} else if(A[end] < target) {
        		return end+1;
        	} else {
        		return end;
        	}
        }
        int mid = len/2 + start;
        
        int midnum = A[mid];
        if(target > midnum) {
        	return search(A, target, mid, end);
        }else {
        	return search(A, target, 0, mid);
        }
        
    }
    
    
    

}
