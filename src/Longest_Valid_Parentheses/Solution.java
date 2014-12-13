package Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestValidParentheses("()()");
	}
	
	public static int longestValidParentheses(String s) {
		String[] parts = s.split("");
		int len = parts.length;
		
		int[] position = new int[len-1];
		
		
		int left = 0;
		Stack<Integer> right = new Stack<Integer>();
		
		for(int i=1;i<len;i++) {
			position[i-1] = -1;
			if(parts[i].equals("(")) {
				left++;
				right.push(i-1);
			}else {
				if(left!=0) {
					left--;
					int nextPosition = right.pop();
					position[nextPosition] = i-1; 
					
				}
			}
		}
		int max = 0;
		int tmp = 0;
		for(int i=0;i<len-1;i++) {
			if(position[i]!= -1) {
				tmp = tmp + (position[i]-i+1);
				i = position[i];
				if(tmp > max) {
					max = tmp;
				}
			}else {
				if(tmp > max) {
					max = tmp;
				}
				tmp = 0;
			}
			
		}
		if(tmp > max) {
			max = tmp;
		}
		return max;
		
    }

}
