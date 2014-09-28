package Swap_Nodes_in_Pairs;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public ListNode swapPairs(ListNode head) {
		if(head == null) {
			return null;
		}
        if(head.next == null) {
        	return head;
        }
        ListNode root = new ListNode(-1);
        ListNode last = root;
        ListNode current1 = head;
        ListNode current2 = head.next;
        ListNode next = head.next;
        
        while(current2 != null) {
        	next = current2.next;
        	last.next = current2;
        	current2.next = current1;
        	current1.next = next;
        	
        	last = current1;
        	current1 = next;
        	if(next == null) {
        		break;
        	}
        	current2 = next.next;
        	
        }
        
        return root.next;
        
    }

}
