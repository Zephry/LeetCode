package Change100Money;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] D = new int[101];
		for(int i=0;i<101;i++) {
			D[i] = 1;
		}
		int[] C = new int[101];
		C[0] = 1;
		C[1] = 1;
		for(int i=2;i<101;i++) {
			C[i] = C[i-2]+D[i];
		}
		int[] B = new int[101];
		for(int i=0;i<101;i++) {
			if(i < 5) {
				B[i] = C[i];
			}else {
				B[i] = B[i-5]+C[i];
			}
		}
		int[] A = new int[101];
		for(int i=0;i<101;i++) {
			if(i < 10) {
				A[i] = B[i];
			}else {
				A[i] = A[i-10]+B[i];
			}
		}
		System.out.println(A[100]);
		
		int[] change = {1,2,5,10};
		int[] result = new int[101];
		for(int i=0;i<101;i++) {
			result[i] = 1;
		}
		for(int i=1;i<4;i++) {
			for(int j=change[i];j<101;j++) {
				result[j] = result[j] + result[j-change[i]];
			}
		}
		System.out.println(result[100]);
		
	}

}
