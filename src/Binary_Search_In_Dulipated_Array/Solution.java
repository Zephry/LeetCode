package Binary_Search_In_Dulipated_Array;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find2(new int[]{1}, 2));
		System.out.println(find(new int[]{1,1,1,1,1,1,1}, 2));
	}
	
	public static int find(int[] array, int target) {										//duplicated element in array  			find the min
		int len = array.length;
		if(len == 0) {
			return -1;
		}
		int start = 0;
		int end = len-1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(target > array[mid]) {
				start = mid+1;
			}else if(target == array[mid]) {
				return mid;
			}else {
				end = mid-1;
			}
			
		}
		return -1;
		
		
	}
	
	public static int find2(int[] array, int target) {									//no duplicated element
		int len = array.length;
		if(len == 0) {
			return -1;
		}
		int start = 0;
		int end = len-1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(target > array[mid]) {
				start = mid+1;
			}else if(target == array[mid]) {
				return mid;
			}else {
				end = mid-1;
			}
			
		}
		return -1;
	}

}
