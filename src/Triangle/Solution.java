package Triangle;

import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if(row == 0) {
        	return 0;
        }
        int[] d = new int[row];
        for(int i=0;i<row;i++) {
        	for(int j=0;j<row-i;j++) {
        		if(i==0) {
        			d[j] = triangle.get(row-1).get(j);
        		}else {
        			d[j] = triangle.get(row-1-i).get(j) + min(d[j],d[j+1]);
        		}
        	}
        }
        return d[0];
    }
	
	public int min(int a, int b) {
		if(a<b) {
			return a;
		}else {
			return b;
		}
	}
}
