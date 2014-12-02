package Search_a_2D_Matrix;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	int len = matrix.length;
    	int i;
    	for(i=0;i<len;i++) {
    		if(matrix[i][0] == target) {
    			return true;
    		}else if(matrix[i][0] > target) {
    			break;
    		}
    	}
    	if(i==0) {
    		return false;
    	}
    	if(matrix[i-1][matrix[0].length-1] < target) {
    		
    		return false;
    	}
    	int rowLen = matrix[0].length;
    	for(int j=rowLen-1;j>0;j--) {
    		if(matrix[i-1][j] == target) {
    			return true;
    		}
    	}
    	return false;
        
    }

}
