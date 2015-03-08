package Binary_Search_Tree_Iterator;

import java.util.*;

public class BSTIterator {
	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		if(root == null) {
			return;
		}
		pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode curNode = stack.pop();
    	int val = curNode.val;
    	
    	if(curNode.right != null) {
    		pushAllLeft(curNode.right);
    	}
    	return val;
    }
    
    public void pushAllLeft(TreeNode node) {
    	stack.push(node);
    	while(node.left != null) {
    		stack.push(node.left);
    		node = node.left;
    	}
    }

}
