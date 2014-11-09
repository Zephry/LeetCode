package Sort_Colors;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sortColors(int[] A) {
		int[] colors = new int[3];
		
		int len = A.length;
		
		for(int i=0;i<len;i++) {
			colors[A[i]]++;
		}
		int count = 0;
		for(int i=0;i<3;i++) {
			for(int m=0;m<colors[i];m++) {
				A[count++] = i;
			}
		}
		
        
    }

}
