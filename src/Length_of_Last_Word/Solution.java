package Length_of_Last_Word;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int lengthOfLastWord(String s) {
    	s =s.trim();
    	if(s.length() == 0) {
    		return 0;
    	}
    	
    	String[] as = s.split(" ");
    	return as[as.length-1].length();
        
    }
    
    
    
}
