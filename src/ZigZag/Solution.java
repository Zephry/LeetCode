package ZigZag;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sequence = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		longestZigZag(sequence);
	}
	
	public static int longestZigZag(int[] sequence) {
		int len = sequence.length;
		if(len == 0 || len == 1) {
			return len;
		}
		int[] interval = new int[len-1];
		for(int i=0;i<len-1;i++) {
			interval[i] = sequence[i+1] - sequence[i];
		}
		
		int sign = 0;
		int maxLen = 0;
		for(int i=0;i<len-1;i++) {
			if(sign == 0) {
				if(interval[i] < 0) {
					sign = -1;
					maxLen++;
				}else if(interval[i] > 0) {
					sign = 1;
					maxLen++;
				}else {
					
				}
			}else {
				if(interval[i] < 0 && sign == 1) {
					sign = -1;
					maxLen++;
				}else if(interval[i] > 0 && sign == -1) {
					sign = 1;
					maxLen++;
				}
			}
		}
		
		return maxLen+1;
		
		
		
		
		
		
		
		
	}

}
