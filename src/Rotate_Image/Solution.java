package Rotate_Image;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[5][5];
		int count = 1;
		for(int m = 0;m<5;m++) {
			for(int n = 0;n<5;n++) {
				matrix[m][n] = count;
				count ++;
			}
		}
		
		rotate(matrix);
	}
	
	
	public static void rotate(int[][] matrix) {
		int len = matrix.length -1;
		if(len == 0) {
			return;
		}
        for(int m = 0; m < len; m += 2) {
        	for(int n = (m/2); n < (len - (m/2)); n++) {
        		int m2 = m/2;
        		int temp;
        		temp = matrix[len-n][m2];
        		matrix[len-n][m2] = matrix[len-m2][len-n];
        		matrix[len-m2][len-n] = matrix[n][len-m2];
        		matrix[n][len-m2] = matrix[m2][n];
        		matrix[m2][n] = temp;
        	}
        }
    }
	
	
}
