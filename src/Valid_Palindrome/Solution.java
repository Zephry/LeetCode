package Valid_Palindrome;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aa";
		System.out.println((int)'9');
		
	}
	
    public static boolean isPalindrome(String s) {
        if(s == null) {
        	return false;
        }
        if(s == "") {
        	return true;
        }
        char[] letters = s.toCharArray();
        int i = 0;
        int j = letters.length-1;
        while(j>i) {
        	if(isValid(letters[i])) {
        		if(isValid(letters[j])) {
        			if(!isEqual(letters[i], letters[j])) {
        				return false;
        			} else {
        				i++;
        				j--;
        			}
        		}else {
        			j--;
        		}
        	} else {
        		i++;
        	}
        }

        return true;
        
    }
    
    public static boolean isValid(char l) {
    	int num = (int)l;
    	if(num >= 65 && num <= 90) {
    		return true;
    	} else if(num >= 97 && num <= 122) {
    		return true;
    	}else if(num >= 48 && num <= 57) {
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public static boolean isEqual(char a, char b) {
    	int numa = (int)a;
    	int numb = (int)b;
    	if(numa >= 65 && numa <= 90) {
    		a = (char)(numa+32);
    	}
    	if(numb >= 65 && numb <= 90) {
    		b = (char)(numb+32);
    	}
    	if(a == b) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
