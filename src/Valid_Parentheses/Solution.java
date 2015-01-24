package Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValid(String s) {
        int len = s.length();
        if(len == 0) {
        	return true;
        }
        
        String[] parentheses = s.split("");
        Stack<String> sub = new Stack<String>();
        for(String parenthes : parentheses) {
        	if(parenthes.equals("(")) {
        		sub.push(parenthes);
        	}else if(parenthes.equals("[")) {
        		sub.push(parenthes);
        	}else if(parenthes.equals("{")) {
        		sub.push(parenthes);
        	}else if(parenthes.equals(")")) {
        		if(!sub.empty() && sub.peek().equals("(")) {
        			sub.pop();
        		}else {
        			return false;
        		}
        	}else if(parenthes.equals("]")) {
        		if(!sub.empty() && sub.peek().equals("[")) {
        			sub.pop();
        		}else {
        			return false;
        		}
        	}else if(parenthes.equals("}")) {
        		if(!sub.empty() && sub.peek().equals("{")) {
        			sub.pop();
        		}else {
        			return false;
        		}
        	}
        }
        if(sub.empty()) {
        	return true;
        }else {
        	return false;
        }
        
    }

}
