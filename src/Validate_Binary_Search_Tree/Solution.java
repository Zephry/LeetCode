package Validate_Binary_Search_Tree;

public class Solution {
	public static void main() {
		
	}
	
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		boolean left = true;
		boolean right = true;
		if(root.left != null) {
			left = checkBST(root.left, Integer.MIN_VALUE, root.val);
		}
		if(root.right != null) {
			right = checkBST(root.right, root.val, Integer.MAX_VALUE);
		}
		return (left && right);
    }
	
	public boolean checkBST(TreeNode root, int min, int max) {
		
			if(root.val < max && root.val > min) {
				boolean leftResult = true;
				boolean rightResult = true;
				if(root.left != null) {
					
					leftResult = checkBST(root.left, min, root.val);
					
				}
				if(root.right != null) {
					
					rightResult = checkBST(root.right, root.val, max);
					
				}
				return (leftResult && rightResult);
			}else {
				return false;
			}
		

		
	}

}
