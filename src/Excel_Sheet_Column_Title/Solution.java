package Excel_Sheet_Column_Title;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(convertToTitle(701));
	}
//	title = String.valueOf(Character.toChars((n%26)+65)) + title;
    public static String convertToTitle(int n) {
    	String title = "";
    	
    	while(n > 26) {
    		if((n%26) == 0) {    			
    			title = 'Z' + title;
    			n = (n/26)-1;
    		}else {
    			title = String.valueOf(Character.toChars((n%26)+64)) + title;
    			n = (n/26);
    		}
    	}

    	title = String.valueOf(Character.toChars(n+64)) + title;
    	
    	return title;
    }

}
