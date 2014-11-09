package Minimum_Depth_of_Binary_Tree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDepth(TreeNode root) {
        Stack<TreeNode> nextNode = new Stack<TreeNode>();
        Stack<Integer> nextNodeDepth = new Stack<Integer>();
        int depth = 0;
        int min = Integer.MAX_VALUE;
        if(root == null) {
        	return 0;
        }
        nextNode.push(root);
        nextNodeDepth.push(0);
        
        while(!nextNode.empty()) {
        	TreeNode currentNode = nextNode.pop();
        	int currentNodeDepth = nextNodeDepth.pop();
        	currentNodeDepth++;
        	if(currentNode.right != null) {
        		nextNode.push(currentNode.right);
        		nextNodeDepth.push(currentNodeDepth);
        	}
        	if(currentNode.left != null) {
        		nextNode.push(currentNode.left);
        		nextNodeDepth.push(currentNodeDepth);
        	}
        	if(currentNode.right == null && currentNode.left == null) {
        		if(currentNodeDepth<min) 
        		{
        			min = currentNodeDepth;
        		}
        		
        	}
        	
        }
        return min;
    }

}
