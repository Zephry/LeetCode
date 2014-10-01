package Clone_Graph;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode a = new UndirectedGraphNode(0);
		a.neighbors.add(a);
		a.neighbors.add(a);
		cloneGraph(a);
	}
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) {
    		return node;
    	}
        Queue<UndirectedGraphNode> nextNode = new LinkedList<UndirectedGraphNode>();
        boolean[] created = new boolean[10000];
        for(int i=0;i<10000;i++) {
        	created[i] = false;
        }
        HashMap<Integer, UndirectedGraphNode> recorded = new HashMap<Integer, UndirectedGraphNode>();
        
        
        nextNode.add(node);
        
        while(!nextNode.isEmpty()) {
        	UndirectedGraphNode current = nextNode.poll();
        	int label = current.label;
        	UndirectedGraphNode newNode;
        	if(created[label+5000]) {
        		newNode = recorded.get(label);
        	} else {
        		newNode = new UndirectedGraphNode(label);
        		recorded.put(label, newNode);
        		created[label+5000] = true;
        		
        	}
        	
        	List<UndirectedGraphNode> tmp = current.neighbors;
    		for(UndirectedGraphNode neigh : tmp) {
        		int neighLabel = neigh.label;
        		UndirectedGraphNode newNeigh;
        		if(created[neighLabel+5000]) {
        			newNeigh = recorded.get(neighLabel);
        			newNode.neighbors.add(newNeigh);
        		} else {
        			newNeigh = new UndirectedGraphNode(neighLabel);
        			recorded.put(neighLabel, newNeigh);
        			created[neighLabel+5000] = true;
        			newNode.neighbors.add(newNeigh);
        			nextNode.add(neigh);
        		}
        		
        		
        	}
    		
    		
        }
        
        return recorded.get(node.label);
    	
    	
    	
    }

}
