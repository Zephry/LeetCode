package Roman_to_Integer;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int romanToInt(String s) {
        char[] S = s.toCharArray();
        int len = S.length;
        if(len < 1) {
        	return 0;
        }
        int sum = 0;
        int last = 1001;
        int num = -1;
        for(char c : S) {
        	
        	switch (c) {
        		case 'I':
        			num = 1;
        			break;
        		case 'V':
        			num = 5;
        			break;
        		case 'X':
        			num = 10;
        			break;
        		case 'L':
        			num = 50;
        			break;
        		case 'C':
        			num = 100;
        			break;
        		case 'D':
        			num = 500;
        			break;
        		case 'M':
        			num = 1000;
        			break;
        		
        	}
        	if(num <= last) {
            	sum = sum + num;
            	last = num;
            } else {
            	sum = sum + num - (2*last);
            	last = num;
            }
        }
        
        
        return sum;
        
    }

}
