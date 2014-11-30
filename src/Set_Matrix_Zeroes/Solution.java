package Set_Matrix_Zeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;
        int rowLen = matrix.length;
        if(rowLen == 0) {
        	return;
        }
        int colLen = matrix[0].length;
        if(colLen == 0) {
        	return;
        }
        for(int i=0;i<rowLen;i++) {
        	if(matrix[i][0] == 0) {
        		row = true;
        	}
        }
        for(int i=0;i<colLen;i++) {
        	if(matrix[0][i] == 0) {
        		col = true;
        	}
        }
        
        
        for(int i=1;i<rowLen;i++) {
        	for(int j=1;j<colLen;j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        for(int i=0;i<rowLen;i++) {
        	if(matrix[i][0] == 0) {
        		for(int j=1;j<colLen;j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int i=0;i<colLen;i++) {
        	if(matrix[0][i] == 0) {
        		for(int j=1;j<rowLen;j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        
        if(row) {
        	for(int i=0;i<rowLen;i++) {
            	matrix[i][0] = 0;
        	}
        }
        if(col) {
        	for(int j=0;j<colLen;j++) {
        		matrix[0][j] = 0;
        	}
        }
        
        
        
    }

}
