package Insertion_Sort_List;


public class Insertion_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(2);
		a.next = b;
		b.next = c;
		insertionSortList(null);
	}
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
        	return head;
        }
        ListNode current = null;
        ListNode sorted = null;
        sorted = new ListNode(head.val);
        
        while(head.next != null) {
        	head = head.next;
        	current = new ListNode(head.val);
        	
        	sorted = insertIntoList(sorted,current);
        }
        return sorted;
       	
        
    }
	public static ListNode insertIntoList(ListNode sorted, ListNode newnode) {
		ListNode last = null;
		ListNode current = null;
		current = sorted;
//		ListNode head = sorted;
		while(current != null) {
			if(newnode.val < current.val) {
				newnode.next = current;
				if(last == null) {
					return newnode;
				}else {
					last.next = newnode;
					return sorted;
				}
			} else {
				last = current;
				current = current.next;
			}
		}
		last.next = newnode;
		return sorted;
	}
		
}
