package Container_With_Most_Water;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxArea(int[] height) {
        int len = height.length;
        
        if(len <= 1) {
        	return 0;
        }
        int start = 0;
        int end = len-1;
        int min = 0;
        if(height[start] < height[end]) {
        	min = height[start];
        }else {
        	min = height[end];
        }
        int C = min * (len-1);
        int tmpL = height[start];
        int tmpR = height[end];
        while(start < end) {
        	if(height[start] > tmpL) {
        		if(height[start] < height[end]) {
                	min = height[start];
                }else {
                	min = height[end];
                }
        		int tmpC = min * (end-start);
        		if(tmpC>C) {
        			C = tmpC;
        		}
        	}
        	if(height[end] > tmpR) {
        		if(height[start] < height[end]) {
                	min = height[start];
                }else {
                	min = height[end];
                }
        		int tmpC = min * (end-start);
        		if(tmpC>C) {
        			C = tmpC;
        		}
        	}
        	if(height[start] < height[end]) {
        		start++;
        		
        	}else {
        		end--;
        	}
        }
        
        return C;
    }

}
