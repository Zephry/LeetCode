package Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("()".split("").length);
		System.out.println(longestValidParentheses1("()(((()"));
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

	
	
	
	public static int longestValidParentheses1(String s) {
		int len = s.length(); 
		if(len == 0) {
			return 0;
		}
		Stack<Integer> last = new Stack<Integer>();
		
		String[] parts = s.split("");

		int count = 0;
		int tmp = 0;
		int max = 0;
		for(int i=0;i<len;i++) {
			if(parts[i].equals("(")) {
				count++;
				last.push(tmp);
				tmp  = 0;
			}else if(parts[i].equals(")")) {
				if(count == 0) {
					if(tmp > max) {
						max = tmp;
					}
					tmp = 0;
				}else {
					count--;
					tmp = last.pop() + tmp + 2;
					if(tmp > max) {
						max = tmp;
					}
				}
			}
			
			
			
		}
		return max;
		
		
		
	}
	
	
	
	
	
}
