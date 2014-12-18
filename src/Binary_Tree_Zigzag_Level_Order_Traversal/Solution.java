package Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
        	return result;
        }
        
        Stack<TreeNode> first = new Stack<TreeNode>();
        Stack<TreeNode> second = new Stack<TreeNode>();
        
        
        
        first.add(root);
//        int nextNodeCount = 1;
        while(!first.isEmpty() || !second.isEmpty()) {
        	TreeNode currentNode;
        	while(!first.isEmpty()) {
        		currentNode = first.pop();
        		tmp.add(currentNode.val);
        		if(currentNode.left!=null) {
        			second.push(currentNode.left);
        			
        		}
        		if(currentNode.right!=null) {
        			second.push(currentNode.right);
        		}
        	}
        	if(!tmp.isEmpty()) {
        		result.add(new ArrayList<Integer>(tmp));
        	}
        	tmp = new ArrayList<Integer>();
        	while(!second.isEmpty()) {
        		currentNode = second.pop();
        		tmp.add(currentNode.val);
        		if(currentNode.left!=null) {
        			first.push(currentNode.left);
        		}
        		if(currentNode.right!=null) {
        			first.push(currentNode.right);
        		}
        	}
        	if(!tmp.isEmpty()) {
        		result.add(new ArrayList<Integer>(tmp));
        	}
        	tmp = new ArrayList<Integer>();

        }
        return result;
        
        
		
    }

}
