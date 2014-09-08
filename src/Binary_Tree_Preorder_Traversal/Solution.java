package Binary_Tree_Preorder_Traversal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode other = new TreeNode(2);
		TreeNode Other = new TreeNode(3);
		root.left = other;
		root.right = Other;
		System.out.print(preorderTraversal(root));

	}
    public static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> path = new ArrayList<Integer>();
        List<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
        	return path;
        }
        TreeNode nextNode = root;
        stack.add(root);
        while(!stack.isEmpty()) {
        	nextNode = stack.get(stack.size() - 1);
        	path.add(nextNode.val);
        	stack.remove(stack.size() - 1);
        	if(nextNode.right != null) {
        		stack.add(nextNode.right);
        		nextNode.right = null;
        	} 
        	if(nextNode.left != null) {
        		stack.add(nextNode.left);
        		nextNode.left = null;
        	}
        	
        	
        }
        
        return path;
    }

}
