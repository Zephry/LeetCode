package Simplify_Path;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = "a\\a\\b".split("\\");
	}
	
    public String simplifyPath(String path) {
    	if(path == "") {
    		return "";
    	}
        String[] level = path.split("/");
        String resultPath = "/";
        Stack<String> pathStack = new Stack<String>();
        
        for(String curLevel : level) {
        	if(curLevel.equals(".")) {
        		
        	}else if(curLevel.equals("..")) {
        		if(!pathStack.empty()) {
        			pathStack.pop();
        		}
        	}else if(curLevel.equals("")) {
        		
        	}else {
        		pathStack.push(curLevel);
        	}
        }
        
        if(pathStack.empty()) {
        	return resultPath;
        }
        resultPath = "";
        while(!pathStack.empty()) {
			resultPath = resultPath + "/" + pathStack.get(0);
			pathStack.remove(0);
		}
        return resultPath;
    }

}
