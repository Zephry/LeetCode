package Balanced_Binary_Tree;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBalanced(TreeNode root) {
//		int shallow = 50000;
//		int deep = 0;
//		
//		if(root == null) {
//			return true;
//		}
//		
//		Stack<TreeNode> nextNode = new Stack<TreeNode>();
//        Stack<Integer> nextDepth = new Stack<Integer>();
//        
//        nextNode.push(root);
//        nextDepth.add(0);
//        
//        while(!nextNode.empty()) {
//        	TreeNode currentNode = nextNode.pop();
//        	int currentDepth = nextDepth.pop();
//        	
//        	currentDepth++;
//        	
//        	if(currentNode.right != null) {
//        		nextNode.push(currentNode.right);
//        		nextDepth.push(currentDepth);
//        	}
//        	
//        	if(currentNode.left != null) {
//        		nextNode.push(currentNode.left);
//        		nextDepth.push(currentDepth);
//        	}
//        	
//        	
//        	if(currentNode.left == null && currentNode.right == null) {
//        		if(currentDepth > deep) {
//        			deep = currentDepth;
//        		}
//        		if(currentDepth < shallow) {
//        			shallow = currentDepth;
//        		}
//        	}
//
//        }
//        
//        if((deep - shallow) < 2 ) {
//        	return true;
//        } else {
//        	return false;
//        }
        
        
		
		
		
		if(root == null) {
			return true;
		}
		
		int leftHeigh = TreeHeigh(root.left);
		int rightHeigh = TreeHeigh(root.right);
		if(leftHeigh == -1 || rightHeigh == -1) {
			return false;
		}
		if(Math.abs(leftHeigh-rightHeigh) > 1) {
			return false;
		} else {
			return true;
		}
		
		
		
		
		
    }
	
	public int TreeHeigh(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int leftHeigh = TreeHeigh(root.left);
		int rightHeigh = TreeHeigh(root.right);
		if(leftHeigh == -1 || rightHeigh == -1) {
			return -1;
		}
		if(Math.abs(leftHeigh-rightHeigh) > 1) {
			return -1;
		} else {
			if(leftHeigh > rightHeigh) {
				return (leftHeigh+1);
			}else {
				return (rightHeigh+1);
			}
		}
		
		
	}
	

}
