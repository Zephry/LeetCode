package Convert_Sorted_Array_to_Binary_Search_Tree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
    	int len = num.length;
    	if(len < 1) {
    		return null;
    	}
    	
    	TreeNode root = buildTree(num, 0, num.length-1);
    	
    	return root;
    	
    	
    	
    	
    }
    
    
    public TreeNode buildTree(int[] num, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	int m = (start+end)/2;
    	
    	
    	TreeNode root = new TreeNode(num[m]);
    	root.left = buildTree(num, start, m-1);
    	root.right = buildTree(num, m+1, end);
    	return root;
    }

}
