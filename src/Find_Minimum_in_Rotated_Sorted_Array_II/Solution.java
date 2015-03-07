package Find_Minimum_in_Rotated_Sorted_Array_II;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int findMin(int[] num) {
    	int len = num.length;
		if(len == 1) {
			return num[0];
		}
		int min = num[0];
		for(int i=1;i<len;i++) {
			if(num[i] < min) {
				return num[i];
			}
		}
		return min;
    }
}
