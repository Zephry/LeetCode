package Merge_Two_Sorted_Lists;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1c = l1;
        ListNode l2c = l2;

        ListNode head = new ListNode(-100);
        ListNode r = head;
        while(l1c != null && l2c != null) {
        	if(l1c.val > l2c.val) {
        		head.next = l2c;
        		l2c = l2c.next;
        		head = head.next;
        	} else {
        		head.next = l1c;
        		l1c = l1c.next;
        		head = head.next;
        	}
        	
        }
        
        if(l1c == null) {
        	head.next = l2c;
        }
        
        if(l2c == null) {
        	head.next = l1c;
        }
        
        return r.next;
    }
    
}
