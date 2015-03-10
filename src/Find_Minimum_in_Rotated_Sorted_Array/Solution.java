package Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMin(new int[]{7, 9, 1, 3, 5});
	}
	public static int findMin(int[] num) {						//wrong
		int len = num.length;
		if(len == 1) {
			return num[0];
		}
		if(num[0] < num[len-1]) {
			return num[0];
		}
		int start = 0;
		int end = len-1;
		while(start < end) {
			int mid = (start + end + 1)/2;
			if(num[mid] >= num[end]) {
				start = mid;
			}else {
				if(mid == end) {
					end = 0;
				}else {
					end = mid;
				}
			}
		}
		return start +1;
    }
	
	
	public int findMin2(int[] num) {
		int len = num.length;
		if(len == 1) {
			return num[0];
		}
		if(num[0] < num[len-1]) {
			return num[0];
		}
		int start = 0;
		int end = len-1;
		while(start < end) {
			int mid = (start+end+1) / 2;
			if(num[mid] < num[end]) {
				end = mid;
			}else {
				if(mid == end) {
					return num[mid];
				}
				start = mid;
			}
		}
		
		return num[start];
		
		
	}

}
