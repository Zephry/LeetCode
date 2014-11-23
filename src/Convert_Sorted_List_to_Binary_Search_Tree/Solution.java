package Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(6);
		ListNode e = new ListNode(7);
		ListNode f = new ListNode(8);
		ListNode g = new ListNode(9);
		ListNode h = new ListNode(10);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		
		sortedListToBST(a);
	}
	
	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		TreeNode root = new TreeNode(head.val);
		if(head.next == null) {
			return root;
		}
		ListNode tmp = head;
		int len = 0;
		while(tmp != null) {
			len++;
			tmp = tmp.next;
		}
		TreeNode[] nodes = new TreeNode[len];
		for(int i=0;i<len;i++) {
			nodes[i] = new TreeNode(Integer.MIN_VALUE);
		}
		
		Queue<TreeNode> lastRow = new LinkedList<TreeNode>();
		Queue<TreeNode> nextRow = new LinkedList<TreeNode>();
		int curIndex = 0;
		lastRow.add(nodes[curIndex]);
		curIndex++;
		while(curIndex < len) {
			TreeNode curNode = lastRow.poll();
			curNode.left = nodes[curIndex];
			nextRow.add(curNode.left);
			curIndex++;
			if(curIndex == len) {
				break;
			}
			curNode.right = nodes[curIndex];
			nextRow.add(curNode.right);
			curIndex++;
			if(lastRow.isEmpty()) {
				lastRow = new LinkedList<TreeNode>(nextRow);
				nextRow = new LinkedList<TreeNode>();
			}
			
		}
		
		Stack<TreeNode> nextNode = new Stack<TreeNode>();
		
		nextNode.push(nodes[0]);
		while(!nextNode.empty()) {
			TreeNode currentNode = nextNode.pop();
			if(currentNode.right == null && currentNode.left == null) {
				currentNode.val = head.val;
				head = head.next;
				
			}else if(currentNode.left != null && currentNode.left.val == Integer.MIN_VALUE) {

				nextNode.push(currentNode);
				nextNode.push(currentNode.left);
			} else {
				currentNode.val = head.val;
				head = head.next;
				if(currentNode.right != null) {
					
					nextNode.push(currentNode.right);
				}
			}
			
		}
		
		return nodes[0];
		
    }
	
}
	
