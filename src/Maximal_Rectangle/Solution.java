package Maximal_Rectangle;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maximalRectangle(new char[][] {"01101".toCharArray(),"11010".toCharArray(),"01110".toCharArray(),"11110".toCharArray(),"11111".toCharArray(),"00000".toCharArray()}));
	}
	
    public static int maximalRectangle(char[][] matrix) {
    	int n = matrix.length;
    	if(n == 0) {
    		return 0;
    	}
    	int m = matrix[0].length;
    	if(m == 0) {
    		return 0;
    	}
    	int[][] rectangleMatrix = new int[n][m];
    	for(int i=0;i<m;i++) {
    		rectangleMatrix[0][i] = Integer.valueOf(matrix[0][i])-48;
    	}
    	for(int j=1;j<n;j++) {
    		for(int i=0;i<m;i++) {
        		if(Integer.valueOf(matrix[j][i]) == 48) {
        			rectangleMatrix[j][i] = 0;
        		}else {
        			rectangleMatrix[j][i] = rectangleMatrix[j-1][i] + 1; 
        		}
        	}
    	}
    	
    	int max = 0;
    	for(int j=0;j<n;j++) {
    		int tmp = maximalInRow(rectangleMatrix[j], m);
    		if(tmp > max) {
    			max = tmp;
    		}
    	}
    	return max;
    	
    }
    
    public static int maximalInRow(int[] row, int len) {
    	int last = -1;
    	int maxSize = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	int minHeight = Integer.MAX_VALUE;
    	for(int i=0;i<len;i++) {
    		if(stack.empty() || row[i] >= last) {
    			stack.push(i);
    			last = row[i];
    		}else {
    			last = row[i];
    			minHeight = Integer.MAX_VALUE;
    			int width = 0;
    			while(!stack.empty() && row[stack.peek()] > row[i]) {
    				int position = stack.pop();
    				int height = row[position];
    				
    				width = i - position - 1;
    				maxSize = maxSize(minHeight, width, maxSize);
    				if(height < minHeight) {
    					minHeight = height;
    				}
    			}
    			if(stack.empty()) {
    				width = i;
    				maxSize = maxSize(minHeight, width, maxSize);
    			}else {
    				width = i - stack.peek() - 1;
    				maxSize = maxSize(minHeight, width, maxSize);
    			}
    			stack.push(i);
    			
    		}
    		
    		
    	}
    	
    	while(!stack.empty()) {
			int position = stack.pop();
			int height = row[position];
			int width = len - position - 1;
			maxSize = maxSize(minHeight, width, maxSize);
			if(height < minHeight) {
				minHeight = height;
			}
			width = len - position;
			maxSize = maxSize(minHeight, width, maxSize);
		}
    	int width = len;
		maxSize = maxSize(minHeight, width, maxSize);
		
    	return maxSize;
    	
    	
    	
    	
    	
    	
    }
    
    public static int maxSize(int height, int width, int max) {
		int size = height * width;
		if(size > max) {
			return size;
		}else {
			return max;
		}
		
	}
}
