package Two_Sum;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,3,2,4,0};
		int target = 0;
		twoSum(numbers, target);
	}
	
	
//	public int[] twoSum(int[] numbers, int target) {
//		int[] result = new int[2];
//		for(int m=0;m<numbers.length;m++) {
//			for(int n=m+1;n<numbers.length;n++) {
//				if(numbers[m] + numbers[n] == target) {
////					if(numbers[m] < numbers[n]) {
////						
////					}
//					result[0] = m+1;
//					result[1] = n+1;
//					return result;
//				} else if(numbers[n] > target) {
//					break;
//				}
//			}
//		}
//		return result;
//        
//    }
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		
		int other = 0;	//start from 1
		for(int m=0;m<numbers.length;m++) {
			Integer otherPart = table.get(target-numbers[m]);
			if(otherPart == null) {
				table.put(numbers[m], target-numbers[m]);
			} else {
				other = otherPart;
				break;
			}
		}
		
		for(int m=0;m<numbers.length;m++) {
			if(numbers[m] == other && result[0] == -1) {
				result[0] = m+1;
			}else if(numbers[m] == target-other && result[1] == -1) {
				result[1] = m+1;
			}
		}
		
		if(result[0] > result[1]) {
			int tmp = result[1];
			result[1] = result[0];
			result[0] = tmp;
		}
		return result;
		
	}

}
