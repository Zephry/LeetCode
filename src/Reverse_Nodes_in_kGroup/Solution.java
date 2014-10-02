package Reverse_Nodes_in_kGroup;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		
		reverseKGroup(a, 2);
	}
		
    public static ListNode reverseKGroup(ListNode head, int k) {
    	ListNode H = new ListNode(-1);
    	H.next = head;
    	if(head == null) {
    		return head;
    	}
    	if(head.next == null) {
    		return head;
    	}
    	if(k < 2) {
    		return head;
    	}
    	int count = 0;
    	ListNode startNode = H;
    	ListNode fastNode = head;
    	ListNode slowNode = head;
    	ListNode currentNode = head;
    	
    	while(currentNode != null) {
    		count++;
    		if(count == k) {
    			startNode.next = currentNode;
    			startNode = slowNode;
    			fastNode = fastNode.next;
    			slowNode.next = currentNode.next;
    			while(fastNode != currentNode) {
    				ListNode tmp = fastNode.next;
    				fastNode.next = slowNode;
    				slowNode = fastNode;
    				fastNode = tmp;
    			}
    			fastNode = currentNode.next;
    			currentNode.next = slowNode;
    			
    			
    			
    			
    			slowNode = fastNode;
    			currentNode = fastNode;
    			count = 0;
    		}else {
    			currentNode = currentNode.next;
    		}
    	}
    	
    	return H.next;
        
    }

}
