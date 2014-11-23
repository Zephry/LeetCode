package Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0 || postorder.length == 0) {
			return null;
		}
//		int mid = findInArray(inorder, postorder[postorder.length-1], 0, postorder.length);
        return buildSubTree(inorder, postorder, postorder.length-1, 0, postorder.length, new TreeNode(postorder[postorder.length-1]));
    }
	
	public TreeNode buildSubTree(int[] inorder, int[] postorder, int cur, int start, int end, TreeNode currentNode) {
		int mid = findInArray(inorder, postorder[cur], start, end);
		for(int i=cur-1;i>=0;i--) {
			if(findInArray(inorder, postorder[i], mid+1, end) != -1) {
				currentNode.right = new TreeNode(postorder[i]);
				currentNode.right = buildSubTree(inorder, postorder, i, mid+1, end, currentNode.right);
				break;
			}
		}
		for(int i=cur-1;i>=0;i--) {
			if(findInArray(inorder, postorder[i], start, mid) != -1) {
				currentNode.left = new TreeNode(postorder[i]);
				currentNode.left = buildSubTree(inorder, postorder, i, start, mid, currentNode.left);
				break;
			}
		}
		return currentNode;
	}
	
	public int findInArray(int[] array, int element, int start, int end) {
		for(int i=start;i<end;i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}

}
