package Count_and_Say;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(5);
	}
	
	public static String countAndSay(int n) {
		
		if(n < 1) {
			return "";
		}
		
		String result = "1";
		
		for(int i=1;i<n;i++) {
			char[] number = result.toCharArray();
			char last = number[0];
			int count = 1;
			result = "";					
			for(int m=1;m<number.length;m++) {
				if(number[m] == last) {
					count++;
				} else {
					result = result + String.valueOf(count) + String.valueOf(last);
					count = 1;
					last = number[m];
				}
			}
			
			result = result + String.valueOf(count) + String.valueOf(last);
			
			
			
		}
        
		
		
		
		return result;
		
    }

}
