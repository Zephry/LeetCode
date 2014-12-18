package Find_Peak_Element;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPeakElement(new int[]{2,1});
	}
	
    public static int findPeakElement(int[] num) {
        int len = num.length;
        if(len == 1) {
        	return 0;
        }
        int[] newNum = new int[len+2];
        newNum[0] = Integer.MIN_VALUE;
        for(int i=0;i<len;i++) {
        	newNum[i+1] = num[i];
        }
        newNum[len+1] = Integer.MIN_VALUE;
        return findPeak(newNum, 0, len+1);
    }
    
    public static int findPeak(int[] num, int start, int end) {
    	int mid = (start+end)/2;
    	if(mid == 0) {
    		return findPeak(num, mid+1, end);
    	}
    	if(num[mid] < num[mid-1]) {
    		return findPeak(num, start, mid-1);
    	}else if(num[mid] < num[mid+1]) {
    		return findPeak(num, mid+1, end);
    	}else {
    		return mid-1;
    	}
    	
    	
    }

}
