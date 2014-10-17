package Jump_Game2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {10,3,0,0,0,0,0,1,1,2,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int[] B = new int[50000];
		for(int i=0;i<50000;i++) {
			B[i] = 1;
		}
		
		System.out.println(jump(A));
	}
    public static int jump(int[] A) {
        int len = A.length;
        if(len < 2) {
        	return 0;
        }
        
        int currentPosition = 0;
        int scope = A[0];
        int count = 0;
        while(currentPosition+scope < len-1) {
        	if(scope == 0) {
        		break;
        	}
        	int max = 0;
        	int position = 0;;
        	for(int i=currentPosition+1;i<(currentPosition+scope+1);i++) {
        		if((A[i]+i-currentPosition-1) > max && A[i] != 0) {
        			max = (A[i]+i-currentPosition-1);
        			position = i;
        		}
        	}
        	currentPosition = position;
        	count++;
        	scope = A[position];
        }
        count++;
        if(scope == 0) {
        	return 0;
        } else {
        	return count;
        }
    }
}
