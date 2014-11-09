package Valid_Sudoku;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(Integer.valueOf('2'));
	}
	public boolean isValidSudoku(char[][] board) {
		return isValidRow(board) && isValidCol(board) && isValidArea(board);
	}
    public boolean isValidRow(char[][] board) {
        int[] num = new int[10];
        
        for(int m=0;m<board.length;m++) {
        	for(int i=0;i<num.length;i++) {
            	num[i] = i+1;
            }
        	for(int n=0;n<board[m].length;n++) {
        		if(board[m][n] != '.') {
	        		if(num[Integer.valueOf(board[m][n])-49] != -1) {
	        			num[Integer.valueOf(board[m][n])-49] = -1;
	        		}else {
	        			return false;
	        		}
        		}
        	}
        }
        return true;
    }
    
    public boolean isValidCol(char[][] board) {
    	int[] num = new int[10];
        int mMax = board.length;
        int nMax = board[0].length;
        for(int m=0;m<mMax;m++) {
        	for(int i=0;i<num.length;i++) {
            	num[i] = i+1;
            }
        	for(int n=0;n<nMax;n++) {
        		if(board[n][m] != '.') {
	        		if(num[Integer.valueOf(board[n][m])-49] != -1) {
	        			num[Integer.valueOf(board[n][m])-49] = -1;
	        		}else {
	        			return false;
	        		}
        		}
        	}
        }
        return true;
    }
    
    public boolean isValidArea(char[][] board) {
    	int[] num = new int[10];
        int mMax = board.length;
        int nMax = board[0].length;
        for(int m=0;m<mMax;m=m+3) {
        	
        	for(int n=0;n<nMax;n=n+3) {
        		for(int i=0;i<num.length;i++) {
                	num[i] = i+1;
                }
        		for(int i=n;i<n+3;i++) {
        			for(int j=m;j<m+3;j++) {
        				if(board[i][j] != '.') {
        					if(num[Integer.valueOf(board[i][j]-49)] != -1) {
        						num[Integer.valueOf(board[i][j]-49)] = -1;
        					}else {
        						return false;
        					}
        				}
        			}
        		}
        	}
        }
        return true;
    }

}
