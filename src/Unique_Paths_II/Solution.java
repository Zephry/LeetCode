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
    		for(int j=0;j<n;j++) {
    			if(i == 0 && j == 0) {
    				if(obstacleGrid[i][j] != 1) {
    					obstacleGrid[i][j] = 1;
    				}else {
    					obstacleGrid[i][j] = 0;
    				}
    			}else {
	    			if(obstacleGrid[i][j] != 1) {
	    				if(i == 0) {
	    					obstacleGrid[i][j] = obstacleGrid[i][j-1];
	    				}else if(j == 0) {
	    					obstacleGrid[i][j] = obstacleGrid[i-1][j];
	    				}else {
	    					obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
	    				}
	    			}else {
	    				obstacleGrid[i][j] = 0;
	    			}
    			}
    		}
    	}
		return obstacleGrid[m-1][n-1];
		
    }


}
