package Largest_Rectangle_in_Histogram;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(largestRectangleArea(new int[] {3,6,5,7,4,8,1,0}));
		System.out.println(largestRectangleArea(new int[] {5,4, 1, 2}));
		System.out.println(largestRectangleArea(new int[] {4,2,0,3,2,5}));
	}

	
    public static int largestRectangleArea2(int[] height) {
        int len = height.length;
        int max = 0;
        if(len == 0) {
        	return 0;
        }
        int last = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
    	for(int i=0;i<len+1;i++) {
    		int curHeight;
    		if(i == len) {
    			curHeight = 0;
    		}else {
    			curHeight = height[i];
    		}
    		int width;
    		if(curHeight >= last) {
    			stack.push(i);
    			last = curHeight;
    			
    		}else {
    			
    			last = curHeight;
    			int minHeight = Integer.MAX_VALUE;
    			while(!stack.empty() && height[stack.peek()] > curHeight) {
    				int start = stack.pop();
    				int size;
    				width = i-start-1;
    				size = width*minHeight;
        			if(size > max) {
        				max = size;
        			}
    				if(height[start] < minHeight) {
    					minHeight = height[start];
    					width++;
        				size = width*minHeight;
            			if(size > max) {
            				max = size;
            			}
    				}else {
    					max = max + minHeight;
    				}
    				
    			}
    			if(stack.empty()) {
    				width = i-0;
    			}else {
    				width = i - stack.peek()-1;
    			}
    			int size = width*minHeight;
    			if(size > max) {
    				max = size;
    			}
    			
    			
    			
    			stack.push(i);
    		}
    	}
    	
    	
    	
    	return max;
    	
    }
    
    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        if(len == 0) {
        	return 0;
        }else {
        	int[] h = Arrays.copyOf(height, len+1);
        	h[len] = 0;
        	Stack<Integer> stack = new Stack<Integer>();
        	int last = h[0];
        	stack.push(0);
        	int maxArea = 0;
        	for(int i=1;i<len+1;i++) {
        		if(h[i] >= last) {
        			stack.push(i);
        			last = h[i];
        		}else {
        			int leftStart = 0;
        			while(!stack.empty()) {
        				int leftStartPosition = stack.peek();
        				
        				int tmpArea = leftStart * (i-leftStartPosition-1);
    					if(tmpArea>maxArea) {
    						maxArea = tmpArea;
    					}
        				if(h[leftStartPosition] > h[i]) {
        					leftStart = h[leftStartPosition];
        					stack.pop();
        					tmpArea = leftStart * (i-leftStartPosition);
        					if(tmpArea>maxArea) {
        						maxArea = tmpArea;
        					}
        				}else {
        					break;
        				}
        			}
        			if(stack.empty()) {
        				int tmpArea = leftStart * (i);
    					if(tmpArea>maxArea) {
    						maxArea = tmpArea;
    					}
        			}
        			stack.push(i);
        			last = h[i];
        		}
        	}
        	return maxArea;
        	
        	        		
        }
       
    }
    
    
    
    
    
    
    
    

}
