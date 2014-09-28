package Best_Time_to_Buy_and_Sell_Stock;

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
		int max = prices[0];
		int min = prices[0];
		int maxPofit = 0;
        for(int i = 0; i < prices.length; i++) {
        	if(prices[i] < min) {
        		int tmp = max-min;
        		if(tmp > maxPofit) {
        			maxPofit = tmp;
        		}
        		min = prices[i];
        		max = prices[i];
        	}
        	if(prices[i] > max) {
        		max = prices[i];
        		int tmp = max-min;
        		if(tmp > maxPofit) {
        			maxPofit = tmp;
        		}
        	}
        }
        return maxPofit;
    }
	
	
	

}
