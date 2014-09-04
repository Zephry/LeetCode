package Sort_List;

public class Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(2);
		a.next = b;
		b.next = c;
		sortList(a);
	}
	
	public static ListNode sortList(ListNode head) {
        int count = 0;
        ListNode mid = null;
        ListNode last = null;
        if(head == null) {
        	return head;
        }
        if(head.next == null) {
        	return head;
        } else {
        	mid = head;
        	while(mid != null) {
        		count++;
        		mid = mid.next;
        	}
        	mid = head;
        	for(int i = 0; i < (count/2); i++) {
        		last = mid;
        		mid = mid.next;
        	}
        	last.next = null;
        	return MergeTwoList(sortList(head), sortList(mid));
        }
        
    }
	
	public static ListNode MergeTwoList(ListNode head1, ListNode head2) {
		ListNode head = null;
		ListNode current = null;
		ListNode last = null;
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val) {
				if(head == null) {
					head = head1;
					current = head;
					last = head;
				} else {
					current = head1;
					last.next = current;
					last = current;
				}
				head1 = head1.next;
				
			} else {
				if(head == null) {
					head = head2;
					current = head;
					last = head;
				} else {
					current = head2;
					last.next = current;
					last = current;
				}
				head2 = head2.next;
			}
			
			
			
		}
		if(head1 != null) {
			last.next = head1;
		}
		if(head2 != null) {
			last.next = head2;
		}
		return head;
	}
	
	

}
