package XiongYaLiPath;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node[] nodes = new Node[10];
		for(int i=0;i<10;i++) {
			nodes[i] = new Node(i);
		}
		nodes[0].disNeigh.add(nodes[6]);
		nodes[0].disNeigh.add(nodes[9]);
		nodes[1].disNeigh.add(nodes[6]);
		nodes[1].disNeigh.add(nodes[7]);
		nodes[1].disNeigh.add(nodes[8]);
		nodes[2].disNeigh.add(nodes[5]);
		nodes[2].disNeigh.add(nodes[9]);
		nodes[3].disNeigh.add(nodes[5]);
		nodes[3].disNeigh.add(nodes[9]);
		nodes[4].disNeigh.add(nodes[6]);
		
//		nodes[4].disNeigh.add(nodes[8]);
		
		nodes[5].disNeigh.add(nodes[2]);
		nodes[5].disNeigh.add(nodes[3]);
		nodes[6].disNeigh.add(nodes[0]);
		nodes[6].disNeigh.add(nodes[1]);
		nodes[6].disNeigh.add(nodes[3]);
		nodes[6].disNeigh.add(nodes[4]);
		nodes[7].disNeigh.add(nodes[1]);
		nodes[8].disNeigh.add(nodes[1]);
		
//		nodes[8].disNeigh.add(nodes[4]);
		
		nodes[9].disNeigh.add(nodes[0]);
		nodes[9].disNeigh.add(nodes[2]);
		nodes[9].disNeigh.add(nodes[3]);
		
		System.out.println(findMax(Arrays.asList(nodes)));
	}
	
	
	public static int findMax(List<Node> nodes) {
		int count = 0;
		for(int i=0;i<5;i++) {
			nodes.get(i).inGrouped = true;
			findPath(nodes.get(i), false);
			
			for(Node n: nodes) {
				n.visited = false;
			}
		}
		for(int i=0;i<5;i++) {
			if(nodes.get(i).neigh.size() != 0) {
				count++;
			}
		}
		return count;
				
	}
	
	public static int findPath(Node node, boolean existed) {
		if(node.visited) {
			return -1;
		}
		if(!node.inGrouped) {
			return 0;
		}
		node.visited = true;
		if(existed) {
			for(Node nextNode : node.neigh) {
				int result = findPath(nextNode, !existed);
				
				if(result != -1) {
					nextNode.inGrouped = true;
					node.neigh.remove(nextNode);
					node.disNeigh.add(nextNode);
					nextNode.neigh.remove(node);
					nextNode.disNeigh.add(node);
					return result+1;
				}
			}
		}else {
			for(Node nextNode : node.disNeigh) {
				int result = findPath(nextNode, !existed);
				if(result != -1) {
					nextNode.inGrouped = true;
					node.disNeigh.remove(nextNode);
					node.neigh.add(nextNode);
					nextNode.disNeigh.remove(node);
					nextNode.neigh.add(node);
					return result+1;
				}
			}
		}
		return -1;
		
		
		
	}
	
	
	
}
