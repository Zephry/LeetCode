package XiongYaLiPath;

import java.util.*;

public class Node {
	boolean visited;
	boolean inGrouped;
	List<Node> disNeigh;
	List<Node> neigh;
	int num;
	
	public Node(int i) {
		num = i;
		visited = false;
		inGrouped = false;
		disNeigh = new ArrayList<Node>();
		neigh = new ArrayList<Node>();
	}
}
