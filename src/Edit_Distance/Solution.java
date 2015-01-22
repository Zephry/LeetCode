package Edit_Distance;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minDistance("a", "ab");
	}
	
    public static int minDistance(String word1, String word2) {
    	if(word1.equals(word2)) {
    		return 0;
    	}
        int word1Len = word1.length();
        int word2Len = word2.length();
        if(word1Len == 0 || word2Len == 0) {
        	return word1Len > word2Len ? (word1Len-word2Len) : (word2Len-word1Len);
        }
        
        int[] lastDistance;
        int[] curDistance = new int[word2Len];
        
        
        boolean contained = false;
        String firstChar = word1.substring(0, 1);
        for(int i=0;i<word2Len;i++) {
        	if(contained) {
        		curDistance[i] = curDistance[i-1] + 1;
        	}else {
        		if(firstChar.equals(word2.substring(i, i+1))) {
        			contained = true;
        			curDistance[i] = i;
        		}else {
        			curDistance[i] = i+1;
        		}
        	}
        }
        
        for(int j=1;j<word1Len;j++) {
        	lastDistance = curDistance;
        	curDistance = new int[word2Len];
        	if(word1.substring(0, j+1).contains(word2.substring(0, 1))) {
        		curDistance[0] = j;
        	}else {
        		curDistance[0] = j+1;
        	}
        	for(int i=1;i<word2Len;i++) {
        		if(word1.substring(j, j+1).equals(word2.substring(i, i+1))) {
        			curDistance[i] = lastDistance[i-1];
        		}else {
        			int min = findMin(lastDistance[i-1], lastDistance[i], curDistance[i-1]);
        			curDistance[i] = min+1;
        		}
        	}
        }
        
        
        return curDistance[word2Len-1];
    }
    public static int findMin(int a, int b, int c) {
    	if(a < b) {
    		if(a < c) {
    			return a;
    		}else {
    			return c;
    		}
    	}else {
    		if(b < c) {
    			return b;
    		}else {
    			return c;
    		}
    	}
    }

}
