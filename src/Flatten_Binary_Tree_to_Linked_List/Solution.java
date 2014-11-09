package Flatten_Binary_Tree_to_Linked_List;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		root.left = b;
		root.right = e;
		b.left = c;
		b.right = d;
		e.right = f;
		flatten(root);
	}
	
	public static void flatten(TreeNode root) {
        if(root == null) {
        	return;
        }
        
        Stack<TreeNode> nextNode = new Stack<TreeNode>();
        
        nextNode.push(root);
        TreeNode lastNode = null;
        while(!nextNode.empty()) {
        	TreeNode currentNode = nextNode.pop();
        	if(currentNode.right != null) {
        		nextNode.push(currentNode.right);
        	}
        	if(currentNode.left != null) {
        		nextNode.push(currentNode.left);
        	}
        	if(lastNode != null) {
        		lastNode.right = currentNode;
        	}
        	currentNode.left = null;
        	currentNode.right = null;
        	lastNode = currentNode;
        }
    }
}
