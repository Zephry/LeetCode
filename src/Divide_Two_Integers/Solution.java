package Divide_Two_Integers;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-2147483648));
		divide(-2147483648, 2);
	}
	public static int divide(int dividend, int divisor) {
        int count = 1;
        int result = 0;
        int mod = divisor;
        int sign = 0;
        long divisor1 = divisor;
        long dividend1 = dividend;
        if(divisor1 == 1) {
        	return (int) dividend1;
        }
        if(dividend1 == divisor1) {
        	return 1;
        }
        if(divisor1 == Integer.MIN_VALUE)
        {
        	return 0;
        }
        if(Long.signum(dividend1) == -1) {
        	sign++;
        	dividend1 = (0-dividend1);
        }
        if(Long.signum(divisor1) == -1) {
        	sign--;
        	divisor1 = (0-divisor1);
        }
        
        if(Math.abs(dividend1) < Math.abs(divisor1)) {
        	return 0;
        }
        
        while(dividend1 >= mod) {
        	if(dividend1 >= divisor1) {
        		dividend1 = dividend1 - divisor1;
        		result = result + count;
        		count = count << 1;
        		divisor1 = divisor1 << 1;
        		if(divisor1 < 0) {
        			break;
        		}
        	} else {
        		while(dividend1 < divisor1 && count > 0) {
        			divisor1 = divisor1 >> 1;
        			count = count >> 1;
        		}
        		if(count < 1) {
        			break;
        		}
        		dividend1 = dividend1 - divisor1;
        		result = result + count;
        	}
        }
        if(sign != 0) {
        	result = (0-result);
        }
        return result;
    }

}
