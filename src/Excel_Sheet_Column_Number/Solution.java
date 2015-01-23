package Excel_Sheet_Column_Number;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		titleToNumber("AB");
	}
	
    public static int titleToNumber(String s) {
    	int num = 0;
        char[] letters = s.toCharArray();
        int len = letters.length;
        for(int i=0;i<len;i++) {
        	num  = (int) (num + ((Integer.valueOf(letters[i]) - 64)*Math.pow(26, len-i-1)));
        	
        }
        return num;
    }

}
