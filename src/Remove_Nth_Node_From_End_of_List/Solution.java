package Remove_Nth_Node_From_End_of_List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
        	return head;
        }
        if(n == 0) {
        	return head;
        }
        
        ListNode end = head;
        for(int i=0;i<n-1;i++) {
        	end = end.next;
        }
        ListNode fast = head;
        ListNode slow = null;
        
        while(end.next != null) {
        	end = end.next;
        	fast = fast.next;
        	if(slow == null) {
        		slow = head;
        	}else {
        		slow = slow.next;
        	}
        }
        if(slow == null) {
        	return fast.next;
        }
        slow.next = fast.next;
        return head;
    }

}
