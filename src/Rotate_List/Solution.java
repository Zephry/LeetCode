package Rotate_List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(4);
		a.next = b;
		rotateRight(a, 2);
	}
	
    public static ListNode rotateRight(ListNode head, int n) {
    	int len = 1;
    	if(head == null) {
    		return null;
    	}
    	ListNode cur = head;
    	while(cur.next != null) {
    		len++;
    		cur = cur.next;
    	}
    	n = n % len;
    	if(len == 1 || n == 0) {
    		return head;
    	}
    	
    	
    	ListNode last = cur;
    	cur = head;
    	ListNode slow = null;
    	for(int i=0;i<len-n;i++) {
    		slow = cur;
    		cur = cur.next;
    	}
    	
    	if(slow != null) {
    		slow.next = null;
    		last.next = head;
    	}
    	
    	return cur;
    	        
    }

}
