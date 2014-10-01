package Path_Sum;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode body1 = new TreeNode(-2);
		TreeNode body2 = new TreeNode(-3);
		TreeNode body3 = new TreeNode(1);
		TreeNode body4 = new TreeNode(3);
		TreeNode body5 = new TreeNode(-2);
		TreeNode body6 = new TreeNode(-1);
		root.left = body1;
		root.right = body2;
		body1.left = body3;
		body1.right = body4;
		body2.left = body5;
		body3.left = body6;
		hasPathSum(root, -1);

	}
	
    public static boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) {
    		return false;
    	}
    	
    	Stack<TreeNode> nextNode = new Stack<TreeNode>();
    	Stack<Integer> nextSum = new Stack<Integer>();
    	
    	nextNode.add(root);
    	nextSum.add(Integer.valueOf(0));
    	while(!nextNode.empty()) {
    		TreeNode currentNode = nextNode.pop();
    		int lastSum = nextSum.pop();
    		int currentSum = lastSum + currentNode.val;
    		
    		if(currentSum != sum) {
    			if(currentNode.right != null) {
    				nextNode.add(currentNode.right);
    				nextSum.add(Integer.valueOf(currentSum));
    			}
    			if(currentNode.left != null) {
    				nextNode.add(currentNode.left);
    				nextSum.add(Integer.valueOf(currentSum));
    			}
    		} else if(currentSum == sum) {
    			if(currentNode.left == null && currentNode.right == null) {
    				return true;
    			} else {
    				if(currentNode.right != null) {
        				nextNode.add(currentNode.right);
        				nextSum.add(Integer.valueOf(currentSum));
        			}
        			if(currentNode.left != null) {
        				nextNode.add(currentNode.left);
        				nextSum.add(Integer.valueOf(currentSum));
        			}
    			}
    		}
    		
    		
    		
    	}
    	return false;
    	
        
    }

}
