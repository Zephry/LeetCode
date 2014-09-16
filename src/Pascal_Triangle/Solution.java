package Pascal_Triangle;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
        for(int m = 0; m < numRows; m++) {
        	List<Integer> newLine = new ArrayList<Integer>();
        	if(m == 0) {
        		newLine.add(1);
        	} else if(m == 1) {
        		newLine.add(1);
        		newLine.add(1);
        	} else {
        		newLine.add(1);
        		List<Integer> lastLine = result.get(m-1);
        		for(int i = 0; i < lastLine.size() - 1; i++) {
        			newLine.add(lastLine.get(i)+lastLine.get(i+1));
        		}
        		newLine.add(1);
        	}
        	result.add(newLine);
        }
        return result.get(numRows-1);
    }
}
