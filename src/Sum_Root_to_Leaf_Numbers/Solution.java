package Sum_Root_to_Leaf_Numbers;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int sumNumbers(TreeNode root) {
    	int sum = 0;
    	
    	if(root == null){
    		return 0;
    	}
    	
    	
        Stack<TreeNode> nextNode = new Stack<TreeNode>();
        Stack<String> nextPath = new Stack<String>();
        
        
        nextNode.push(root);
        nextPath.push("");
        while(!nextNode.empty()) {
        	TreeNode currentNode = nextNode.pop();
        	String currentPath = nextPath.pop();
        	
        	currentPath = currentPath + String.valueOf(currentNode.val);
        	
        	if(currentNode.right != null) {
        		nextNode.add(currentNode.right);
        		nextPath.add(currentPath);
        	}
        	if(currentNode.left != null) {
        		nextNode.add(currentNode.left);
        		nextPath.add(currentPath);
        	}
        	if(currentNode.right == null && currentNode.left == null) {
        		int currentSum = Integer.valueOf(currentPath);
        		sum = sum + currentSum;
        	}
        	
        }
        
        return sum;
        
    }

}
