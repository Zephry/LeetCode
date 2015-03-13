package Intersection_of_Two_Linked_Lists;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode A = headA;
    	ListNode B = headB;
    	
    	int lenA = 0;
    	int lenB = 0;
    	
    	while(A!=null) {
    		lenA++;
    		A = A.next;
    	}
    	while(B!=null) {
    		lenB++;
    		B = B.next;
    	}
    	A = headA;
    	B = headB;
    	
    	if(lenA>lenB) {
    		for(int i=0;i<(lenA-lenB);i++) {
    			A = A.next;
    		}
    	}else {
    		for(int i=0;i<(lenB-lenA);i++) {
    			B = B.next;
    		}
    	}
    	
    	while(A!=null) {
    		if(A.equals(B)) {
    			return B;
    		}else {
    			A = A.next;
    			B = B.next;
    		}
    	}
    	return null;
    	
    }
	
	

}
