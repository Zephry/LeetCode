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
		for(int i=1;i<600;i++) {
//			System.out.println(findNumNom(num, i));
			System.out.println(fastFindNumNom(num,i));
		}
			//2460375
	}
	
	
	public static long findNumNom(int[] num, int m) {
		int len = num.length;
		if(len == 0 || m == 0) {
			return 0;
		}
		int count = 0;
		long currentNum = 2;
		
		while(count != m) {
			long tmpNum = currentNum;
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
	
	
	public static long fastFindNumNom(int[] num, int m) {
		int len = num.length;
		if(len == 0 || m == 0) {
			return 0;
		}
		int count = 0;
		long[] uglyNum = new long[10000];
		uglyNum[count] = 1;
		
		

		count++;
		uglyNum[count] = num[0];
			

		long max = uglyNum[count];
		
		while(count != m) {
			long[] maxCandidates = new long[len];			//被乘数
			long[] minCandidates = new long[len];			//乘上之后的结果，用来找出最小的
			
			for(int n=0;n<len;n++) {
				for(int i=count;i>=0;i--) {
					if(i == 0 && num[n]*uglyNum[i] > max) {
						maxCandidates[n] = i;
						minCandidates[n] = num[n]*uglyNum[i];
						break;
					}else {
						if(num[n]*uglyNum[i-1] <= max && num[n]*uglyNum[i] > max) {
							maxCandidates[n] = i;
							minCandidates[n] = num[n]*uglyNum[i];
							break;
						}
					}
				}
			}
			count++;
			uglyNum[count] = findMin(minCandidates);
			max = uglyNum[count];
		}
		return uglyNum[count];
	}
	private static long findMin(long[] minCandidates) {
		long min = Long.MAX_VALUE;
		for(long thisMin : minCandidates) {
			if(thisMin < min && thisMin != 0) {
				min = thisMin;
			}
		}
		return min;
	}
	
	
}
