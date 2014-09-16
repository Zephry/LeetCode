package Linked_List_Cycle;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {
    	if(head == null) {
    		return false;
    	}
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast.next != null) {
    		fast = fast.next;
    		if(fast.next == null) {
    			return false;
    		}
    		fast = fast.next;
    		slow = slow.next;
    		if(slow.equals(fast)) {
    			return true;
    		}
    	}
    	return false;
        
    }
}
