package UrglyNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[3];
		num[0] = 2;
		num[1] = 3;
		num[2] = 5;
		for(int i=0;i<845;i++) {
			System.out.println(findNumNom(num, i));
		}
	}
	
	
	public static int findNumNom(int[] num, int m) {
		int len = num.length;
		if(len == 0) {
			return 0;
		}
		int count = 0;
		int currentNum = 2;
		
		while(count != m) {
			int tmpNum = currentNum;
			for(int i=0;i<len;i++) {
				while(tmpNum % num[i] == 0) {
					tmpNum = tmpNum / num[i];
				}
			}
			if(tmpNum == 1) {
				count++;
			}
			currentNum++;
		}
		
		return currentNum-1;
	}
	
	
	public static int fastFindNumNom(int[] num, int m) {
		int len = num.length;
		if(len == 0) {
			return 0;
		}
		int count = 0;
		List<Integer> uglyNum = new ArrayList<Integer>();
		uglyNum.add(2);
		int max = 2;
		
		
	}
	
}
