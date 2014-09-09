package Longest_Common_Prefix;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test[] = new String[2];
		test[0] = "";
		test[1] = "a";
		longestCommonPrefix(test);
		
		
//		System.out.print(test.substring(0, 1));

	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		boolean wrong = false;
		String result = new String();
		for(int m = 0; m <= strs[0].length(); m++) {
			result = strs[0].substring(0, m);
			for(int i = 0; i < strs.length; i++) {
				if(strs[i].length() < m) {
					result = result.substring(0, result.length()-1);
					wrong = true;
					break;
				}
				if(! strs[i].substring(0, m).equals(result)) {
					result = result.substring(0, result.length()-1);
					wrong = true;
					break;
				}
			}
			if(wrong) {
				break;
			}
		}
		
		
        return result;
    }
}
