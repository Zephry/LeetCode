package Binary_Tree_Postorder_Traversal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode other = new TreeNode(2);
		TreeNode Other = new TreeNode(3);
		root.left = other;
		other.left = Other;
		System.out.print(postorderTraversal(root));

	}
    public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> path = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
        	return path;
        }
        TreeNode nextNode = root;
        stack.add(root);
        while(!stack.empty()) {
        	nextNode = stack.lastElement();
        	if(nextNode.left != null) {
        		stack.add(nextNode.left);
        		nextNode.left = null;
        	} else if(nextNode.right != null) {
        		stack.add(nextNode.right);
        		nextNode.right = null;
        	} else {
        		path.add(nextNode.val);
        		stack.pop();
        	}
        }
        
        return path;
    }

}
