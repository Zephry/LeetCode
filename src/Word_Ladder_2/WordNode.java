package Word_Ladder_2;

import java.util.*;

public class WordNode {
	public String word;
	public List<WordNode> relations;
	public Boolean inStack;
	
	public WordNode() {
		inStack = false;
		relations = new ArrayList<WordNode>();
	}
	public WordNode(String name) {
		word = name;
		inStack = false;
		relations = new ArrayList<WordNode>();
	}

}
