package Merge_k_Sorted_Lists;

import java.util.*;

import MaxHeap.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a3 = new ListNode(3);
		ListNode a5 = new ListNode(5);
		ListNode a7 = new ListNode(7);
		ListNode a9 = new ListNode(9);
		ListNode a11 = new ListNode(11);
		ListNode a13 = new ListNode(13);
		ListNode a15 = new ListNode(15);
		ListNode a17 = new ListNode(17);
		a1.next = a3;
		a3.next = a5;
		a5.next = a7;
		a7.next = a9;
		a9.next = a11;
		a11.next = a13;
		a13.next = a15;
		a15.next = a17;

		
		ListNode b1 = new ListNode(2);
		ListNode b3 = new ListNode(4);
		ListNode b5 = new ListNode(6);
		ListNode b7 = new ListNode(8);
		ListNode b9 = new ListNode(10);
		ListNode b11 = new ListNode(12);
		ListNode b13 = new ListNode(14);
		ListNode b15 = new ListNode(16);
		ListNode b17 = new ListNode(18);
		b1.next = b3;
		b3.next = b5;
		b5.next = b7;
		b7.next = b9;
		b9.next = b11;
		b11.next = b13;
		b13.next = b15;
		b15.next = b17;
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a1);
		lists.add(b1);
		
		mergeKLists(lists);
		
	}
	
    public static ListNode mergeKListsSlow(List<ListNode> lists) {
        int k = lists.size();
        if(k==0) {
        	return null;
        }
        int first = findMin(lists, k);
        if(first == -1) {
        	return null;
        }
        ListNode root = lists.get(first);
        ListNode tmp = root;
        lists.set(first, lists.get(first).next);
        int next = findMin(lists, k);
        while(next != -1) {
        	root.next = lists.get(next);
        	
        	lists.set(next, lists.get(next).next);
        	next = findMin(lists, k);
        	root = root.next;
        }

        return tmp;
        
        
    }
    
    public static int findMin(List<ListNode> lists, int k) {
    	int index = -1;
    	for(int i=0;i<k;i++) {
    		if(lists.get(i) != null) {
    			index = i;
    			break;
    		}
    	}
    	if(index == -1) {
    		return -1;
    	}
    	
    	ListNode min = lists.get(index);
        for(int i=0;i<k;i++) {
        	if(lists.get(i) != null && lists.get(i).val < min.val) {
        		min = lists.get(i);
        		index = i;
        	}
        }
        return index;
    }
    
    public static ListNode mergeKLists(List<ListNode> lists) {
    	int k = lists.size();
        if(k==0) {
        	return null;
        }
        int first = findMin(lists, k);
        if(first == -1) {
        	return null;
        }
        
        TreeNode root = buildHeap(lists, k);
        ListNode link = new ListNode(findMinFromHeap(root));
        ListNode tmp = link;
        int tmpMin = findMinFromHeap(root);
        while(tmpMin != Integer.MAX_VALUE) {
        	tmp.next = new ListNode(tmpMin);
        	tmp = tmp.next;
        }
        return link;
        
        
    }
    public static int findMinFromHeap(TreeNode root) {
    	int min = root.content.val;
    	if(root.content.next != null) {
    		root.content = root.content.next;
    	}else {
    		root.content.val = Integer.MAX_VALUE;
    	}
    	root = changeNode(root);
    	
    }
    public static TreeNode buildHeap(List<ListNode> lists, int k) {
    	Queue<TreeNode> nextNode = new LinkedList<TreeNode>();
		
		TreeNode root = new TreeNode(lists.get(0));
		nextNode.add(root);
		for(int i=1;i<k;i++) {
			TreeNode curNode = nextNode.peek();
			if(curNode.left == null) {
				TreeNode newNode = new TreeNode(lists.get(i));
				curNode.left = newNode;
				nextNode.add(newNode);
			}else {
				TreeNode newNode = new TreeNode(lists.get(i));
				curNode.right = newNode;
				nextNode.add(newNode);
				nextNode.remove();
			}
		}
		return root;
    }
    public static TreeNode changeNode(TreeNode root) {
    	int maxRight = Integer.MAX_VALUE;
		int maxLeft = Integer.MAX_VALUE;
		if(root.right != null) {
			maxRight = root.right.content.val;
		}
		if(root.left != null) {
			maxLeft = root.left.content.val;
		}
		if(root.content.val > maxLeft || root.content.val > maxRight) {
			if(maxLeft > maxRight) {
				int tmp = root.content.val;
				root.content.val = root.right.content.val;
				root.right.content.val = tmp;
				changeNode(root.right);
			}else {
				int tmp = root.content.val;
				root.content.val = root.left.content.val;
				root.left.content.val = tmp;
				changeNode(root.left);
			}
		}
		
		return root;
    }
    
};

class TreeNode {
	ListNode content;
	TreeNode left;
	TreeNode right;
	TreeNode(ListNode content) {
		this.content = content;
	}
};
