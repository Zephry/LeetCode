package Construct_Binary_Tree_Preorder_Inorder;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,5,6,8,7,2,1};
		int[] inorder = {6,5,8,7,3,1,2};
		buildTree(preorder, inorder);
	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	int len = preorder.length;
    	if(len == 0) {
    		return null;
    	}
    	if(len == 1)
    	{
    		return new TreeNode(preorder[0]);
    	}
        boolean[] viewed = new boolean[len];
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        root =  buildSubTree(preorder, inorder, rootVal, root);
        
        return root;
        
        
        
    }
    
    
    public static TreeNode buildSubTree(int[] preorder, int[] Subinorder, int current, TreeNode currentNode) {
    	currentNode.left = null;
    	currentNode.right = null;
    	int currentPosition = -1;
    	for(int i=0;i< preorder.length;i++) {
    		if(current == preorder[i]) {
    			currentPosition = i;
    		}
    	}
    	int[] leftSuborder = new int[5000];
    	int[] rightSuborder = new int[5000];
    	int leftnum = 0;
    	int rightnum = 0;
    	for(int i=0;i<Subinorder.length;i++) {
    		if(Subinorder[i] != current) {
    			leftSuborder[i] = Subinorder[i];
    			leftnum++;
    		} else if(Subinorder[i] == current){
    			for(int k = i+1;k<Subinorder.length;k++) {
    				rightSuborder[k-i-1] = Subinorder[k];
    				rightnum++;
    			}
    			break;
    		}
    	}
    	int[] leftSubTree = new int[leftnum];
    	int[] rightSubTree = new int[rightnum];
    	for(int i=0;i<leftnum;i++) {
    		leftSubTree[i] = leftSuborder[i];
    	}
    	for(int i=0;i<rightnum;i++) {
    		rightSubTree[i] = rightSuborder[i];
    	}
    	
    	for(int i=currentPosition+1;i<preorder.length;i++) {
    		int target = preorder[i];
    		boolean finded = false;
    		for(int m=0;m<leftnum;m++) {
    			if(target == leftSubTree[m]) {
    				TreeNode newNode = new TreeNode(target);
    				currentNode.left = newNode;
    				buildSubTree(preorder, leftSubTree, target, newNode);
    				finded = true;
    				break;
    			}
    		}
    		if(finded) {
    			break;
    		}
    	}
    	for(int i=currentPosition+1;i<preorder.length;i++) {
    		int target = preorder[i];
    		boolean finded = false;
	    	for(int m=0;m<rightnum;m++) {
				if(target == rightSubTree[m]) {
					TreeNode newNode = new TreeNode(target);
					currentNode.right = newNode;
					buildSubTree(preorder, rightSubTree, target, newNode);
					finded = true;
					break;
				}
			}
	    	if(finded) {
    			break;
    		}
    	}
    	
    	return currentNode;
    	
    	
    }
    
    
    
    
    
}
