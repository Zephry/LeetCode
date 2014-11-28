package Unique_Paths_II;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if(m == 0) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		if(n == 0) {
			return 0;
		}
		for(int i=0;i<m;i++) {
			if(obstacleGrid[i][0] != 1) {
				obstacleGrid[i][0] = 1;
			}else {
				obstacleGrid[i][0] = 0;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(obstacleGrid[0][i] != 1) {
				obstacleGrid[0][i] = 1;
			}else {
				obstacleGrid[0][i] = 0;
			}
		}
        
		for(int i=1;i<m;i++) {
    		for(int j=1;j<n;j++) {
    			if(obstacleGrid[i][j] != 1) {
    				obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
    			}else {
    				obstacleGrid[i][j] = 0;
    			}
    		}
    	}
		return obstacleGrid[m-1][n-1];
		
    }


}
