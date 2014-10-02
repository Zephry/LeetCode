package Gas_Station;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {1,2};
		int[] cost = {2,1};
		canCompleteCircuit(gas, cost);
	}
	
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	int gasSum = 0;
    	int costSum = 0;
    	for(int i=0;i<gas.length;i++) {
    		gasSum = gasSum + gas[i];
    	}
    	for(int i=0;i<cost.length;i++) {
    		costSum = costSum + cost[i];
    	}
    	if(costSum > gasSum) {
    		return -1;
    	}
    	
    	int tank = 0;
    	
    	for(int i=0;i<gas.length;i++) {
    		tank = tank + gas[i];
    		
    		for(int m=i;m<gas.length;m++) {
    			if(tank >= cost[m]) {
        			tank = tank - cost[m];
        			
        			if(m == gas.length-1) {
        				m = -1;
        			}
        			if(m+1 == i) {
        				return i;
        			}
        			tank = tank + gas[m+1];
        			
        		} else {
        			tank = 0;
        			break;
        		}
    		}
    		
    		
    	}
    	
    	
    	return -1;
        
    }
	
	

}
