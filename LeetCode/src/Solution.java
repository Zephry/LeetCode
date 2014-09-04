import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
	public static char[] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hog");
		dict.add("dog");
		List<List<String>> result = new ArrayList<List<String>>();
		result = findLadders("hot","dog", dict);
		System.out.print(1);
		
	}
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<List<String>> result1 = new ArrayList<List<String>>();
		
		dict.add(end);
		
		
		for(int i = 0;i<start.length();i++) {
			result1 = changeCharandFindit(dict, start, i, end, result1, 0);
			if(result1 != null) {
				for(int q = 0;q<result1.size();q++) {
					result.add(result1.get(q));
				}
			}
			result1 = new ArrayList<List<String>>();
		}
		
		
		
		return result;
    }
	public static List<List<String>> changeCharandFindit(Set<String> dict, String word, int position, String end, List<List<String>> result, int pathcount) {
		List<String> nowresult;
		if(result.size() == 0) {
			nowresult = new ArrayList<String>();
		}else {
			nowresult = result.get(pathcount);
		}
		List<List<String>> returnResult = new ArrayList<List<String>>();
		char[] words = word.toCharArray();
		String lastword = word;
		int i = 0;
		for(i=0;i<26;i++) {
			words[position] = letter[i];
			word = String.copyValueOf(words);
			
			if(dict.contains(word) && !word.equals(lastword)) {
				dict.remove(word);
				nowresult.add(word);
				if(result.size() == 0) {
					result.add(nowresult);
				} else {
					result.set(pathcount, nowresult);
				}
				break;
			}
		}
		if(i == 26) {	//no next node
			return null;
		}
		if(nowresult.get(nowresult.size()-1).equals(end)) {
			System.out.print(1);
			return result;
		}else {
			for(int k = 0;k<word.length();k++) {
				returnResult = changeCharandFindit(dict, word, k, end, result, pathcount);
				if(returnResult != null && returnResult.get(pathcount).get(returnResult.get(pathcount).size()-1).equals(end)) {
					
						result.set(pathcount, returnResult.get(pathcount));
					
					pathcount++;
					return result;
				}
			}
			return result;
		}
		
		
	}
	
}
