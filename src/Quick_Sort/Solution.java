package Quick_Sort;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,2,3};
		array = quickSort(array, 0, array.length-1);
	}
	
	public static int[] quickSort(int[] array, int start, int end) {
		int s = start;
		int e = end;
		if(end-start < 1) {
			return array;
		}
		if(end-start == 1) {
			if(array[start] > array[end]) {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
				
			}
			return array;
		}
		int key = array[start];
		
		while(start < end) {
			while(array[end] > key) {
				end--;
			}
			if(end <= start) {
				break;
			} else {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
			while(array[start] < key) {
				start++;
			}
			if(end <= start) {
				break;
			} else {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
		}
		array = quickSort(array, s, end);
		array = quickSort(array, end+1, e);
		return array;
	}

}
