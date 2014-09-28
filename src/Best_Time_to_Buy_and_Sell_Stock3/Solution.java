package Best_Time_to_Buy_and_Sell_Stock3;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,0,3,4};
//		maxProfit(prices);
		maxProfit(prices);
	}
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len < 2) {
			return 0;
		}
		int max = 0;
		int[] first = profit(prices);
		int[] second = Verprofit(prices);
		for(int i=0;i<len;i++) {
			if((first[i] + second[i]) > max) {
				max = first[i] + second[i];
			}
		}
		return max;
	}
	
	public static int[] profit(int[] prices) {
		int newMin = -1;
		int newMinPosition = -1;
		int[] result = new int[prices.length+1];
		result[0] = 0;
		int max = prices[0];
		int maxPosition = 0;
		int min = prices[0];
		int minPosition = 0;
		result[1] = 0;
		int lastPoint = prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			int currentPoint = prices[i];
			if(currentPoint > lastPoint) {
				if(newMin != -1) {
					int trend = currentPoint - newMin;
					if(trend >= result[i]) {
						min = newMin;
						minPosition = newMinPosition;
						max = currentPoint;
						maxPosition = i;
						newMin = -1;
						newMinPosition = -1;
						result[i+1] = trend;
					
					} else {
						result[i+1] = result[i];
					}
				} else if(currentPoint > max) {
					result[i+1] = result[i] + (currentPoint-max);
					maxPosition = i;
					max = currentPoint;
				} else {
					result[i+1] = result[i];
				}
			} else if(currentPoint < lastPoint) {
				if(currentPoint < min) {
					newMin = currentPoint;
					newMinPosition = i;
				}
				result[i+1] = result[i];
			} else {
				result[i+1] = result[i];
			}
			lastPoint = currentPoint;
		}
		
		return result;
		
	}
	
	public static int[] Verprofit(int[] prices) {
		int len = prices.length;
		int max = prices[len-1];
		int maxPosition = len;
		int min = prices[len-1];
		int minPosition = len;
		int lastPoint = prices[len-1];
		int newMax = -1;
		int newMaxPosition = -1;
		int[] result = new int[len+1];
		result[len] = 0;
		result[len-1] = 0;
		
		for(int i=len-2;i>=0;i--) {
			int currentPoint = prices[i];
			if(currentPoint < lastPoint) {
				if(newMax != -1) {
					int trend = newMax - currentPoint;
					if(trend > result[i+1]) {
						max = newMax;
						maxPosition = newMaxPosition;
						min = currentPoint;
						minPosition = i;
						newMax = -1;
						newMaxPosition = -1;
						result[i] = trend;
					} else {
						result[i] = result[i+1];
					}
				}else if(currentPoint < min) {
					result[i] = result[i+1] + (min-currentPoint);
					min = currentPoint;
					minPosition = i;
					
				} else {
					result[i] = result[i+1];
				}
			} else if(currentPoint > lastPoint) {
				if(currentPoint > max) {
					newMax = currentPoint;
					newMaxPosition = i;
				}
				result[i] = result[i+1];
			} else {
				result[i] = result[i+1];
			}
			
			
			
			
			lastPoint = currentPoint;
		}
		
		
		
		return result;
	}
}
