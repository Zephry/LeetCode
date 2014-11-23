package Maximum_Depth_of_Binary_Tree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int maxDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        return findDepth(root, 0);
    }
    public int findDepth(TreeNode root, int lastDepth) {
    	if(root == null) {
    		return lastDepth;
    	}
    	if(root.left == null && root.right == null) {
    		return lastDepth+1;
    	}
    	int leftDepth = findDepth(root.left, lastDepth+1);
    	int rightDepth = findDepth(root.right, lastDepth+1);
    	if(leftDepth > rightDepth) {
    		return leftDepth;
    	}else {
    		return rightDepth;
    	}
    }

}
