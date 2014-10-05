package Linked_List_Cycle2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return null;
		}
		if(head.next.equals(head)) {
			return head;
		}
		int fastSpeed = 2;
		boolean firstMeet = true;
		while(fast.next != null) {
			for(int i=0;i<fastSpeed;i++) {
				fast = fast.next;
			}
			slow = slow.next;
			
			if(fast.equals(slow)) {
				if(firstMeet) {
					firstMeet = false;
					fastSpeed = 1;
					fast = head;
					if(fast.equals(slow)) {
						return slow;
					}
				} else {
					return slow;
				}
			}
			
		}

		return null;
    }
}
