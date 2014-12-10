package Remove_Duplicates_from_Sorted_List_II;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode firstHead = new ListNode(Integer.MIN_VALUE);
		
		ListNode lastDistinct = firstHead;
		ListNode slow = head;
		ListNode fast = head.next;
		
		boolean inDuplicated = false;
		
		while(fast != null) { 
			if(slow.val == fast.val) {
				inDuplicated = true;
				slow = slow.next;
				fast = fast.next;
				
			}else {
				if(inDuplicated) {
					inDuplicated =false;
				}else {
					lastDistinct.next = slow;
					lastDistinct = slow;
					
				}
				slow = slow.next;
				fast = fast.next;
			}
			lastDistinct.next = null;
			
			
		}
		
		if(!inDuplicated) {
			lastDistinct.next = slow;
		}
		return firstHead.next;
		
    }
	

}
