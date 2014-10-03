package Binary_Tree_Level_Order_Traversal2;

import java.util.*;




public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Stack<List<Integer>> tmp = new Stack<List<Integer>>();
    	List<Integer> currentLevel = new ArrayList<Integer>();
        if(root == null) {
        	return result;
        }
        
        Queue<TreeNode> nextNode = new LinkedList<TreeNode>();
        int nextLevelnum = 0;
        int currentLevelnum = 0;
        
        
        nextNode.add(root);
        currentLevelnum++;
        
        while(!nextNode.isEmpty()) {
        	TreeNode currentNode = nextNode.poll();
        	currentLevelnum--;
        	currentLevel.add(currentNode.val);
        	if(currentNode.left!=null) {
        		nextLevelnum++;
        		nextNode.add(currentNode.left);
        	}
        	if(currentNode.right!=null) {
        		nextLevelnum++;
        		nextNode.add(currentNode.right);
        	}
        	if(currentLevelnum == 0) {
        		tmp.add(new ArrayList<Integer>(currentLevel));
        		currentLevelnum = nextLevelnum;
        		nextLevelnum = 0;
        		currentLevel = new ArrayList<Integer>();
        	}
        	
        }
        
        while(!tmp.empty()) {
        	result.add(tmp.pop());
        }
        
        
        return result;
        
    
    }

}
