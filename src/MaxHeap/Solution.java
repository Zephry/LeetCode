package MaxHeap;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,5,7,1,2,8,9,6};
		sort(array);
	}
	
	public static TreeNode buildHeap(int[] array) {
		Queue<TreeNode> nextNode = new LinkedList<TreeNode>();
		int len = array.length;
		TreeNode root = new TreeNode(array[0]);
		nextNode.add(root);
		for(int i=1;i<len;i++) {
			TreeNode curNode = nextNode.peek();
			if(curNode.left == null) {
				TreeNode newNode = new TreeNode(array[i]);
				curNode.left = newNode;
				nextNode.add(newNode);
			}else {
				TreeNode newNode = new TreeNode(array[i]);
				curNode.right = newNode;
				nextNode.add(newNode);
				nextNode.remove();
			}
		}
		return root;
				
	}
	
	public static TreeNode changeHeap(TreeNode root) {
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
		
	}
	
	public static TreeNode changeNode(TreeNode root) {
		int minRight = Integer.MIN_VALUE;
		int minLeft = Integer.MIN_VALUE;
		if(root.right != null) {
			minRight = root.right.val;
		}
		if(root.left != null) {
			minLeft = root.left.val;
		}
		if(root.val < minLeft || root.val < minRight) {
			if(minLeft > minRight) {
				int tmp = root.val;
				root.val = root.left.val;
				root.left.val = tmp;
				changeNode(root.left);
			}else {
				int tmp = root.val;
				root.val = root.right.val;
				root.right.val = tmp;
				changeNode(root.right);
			}
		}
		
		return root;
		
	}
	
//	public int[] getSortedArray(TreeNode root) {
//		
//	}
	public static void sort(int[] array) {
		TreeNode root = buildHeap(array);
		root = 	changeHeap(root);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
