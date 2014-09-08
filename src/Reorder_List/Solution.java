package Reorder_List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4);
		four.next = five;
		ListNode three = new ListNode(3);
		three.next = four;
		ListNode two = new ListNode(2);
		two.next = three;
		ListNode one = new ListNode(1);
		one.next = two;
//		ReverseList(one);
//		reorderListNotGood(one);
		reorderList(one);
		
	}
	public static void reorderListNotGood(ListNode head) {
		//index start from 0
		if(head == null) {
			return;
		}
        int count = 1;
        ListNode countNode = head;
        while(countNode.next != null) {
        	count++;
        	countNode = countNode.next;
        }
        if(count < 3) {
        	return;
        }
        int times = (count - 1) / 2;
        ListNode left = head;
        ListNode right = head.next;
        for(int i = 0;i < times;i++) {
        	ListNode InsertNode = FindElementAtIndex(count - 1, head);
        	left.next = InsertNode;
        	InsertNode.next = right;
        	left = right;
        	right = right.next;
        }
    }
	
	public static ListNode FindElementAtIndex(int index, ListNode head) {
		//index start from 0
		index--;
		while(index > 0) {
			head = head.next;
			index--;
		}
		ListNode Node = head.next;
		head.next = null;
		return Node;
		
	}
	
	
	public static ListNode ReverseList(ListNode head) {
		ListNode lastNode = head;
		if(head.next == null) {
		    return head;
		}
		ListNode currentNode = head.next;
		head.next = null;
		
		while(currentNode.next != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = lastNode;
			lastNode = currentNode;
			currentNode = nextNode;
		}
		currentNode.next = lastNode;
		return currentNode;
	}
	
	public static ListNode Merge(ListNode head1, ListNode head2) {
		ListNode head = head1;
		while(head2.next != null) {
			ListNode nexthead1Node = head1.next;
			ListNode nexthead2Node = head2.next;
			head1.next = head2;
			head2.next = nexthead1Node;
			head1 = nexthead1Node;
			head2 = nexthead2Node;
		}
		ListNode nextNode = head1.next;
		head1.next = head2;
		head2.next = nextNode;
		
		return head;
	}
	public static void reorderList(ListNode head) {
		if(head == null) {
			return;
		}
        int count = 1;
        ListNode countNode = head;
        while(countNode.next != null) {
        	count++;
        	countNode = countNode.next;
        }
        if(count < 3) {
        	return;
        }
        int mid = (count+1) /2 ;
        ListNode head2 = FindElementAtIndex(mid, head);
        head2 = ReverseList(head2);
        head = Merge(head, head2);
	}
}
