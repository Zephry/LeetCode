package Merge_k_Sorted_Lists;

import java.util.*;




public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1 = {-10,-9,-9,-3,-1,-1,0};
		int[] array2 = {-5};
		int[] array3 = {4};
		int[] array4 = {-8};
		int[] array5 = {};
		int[] array6 = {-9,-6,-5,-4,-2,2,3};
		int[] array7 = {-3,-3,-2,-1,0};
		ListNode a1 = buildList(array1);
		ListNode b1 = buildList(array2);
		ListNode c1 = buildList(array3);
		ListNode a4 = buildList(array4);
		ListNode a5 = buildList(array5);
		ListNode a6 = buildList(array6);
		ListNode a7 = buildList(array7);
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a1);
		lists.add(b1);
		lists.add(c1);
		lists.add(a4);
		lists.add(a5);
		lists.add(a6);
		lists.add(a7);
		mergeKLists(lists);
		
	}
	
//    public static ListNode mergeKListsSlow(List<ListNode> lists) {
//        int k = lists.size();
//        if(k==0) {
//        	return null;
//        }
//        int first = findMin(lists, k);
//        if(first == -1) {
//        	return null;
//        }
//        ListNode root = lists.get(first);
//        ListNode tmp = root;
//        lists.set(first, lists.get(first).next);
//        int next = findMin(lists, k);
//        while(next != -1) {
//        	root.next = lists.get(next);
//        	
//        	lists.set(next, lists.get(next).next);
//        	next = findMin(lists, k);
//        	root = root.next;
//        }
//
//        return tmp;
//        
//        
//    }
    
    public static int findMin(List<ListNode> lists, int k) {
    	int index = -1;
    	for(int i=0;i<k;i++) {
    		if(lists.get(i) != null) {
    			index = i;
    			break;
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
        int count = 0;
        for(int i=0;i<k;i++) {
        	if(lists.get(i) != null) {
        		count = i;
        		break;
        	}
        }
        TreeNode root = buildHeap(lists, k, count);
        root = FirstchangeNode(root);
        ListNode link = new ListNode(root.content.val);
        root = findMinFromHeap(root);
        ListNode tmp = link;
        
        int tmpMin = root.content.val;
        root = findMinFromHeap(root);
        while(tmpMin != Integer.MAX_VALUE) {
        	tmp.next = new ListNode(tmpMin);
        	tmp = tmp.next;
        	tmpMin = root.content.val;
        	root = findMinFromHeap(root);
        }
        return link;
        
        
    }
    public static TreeNode findMinFromHeap(TreeNode root) {
    	if(root.content.next != null) {
    		root.content = root.content.next;
    	}else {
    		root.content.val = Integer.MAX_VALUE;
    	}
    	root = changeNode(root);
    	return root;
    }
    public static TreeNode buildHeap(List<ListNode> lists, int k, int first) {
    	Queue<TreeNode> nextNode = new LinkedList<TreeNode>();
		
		TreeNode root = new TreeNode(lists.get(first));
		nextNode.add(root);
		for(int i=first+1;i<k;i++) {
			if(lists.get(i) != null) {
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
		}
		return root;
    }
    public static TreeNode FirstchangeNode(TreeNode root) {
    	Stack<TreeNode> noLeafNode = new Stack<TreeNode>();
		Stack<TreeNode> nextNode = new Stack<TreeNode>();
		nextNode.push(root);
		
		while(!nextNode.empty()) {
			TreeNode curNode = nextNode.pop();
			if(curNode.left != null) {
				noLeafNode.push(curNode);
				nextNode.push(curNode.left);
				if(curNode.right != null) {
					nextNode.push(curNode.right);
				}
			}
		}
		
		while(!noLeafNode.empty()) {
			TreeNode curNode = noLeafNode.pop();
			curNode = changeNode(curNode);
		}
		
		return root;
//    	root = changeNode(root);
//    	
//		if(root.right != null) {
//			changeNode(root.right);
//		}
//		if(root.left != null) {
//			changeNode(root.left);
//		}
//		return root;
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
				
				ListNode tmpNode = root.content;
				root.content = root.right.content;
				
				root.right.content = tmpNode;
				changeNode(root.right);
				
			}else {
				
				ListNode tmpNode = root.content;
				root.content = root.left.content;
				
				root.left.content = tmpNode;
				changeNode(root.left);
				
			}
		}
		
		return root;
    }
    
    public static ListNode buildList(int[] array) {
    	if(array.length == 0) {
    		return null;
    	}
    	ListNode head = new ListNode(array[0]);
    	ListNode tmp = head;
    	for(int i=1;i<array.length;i++) {
    		tmp.next = new ListNode(array[i]);
    		tmp = tmp.next;
    	}
    	return head;
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
