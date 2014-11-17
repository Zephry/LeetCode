package Word_Search;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a1 = "ABCE".toCharArray();
		char[] a2 = "SFCS".toCharArray();
		char[] a3 = "ADEE".toCharArray();
		char[] a4 = "aaa".toCharArray();
		char[][] board = {a1,a2,a3};
		String word = "ABCB";
		
		System.out.println(exist(board, word));
	}
	
	
    public static boolean exist(char[][] board, String word) {
    	if(word == "") {
    		return true;
    	}
        int row = board.length;
        if(row == 0) {
        	return false;
        }
        int col = board[0].length;
        boolean[][] used = new boolean[row][col];
        
        return (findNext(board, word.toCharArray(), used, 0,-1,-1));
        
    }
    
    public static boolean findNext(char[][] board, char[] letters, boolean[][] used, int index, int lastR, int lastC) {
    	if(index == letters.length) {
    		return true;
    	}
    	
    	int row = board.length;
    	int col = board[0].length;
    	if(lastR == -1) {																																								//first letter
    		for(int m=0;m<row;m++) {
    			for(int n=0;n<col;n++) {
    				if(letters[0] == board[m][n]) {
    					used[m][n] = true;
    					if(findNext(board, letters, used, 1, m, n)) {
    						return true;
    					}
    					used[m][n] = false;
    				}
    			}
    		}
    		return false;
    	}
    	if(lastR < row-1 && !used[lastR+1][lastC] && board[lastR+1][lastC] == letters[index]) {
    		used[lastR+1][lastC] = true;
    		if(findNext(board, letters, used, index+1, lastR+1, lastC)) {
    			return true;
    		}
    		used[lastR+1][lastC] = false;
    	}
    	if(lastC < col-1 && !used[lastR][lastC+1] && board[lastR][lastC+1] == letters[index]) {
    		used[lastR][lastC+1] = true;
    		if(findNext(board, letters, used, index+1, lastR, lastC+1)) {
    			return true;
    		}
    		used[lastR][lastC+1] = false;
    	}
    	if(lastR > 0 && !used[lastR-1][lastC] && board[lastR-1][lastC] == letters[index]) {
    		used[lastR-1][lastC] = true;
    		if(findNext(board, letters, used, index+1, lastR-1, lastC)) {
    			return true;
    		}
    		used[lastR-1][lastC] = false;
    	}
    	if(lastC > 0 && !used[lastR][lastC-1] && board[lastR][lastC-1] == letters[index]) {
    		used[lastR][lastC-1] = true;
    		if(findNext(board, letters, used, index+1, lastR, lastC-1)) {
    			return true;
    		}
    		used[lastR][lastC-1] = false;
    	}
    	
    	return false;
    }
	
}
