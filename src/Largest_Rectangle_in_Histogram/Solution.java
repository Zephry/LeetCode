package Largest_Rectangle_in_Histogram;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(largestRectangleArea2(new int[] {3,6,5,7,4,8,1,0}));
//		System.out.println(largestRectangleArea(new int[] {5,4, 1, 2}));
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
        	
        	int maxArea = 0;
        	Stack<Integer> stack = new Stack<Integer>();
        	int last = Integer.MIN_VALUE;
        	for(int i=0;i<len;i++) {
        		if(height[i] >= last) {
        			stack.push(i);
        			last = height[i];
        		}else {
        			int highestPosition = 0;
        			int lasthighest = 0;
        			while(!stack.isEmpty()) {
        				highestPosition = stack.peek();
        				
    					int tempArea = lasthighest * (i-highestPosition-1);
        				if(tempArea > maxArea) {
        					maxArea = tempArea;
        				}
        				if(height[highestPosition] < height[i]) {
            				break;
        				}else {
        					lasthighest = height[stack.pop()];
        					tempArea = height[highestPosition] * (i-highestPosition);
            				if(tempArea > maxArea) {
            					maxArea = tempArea;
            				}
            				if(stack.empty()) {
            	        		tempArea = height[highestPosition] * (i);
            		        	if(tempArea > maxArea) {
            						maxArea = tempArea;
            					}
            	        	}
        				}
        				
        			}
        			
        			stack.push(i);
        			last = height[i];
        		}
        	}
        	while(!stack.isEmpty()) {
				int highestPosition = stack.pop();
				int tempArea = height[highestPosition] * (len-highestPosition);
	        	if(tempArea > maxArea) {
					maxArea = tempArea;
				}
	        	if(stack.empty()) {
	        		tempArea = height[highestPosition] * (len);
		        	if(tempArea > maxArea) {
						maxArea = tempArea;
					}
	        	}
        	}
        	
        	return maxArea;
        	
        	        		
        }
       
    }
    
    
    
    
    
    
    
    

}
