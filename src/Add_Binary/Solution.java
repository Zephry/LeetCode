package Add_Binary;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a = String.valueOf(10000000);
//		changeToTen(100);
//		changeToBinary(1);
		System.out.println(addBinary("11110011001011110111110001010000111110011110101100011111010010001000001101111001000111", "111001011011111010001001111001100000101010000101100010101100010010010011011000"));
	}
	
    public static String addBinary(String a, String b) {
    	int[] A = null;
    	int[] B = null;
    	String[] aArray = a.split("");
    	String[] bArray = b.split("");
    	int aLen = a.length();
    	int bLen = b.length();
    	String result = "";
    	int len = 0;
    	if(aLen > bLen) {
    		len = aLen;
    		A = new int[len];
    		B = new int[len];
    		for(int i=aLen;i>0;i--) {
    			A[i-1] = Integer.valueOf(aArray[i]);
    		}
    		for(int i=bLen;i>0;i--) {
    			B[i+(aLen-bLen)-1] = Integer.valueOf(bArray[i]);
    		}
    		
    	}else if(aLen <= bLen){
    		len = bLen;
    		A = new int[len];
    		B = new int[len];
    		for(int i=aLen;i>0;i--) {
    			A[i+(bLen-aLen)-1] = Integer.valueOf(aArray[i]);
    		}
    		for(int i=bLen;i>0;i--) {
    			B[i-1] = Integer.valueOf(bArray[i]);
    		}
    		
    	}
    	

		int in = 0;
		
		for(int i=len-1;i>=0;i--) {
			int tmp = A[i] + B[i] + in;
			if(tmp == 3) {
				result = "1" + result;
				in = 1;
			}else if(tmp == 2) {
				result = "0" + result;
				in = 1;
			}else {
				in = 0;
				result = String.valueOf(tmp) + result;
			}
		}
		if(result == "") {
			result = "0";
		}
		if(in == 1) {
			result = "1" + result;
		}
		return result;
    	
    }
    
    

}
