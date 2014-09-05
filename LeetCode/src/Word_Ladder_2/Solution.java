package Word_Ladder_2;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("aba");
		dict.add("aab");
		dict.add("bba");
		dict.add("baa");
		dict.add("bbc");
		System.out.println(findLadders("aaa","bbb", dict));
	}
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	dict.add(start);
    	dict.add(end);
    	Stack<Integer> Soncount = new Stack<Integer>();
    	Soncount.add(Integer.valueOf(1)));
    	List<WordNode> graph = drawGraph(dict);
    	List<List<String>> result = new ArrayList<List<String>>();
//    	int pathcount = 0;
    	Stack<WordNode> path = new Stack<WordNode>();
    	List<WordNode> nextNode = new Stack<WordNode>();
    	for(WordNode currentNode : graph) {
    		if(currentNode.word.equals(start)) {
//    			path.add(currentNode);
    			nextNode.add(currentNode);
    			currentNode.inStack = true;
    			break;
    		}
    	}
    	return GoGraph(path, result, end, nextNode, Soncount);
    	
    }
    public static List<List<String>> GoGraph(Stack<WordNode> path, List<List<String>> result, String end, List<WordNode> nextNode, Stack<Integer> Soncount) {
    	int son = Soncount.firstElement();
    	
    	while(!nextNode.isEmpty()) {
    		int nextNodeson = 0;
    		boolean noway = true;
    		WordNode currentNode = nextNode.get(0);
    		nextNode.remove(0);
    		son--;
//    		WordNode currentNode = path.firstElement();
//    		currentNode.inStack = true;
    		if(currentNode.word.equals(end)) {
    			List<String> newpath = new ArrayList<String>();
    			for(WordNode node : path) {
    				newpath.add(node.word);
    			}
    			result.add(newpath);
    			return result;
    		}else {
    			for(WordNode relation : currentNode.relations) {
    				if(!relation.inStack)
    				{
    					nextNode.add(relation);
        				relation.inStack = true;
//        				path.remove(0).inStack = false;
//        				break;
        				noway = false;
        				nextNodeson++;
    				}
        		}
    			
    			if(noway) {
    				
    			} else {
	    			Soncount.add(Integer.valueOf(nextNodeson));
	    			if(son == 0) {
	    				path.add(currentNode);
	    				Soncount.remove(0);
	    			}
	    			GoGraph(path, result, end, nextNode, Soncount);
	    			if(path.size() != 1) {
	    				path.pop().inStack = false;
	    			}
    			}
    		}
    		
    	}
		return result;
		
    	
    }
    
    public static List<WordNode> drawGraph(Set<String> dict) {
    	List<WordNode> Graph = new ArrayList<WordNode>();
    	for(String currentWord : dict) {
    		WordNode currentNode = new WordNode(currentWord);
    		Graph.add(currentNode);
    	}
    	for(WordNode currentNode : Graph) {
    		for(WordNode OtherNode : Graph) {
    			if(CompareString(currentNode.word, OtherNode.word)) {
    				currentNode.relations.add(OtherNode);
    			}
    		}
    	}
    	return Graph;
    }
    
    public static Boolean CompareString(String word1, String word2) {
		int count = 0;
		if(word1.equals(word2)) {
			return false;
		}
		for(int i = 0; i < word1.length(); i++){
			if(word1.charAt(i) != word2.charAt(i)) {
				count++;
				if(count == 2)
					return false;
			}
		}
			return (count == 1);
	}
}


    
