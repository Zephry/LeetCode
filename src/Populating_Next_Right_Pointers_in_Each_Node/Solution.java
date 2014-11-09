package Populating_Next_Right_Pointers_in_Each_Node;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;
		connect(root);
	}
	public static void connect(TreeLinkNode root) {
				if(root == null) {
					return;
				}
				int thisLevelCount = 1;
				int nextLevelCount = 0;
				Queue<TreeLinkNode> nextNode = new LinkedList<TreeLinkNode>();
				nextNode.add(root);
				
				TreeLinkNode lastNode = null;
				while(!nextNode.isEmpty()) {
					TreeLinkNode currentNode = nextNode.poll();
					thisLevelCount--;
					currentNode.next = lastNode;
					lastNode = currentNode;
					if(currentNode.right != null) {
						nextLevelCount++;
						nextNode.add(currentNode.right);
					}
					if(currentNode.left != null) {
						nextLevelCount++;
						nextNode.add(currentNode.left);
					}
					
					if(thisLevelCount == 0) {
						thisLevelCount = nextLevelCount;
						nextLevelCount = 0;
						lastNode = null;
					}
					
				}
		
		
		
    }

}
