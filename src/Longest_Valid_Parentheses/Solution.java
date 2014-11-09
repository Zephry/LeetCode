package Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestValidParentheses("(()(((()");
	}
	
	public static int longestValidParentheses(String s) {
		Stack<String> stack = new Stack<String>();
		int max = 0;
		int current = 0;
		int tmp = 0;
		String[] letters = s.split("");
		for(String letter : letters) {
			if(!letter.equals("")) {
				if(letter.equals("(")) {
					stack.push(letter);
					tmp = 0;
				}else {
					if(!stack.isEmpty()) {
						if(stack.lastElement().equals("(")) {
							stack.pop();
							current = current + 2;
							if(stack.isEmpty()) {
								if(current > max) {
									max = current;
								
								}
								tmp = 0;
							} else{
								tmp = tmp + 2;
							}
								
						}else {
							current = 0;
						}
					}else{
						current = 0;
						
					}
				}
			}
		}
		if(tmp > max) {
			max = tmp;
		}
		return max;
		
    }

}
