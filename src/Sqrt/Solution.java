package Sqrt;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sqrt(2);
	}
	
	public static int sqrt(int x) {
		if(x == 1) {
			return 1;
		}
		long big = x;
		long small = 1;
		
		while(big > small) {
			long mid = (big + small)/2;
			long tmp = mid*mid;
			if(tmp == x) {
				return (int)mid;
			}else if(tmp < x) {
				small = (int)(mid + 1);
			}else {
				big = (int)(mid - 1);
			}
		}
		if(big*big > x) {
			return (int)(big-1);
		}else {
			return (int)big;
		}
        
    }

}
