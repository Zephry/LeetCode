package Recover_Binary_Search_Tree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode[] wrongNode = new TreeNode[2];
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);

		b.right = a;
		recoverTree(b);
	}
    public static void recoverTree(TreeNode root) {
    	TreeNode tmpNode = root;
        if(root == null) {
        	return;
        }
        while(tmpNode.left != null) {
        	tmpNode = tmpNode.left;
        }
        TreeNode[] wrongNode = new TreeNode[5];
        wrongNode[4] = tmpNode;
        wrongNode = findWrongNode(root, wrongNode, root);
        if(wrongNode[2] != null) {
        	int tmp = wrongNode[0].val;
       	 	wrongNode[0].val = wrongNode[3].val;
       	 	wrongNode[3].val = tmp;
        } else  {
        	 int tmp = wrongNode[0].val;
        	 wrongNode[0].val = wrongNode[1].val;
        	 wrongNode[1].val = tmp;
        }
    }
    
    
    
    public static TreeNode[] findWrongNode(TreeNode root, TreeNode[] wrongNode, TreeNode currentNode) {
    	if(currentNode == null) {
    		return wrongNode;
    	}
    	wrongNode = findWrongNode(root, wrongNode, currentNode.left);
    	
    	if(currentNode.val < wrongNode[4].val) {
    		if(wrongNode[0] == null) {
    			wrongNode[0] = wrongNode[4];
    			wrongNode[1] = currentNode;
    		} else{
    			wrongNode[2] = wrongNode[4];
    			wrongNode[3] = currentNode;
    			return wrongNode;
    		}
    	}
    	wrongNode[4] = currentNode;
    	wrongNode = findWrongNode(root, wrongNode, currentNode.right);

    	
    	return wrongNode;
    }
    
    
    
    
}
