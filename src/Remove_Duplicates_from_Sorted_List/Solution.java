package Remove_Duplicates_from_Sorted_List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null) {
    		return head;
    	}
    	if(head.next == null) {
    		return head;
    	}
    	
    	ListNode lastNode = head;
    	ListNode currentNode = head.next;
        
    	while(currentNode != null) {
    		ListNode nextNode = currentNode.next;
    		if(currentNode.val == lastNode.val) {
    			lastNode.next = nextNode;
    		} else {
    			lastNode = currentNode;
    		}
    		
    		currentNode = nextNode;
    	}
    	
    	return head;
    	
    	
    	
    	
    	
    }

}
