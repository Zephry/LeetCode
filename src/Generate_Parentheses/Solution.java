package Generate_Parentheses;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
	}
	
    public static List<String> generateParenthesis(int n) {
        String current;
        List<String> result = new ArrayList<String>();
        
        Queue<String> next = new LinkedList<String>();
        Queue<Integer> nextLeft = new LinkedList<Integer>();
        Queue<Integer> nextN = new LinkedList<Integer>();
        next.add("(");
        nextN.add(n-1);
        nextLeft.add(1);
        
        while(!next.isEmpty()) {
        	String tmp = next.poll();
        	int left = nextLeft.poll();
        	int n2 = nextN.poll();
        	if(n2 == 0 && left == 0) {
        		result.add(tmp);
        	}else {
	        	if(n2 > 0) {
	        		next.add(tmp+"(");
	        		nextLeft.add(left+1);
	        		nextN.add(n2-1);
	        	}
	        	if(left > 0) {
		        	next.add(tmp+")");
		        	nextLeft.add(left-1);
		        	nextN.add(n2);
	        	}
        	}
        	
        }
        return result;
    }

}
