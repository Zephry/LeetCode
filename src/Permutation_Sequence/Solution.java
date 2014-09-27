package Permutation_Sequence;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print(getPermutation(2,2));
		System.out.print(getPermutation(3,2));
		System.out.print(getPermutation(9,273815));
	}

//	public static String getPermutation(int n, int k) {
//		if(n == 0) {
//			return "";
//		}
//		
//        int[] array = new int[n];
//        int count = 1;
//        for(int i = 0; i < n; i++) {
//        	array[i] = i + 1;
//        	count = count * (i + 1);
//        }
//        
//        List<String> permut = new ArrayList<String>();
//        String start = "";
//        if(n > 7){
//	        int tmp = calculate(n-1);
//			if(tmp < k) {
//				int current = (k/tmp);
//				array[current] = 0;
//				k = k - (current * tmp);
//				start = start + String.valueOf(current+1);
//			}
//        }
//		
//		
//        if(k > (count/2)) {
//        	permut = Verpermutation(array, permut, start, (count-k+1));
//        	return permut.get(count-k);
//        }else {
//        	permut = permutation(array, permut, start, k);
//        	return permut.get(k-1);
//        }
//        
//        
//    }
//    
//    public static List<String> permutation(int[] array, List<String> permut, String notFinish, int k) {
//    	int count = 0;
//    	String lastChar = "";
//    	for(int i = 0; i < array.length; i++) {
//    		if(array[i] != 0) {
//    			count++;
//    			lastChar = String.valueOf(array[i]);
//    		}
//    	}
//    	if(count == 1) {
//    		notFinish = notFinish + lastChar;
//    		permut.add(notFinish);
//    		return permut;
//    	}
//    	
//    	
//    	for(int i = 0; i < array.length; i++) {
//    		if(array[i] != 0) {
//
//    			int tmp = array[i];
//    			
//    			array[i] = 0;
//    			permut = permutation(array, permut, notFinish + String.valueOf(tmp), k);
//    			if(permut.size() == k) {
//    				return permut;
//    			}
//    			array[i] = tmp;
//
//    		}
//    	}
//		return permut;
//
//    }
//    
//    public static List<String> Verpermutation(int[] array, List<String> permut, String notFinish, int k) {
//    	int count = 0;
//    	String lastChar = "";
//    	for(int i = 0; i < array.length; i++) {
//    		if(array[i] != 0) {
//    			count++;
//    			lastChar = String.valueOf(array[i]);
//    		}
//    	}
//    	if(count == 1) {
//    		notFinish = notFinish + lastChar;
//    		permut.add(notFinish);
//    		return permut;
//    	}
//    	
//    	
//    	for(int i = array.length - 1; i > -1; i--) {
//    		if(array[i] != 0) {
//
//    			int tmp = array[i];
//    			
//    			array[i] = 0;
//    			permut = Verpermutation(array, permut, notFinish + String.valueOf(tmp), k);
//    			if(permut.size() == k) {
//    				return permut;
//    			}
//    			array[i] = tmp;
//
//    		}
//    	}
//		return permut;
//
//    }
//    
//    public static String getPermutation1(int n, int k, String result) {
//    	
//    		int tmp = calculate(n);
//    		if(tmp < k) {
//    			int current = (k/tmp);
//    			k = k - (current * tmp);
//    			result = result + String.valueOf(current);
//    			getPermutation1(n, k, result);
//    		} else {
//    			
//    		}
//    	return "";
//    }
	public static String getPermutation(int n, int k) {

		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
        	array[i] = i + 1;
        }
		return Permutation(n,k-1,array);
	}
	
    public static int calculate(int n) {
    	int result = 1;
    	for(int i = 0;i<n;i++) {
    		result = result * (i + 1);
    	}
    	return result;
    }
    public static int getElementByIndex(int[] array, int index) {
    	int count = 0;
    	for(int i = 0; i < array.length; i++) {
    		if(array[i] != 0) {
    			count ++;
    			if(count == index) {
    				return array[i];
    			}
    		}
    	}
    	return -1;
    }
    
    public static String Permutation(int n, int k, int[] array) {
    	String result = "";
    	while(k != 0) {
			for(int i = n-1; i > 0; i--) {
				int current = calculate(i);
				
				if(current <= k) {
					int times = k/current;
					k = k - (times*current);
					int element = getElementByIndex(array,times+1);
					
					result = result + String.valueOf(element);
					array[element-1] = 0;
				} else {
					int element = getElementByIndex(array,1);
					result = result + String.valueOf(element);
					array[element-1] = 0;
				}
				
				
			}
		}
    	for(int i = 0; i < array.length; i++) {
    		if(array[i] != 0) {
    			result = result + String.valueOf(array[i]);
    		}
    	}
    	return result;
    	
    	
    }
    
    
    
}
