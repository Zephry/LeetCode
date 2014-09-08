import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordLadder2 {
//	public static char[] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("nkpe");
		dict.add("kkpe");
		dict.add("kkpo");
		dict.add("nkpo");
//		dict.add("prow");
//		dict.add("soap");
//		dict.add("guns");
//		dict.add("hops");
//		dict.add("cray");
//		dict.add("hove");
//		dict.add("ella");
//		dict.add("hour");
//		dict.add("lens");
//		dict.add("jive");
//		dict.add("wiry");
//		dict.add("earl");
//		dict.add("mara");
//		dict.add("part");
//		dict.add("mara");
//		dict.add("flue");
//		dict.add("putt");
//		dict.add("rory");
//		dict.add("bull");
//		dict.add("york");
//		dict.add("ruts");
//		dict.add("lily");
//		dict.add("vamp");
		List<List<String>> result = new ArrayList<List<String>>();
		result = findLadders("nape","nkqe", dict);
		System.out.print(1);
		
	}
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		dict.add(start);
		dict.add(end);
		
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(new ArrayList<String>());
		List<String> path = new ArrayList<String>();
		
		//Node
		List<String> Node = new ArrayList<String>();
//		List<List<String>> NodeRelation = new ArrayList<List<String>>();
		List<Set<String>> NodeDict = new ArrayList<Set<String>>();
		//Init
		List<String> nextNode = new ArrayList<String>();
		Node.add(start);
		NodeDict.add(dict);
		nextNode.add(start);
		int pathcount = 0;
		//start graph
		while(nextNode.size() != 0){
			String currentNode = nextNode.get(nextNode.size()-1);
			if(currentNode.equals(end)) {
				nextNode.remove(nextNode.size()-1);
				if(nextNode.size() == 0) {
					break;
				}
				currentNode = nextNode.get(nextNode.size()-1);
			}
			
			
			result.get(pathcount).add(currentNode);
//			path.add(currentNode);
			nextNode.remove(nextNode.size()-1);
			
			int index = Node.indexOf(currentNode);
			Set<String> currentDict = NodeDict.get(index);
//			List<String> currentRelation = new ArrayList<String>();
			currentDict.remove(currentNode);
			
			for(String NodeInDict : currentDict) {
				if(CompareString(NodeInDict, currentNode)) {
//					currentRelation.add(NodeInDict);
					
					nextNode.add(NodeInDict);
					Node.add(NodeInDict);
					NodeDict.add(currentDict);
					if(NodeInDict.equals(end)) {
//						path.add(end);
						result.get(pathcount).add(end);
						
						
						List<String> temp = new ArrayList<String>();
						for(int k = 0;k < path.size();k++) {
							
							temp.add(path.get(k));
							
							
						}
						result.add(temp);
						path.remove(path.size()-1);
					}
				}
			}
			
//			NodeRelation.add(currentRelation);			
		}
		
		
		
		return result;
		
	}
	public static Boolean CompareString(String word1, String word2) {
		int count = 0;
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


