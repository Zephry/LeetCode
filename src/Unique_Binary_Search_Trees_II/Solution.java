package Unique_Binary_Search_Trees_II;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> generateTrees(int n) {
		
		if(n == 0) {
			List<TreeNode> tmp = new ArrayList<TreeNode>();
			tmp.add(null);
			return tmp;
		}
        return generateSubTree(1, n);
    }
	
	
	public List<TreeNode> generateSubTree(int start, int end) {
		if(start>end) {
			return null;
		}
		List<TreeNode> subTree = new ArrayList<TreeNode>();
		if(start == end) {
			TreeNode leaf = new TreeNode(start);
			
			subTree.add(leaf);
			
		} else {
			List<TreeNode> leftSubTree;
			List<TreeNode> rightSubTree;
			for(int i=start;i<=end;i++) {
				
				leftSubTree = generateSubTree(start, i-1);
				rightSubTree = generateSubTree(i+1, end);
				if(leftSubTree == null) {
					if(rightSubTree == null) {
						subTree.add(new TreeNode(i));
						
					}else {
						for(TreeNode subNode : rightSubTree) {
							TreeNode tmp = new TreeNode(i);
							tmp.right = subNode;
							subTree.add(tmp);
						}
						
						
					}
				}else {
					if(rightSubTree == null) {
						for(TreeNode subNode : leftSubTree) {
							TreeNode tmp = new TreeNode(i);
							tmp.left = subNode;
							subTree.add(tmp);
						}
					}else {
						for(TreeNode subLeftNode : leftSubTree) {
							for(TreeNode subRightNode : rightSubTree) {
								TreeNode tmp = new TreeNode(i);
								tmp.left = subLeftNode;
								tmp.right = subRightNode;
								subTree.add(tmp);
							}
						}
					}
				}
				
			}
			
			
		}
		
		return subTree;
		
	}
}
