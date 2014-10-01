package Reverse_Linked_List2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode body1 = new ListNode(2);
		ListNode body2 = new ListNode(3);
		head.next = body1;
		body1.next = body2;
		reverseBetween(head, 2,3);
	}
	
	
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode newHead = new ListNode(0);
        if(head == null) {
        	return head;
        }
        if(head.next == null) {
        	return head;
        }
        if(m==n) {
        	return head;
        }
        ListNode currentNode = head;
        ListNode start = null;
        ListNode last = null;
        ListNode lasthead = newHead;
        int count = 1;
        while(currentNode != null) {
        	ListNode tmp = currentNode.next;
        	if(count == m) {
        		last = currentNode;
        		start = currentNode;
        	} else if(start != null && count != n) {
        		currentNode.next = last;
        		last = currentNode;
        	} else if(count == n){
        		lasthead.next = currentNode;
        		start.next = currentNode.next;
        		currentNode.next = last;
        		if(m == 1) {
        			return newHead.next;
        		}else {
        			return head;
        		}
        	} else {
        		lasthead = currentNode;
        	}
        	count++;
        	currentNode = tmp;
        }
        return head;
    }
    
    
    
    
    
}
