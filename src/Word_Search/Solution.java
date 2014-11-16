package Word_Search;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a1 = "ABCE".toCharArray();
		char[] a2 = "SFES".toCharArray();
		char[] a3 = "ADEE".toCharArray();
		char[] a4 = "aaa".toCharArray();
		char[][] board = {a1,a2,a3};
		String word = "ABCESEEEFS";
		
		System.out.println(exist(board, word));
	}
	
    public static boolean exist(char[][] board, String word) {
    	
    	if(word.equals("")) {
    		return true;
    	}
        char[] letters = word.toCharArray();
        int row = board.length;
        if(row == 0) {
        	return false;
        }
        int col = board[0].length;
        Stack<UsedTable> used = new Stack<UsedTable>();
        Stack<Integer> wordPos = new Stack<Integer>();
        Stack<Position> nextPos = new Stack<Position>();
        findFirstLetter(letters[0], nextPos, board, wordPos, used);
        while(!nextPos.empty()) {
        	if(findNextLetter(letters, wordPos, nextPos, board, used)) {
        		return true;
        	}
        }
		return false;
        
        
    }
    public static void findFirstLetter(char firstLetter, Stack<Position> nextPos, char[][] board, Stack<Integer> wordPos, Stack<UsedTable> used) {
    	int row = board.length;
    	int col = board[0].length;
    	
    	for(int m=0;m<row;m++) {
    		for(int n=0;n<col;n++) {
    			if(board[m][n] == firstLetter) {
    				nextPos.push(new Position(m, n));
    				UsedTable cur = new UsedTable(row, col);
    				cur.used[m][n] = true;
    				used.add(cur);
    				wordPos.push(1);
    			}
    		}
    	}
    }
    
    public static boolean findNextLetter(char[] letters, Stack<Integer> wordPos, Stack<Position> nextPos, char[][] board, Stack<UsedTable> used) {
    	UsedTable curUsed = used.pop();
    	int pos = wordPos.pop();
    	if(pos == letters.length) {
    		return true;
    	}
    	char letter = letters[pos];
    	int rowMax = board.length;
    	int colMax = board[0].length;
    	Position currentPos = nextPos.pop();
    	int row = currentPos.row;
    	int col = currentPos.col;
    	
    	if(row < rowMax-1 && board[row+1][col] == letter && !curUsed.used[row+1][col]) {
    		nextPos.push(new Position(row+1, col));
    		
    		curUsed.used[row+1][col] = true;
    		used.add(new UsedTable(curUsed));
    		curUsed.used[row+1][col] = false;
    		wordPos.push(pos+1);
    	}
    	if(col < colMax-1 && board[row][col+1] == letter && !curUsed.used[row][col+1]) {
    		nextPos.push(new Position(row, col+1));
    		curUsed.used[row][col+1] = true;
    		used.add(new UsedTable(curUsed));
    		curUsed.used[row][col+1] = false;
    		wordPos.push(pos+1);
    	}
    	if(row > 0 && board[row-1][col] == letter && !curUsed.used[row-1][col]) {
    		nextPos.push(new Position(row-1, col));
    		curUsed.used[row-1][col] = true;
    		used.add(new UsedTable(curUsed));
    		curUsed.used[row-1][col] = false;
    		wordPos.push(pos+1);
    	}
    	if(col > 0 && board[row][col-1] == letter && !curUsed.used[row][col-1]) {
    		nextPos.push(new Position(row, col-1));
    		curUsed.used[row][col-1] = true;
    		used.add(new UsedTable(curUsed));
    		curUsed.used[row][col-1] = false;
    		wordPos.push(pos+1);
    	}
    	
    	return false;
    }

};

class Position{
	int row;
	int col;
	Position(int r, int c) {
		row = r;
		col = c;
	}
};
class UsedTable {
	boolean[][] used;
	UsedTable(int r, int c) {
		used = new boolean[r][c];
	}
	UsedTable(UsedTable usedC) {
		used = usedC.used;
	}
}
