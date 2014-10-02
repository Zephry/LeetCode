package Binary_Tree_Inorder_Traversal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode c = new TreeNode(3);
//		Stack<TreeNode> nextNode = new Stack<TreeNode>();
//		nextNode.push(c);
//		c.val = 7;
		
		
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> nextNode = new Stack<TreeNode>();
    	
    	if(root == null) {
    		return result;
    	}
    	
    	nextNode.push(root);
    	
    	while(!nextNode.empty()) {
    		TreeNode currentNode = nextNode.pop();
    		
    		if(currentNode.right != null) {
    			nextNode.push(currentNode.right);
    			currentNode.right = null;
    		}
    		if(currentNode.left != null) {
    			nextNode.push(currentNode);
    			nextNode.push(currentNode.left);
    			currentNode.left = null;
    		} else {
    			result.add(currentNode.val);
    		}
    		
    	}
    	
    	
    	return result;
    	
    	
        
    }

}
