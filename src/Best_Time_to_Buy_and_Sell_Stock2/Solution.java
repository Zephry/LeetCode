package Best_Time_to_Buy_and_Sell_Stock2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2};
		maxProfit(prices);
	}
	public static int maxProfit(int[] prices) {
		if(prices.length <= 1) {
			return 0;
		}
		int startPosition = prices[0];
		int endPosition = prices[0];
		int lastPosition = prices[0];
		int maxProfit = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] < lastPosition) {	//sell and buy again
				maxProfit = maxProfit + (lastPosition - startPosition);
				startPosition = prices[i];
				lastPosition = prices[i];
			} else {						//hold
				lastPosition = prices[i];
			}
			
		}
		maxProfit = maxProfit + (lastPosition - startPosition);
		return maxProfit;

    }
	
	
	

}
