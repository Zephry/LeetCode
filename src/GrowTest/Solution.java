package GrowTest;

import java.util.*;

public class Solution {
	static final int GO_LEFT  = 0;
	static final int GO_RIGHT = 1;
	static final int GO_UP = 2;
	static final int GO_DOWN = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinRoute());
	}
	
	
	public static int[][] exchange(int[][] pattern, int action) {
		int x = -1;
		int y = -1;
		int yLen = pattern.length;
		int xLen = pattern[0].length;
		for(int i=0;i<yLen;i++) {
			for(int j=0;j<xLen;j++) {
				if(pattern[i][j] == 0) {
					y = i;
					x = j;
				
				}
			}
		}
		if(action == GO_UP) {
			if(y>0) {
				int tmp = pattern[y-1][x];
				pattern[y-1][x] = pattern[y][x];
				pattern[y][x] = tmp;
			}
			
		}else if(action == GO_DOWN) {
			if(y<yLen-1) {
				int tmp = pattern[y][x];
				pattern[y][x] = pattern[y+1][x];
				pattern[y+1][x] = tmp;
			}
		}else if(action == GO_LEFT) {
			if(x>0) {
				int tmp = pattern[y][x];
				pattern[y][x] = pattern[y][x-1];
				pattern[y][x-1] = tmp;
			}
		}else if(action == GO_RIGHT) {
			if(x<xLen-1) {
				int tmp = pattern[y][x];
				pattern[y][x] = pattern[y][x+1];
				pattern[y][x+1] = tmp;
			}
		}
		return pattern;
	}
	
	
	public static String pattern2String(int[][] pattern) {
		String result = "";
		int yLen = pattern.length;
		int xLen = pattern[0].length;
		for(int i=0;i<yLen;i++) {
			for(int j=0;j<xLen;j++) {
				result = result + String.valueOf(pattern[i][j]);
			}
		}
		return result;
	}
	
	public static int[][] String2Pattern(String s) {
		int[][] pattern = new int[4][4];
		String[] letters = s.split("");
		int yLen = pattern.length;
		int xLen = pattern[0].length;
		for(int i=0;i<yLen;i++) {
			for(int j=0;j<xLen;j++) {
				pattern[i][j] = Integer.valueOf(letters[(4*i)+j+1]);
			}
		}
		return pattern;
	}
	
	public static int findMinRoute() {
		String start = "0122112211221122";
		String end = "0212212112122121";
		Set<String> map = new HashSet<String>();
		map.add(start);
		
		Queue<String> nextPattern = new LinkedList<String>();
		nextPattern.add(start);
		Queue<Integer> count= new LinkedList<Integer>();
		count.add(0);
		int times = -1;
		while(!nextPattern.isEmpty()) {
			String current = nextPattern.poll();
			int[][] currentPattern = String2Pattern(current);
			times = count.poll();
			
			String currentPatternLeft = pattern2String(exchange(currentPattern, GO_LEFT));
			if(currentPatternLeft.equals(end)) {
				break;
			}
			if(!map.contains(currentPatternLeft)) {
				count.add(times+1);
				map.add(currentPatternLeft);
				nextPattern.add(currentPatternLeft);
			}
			currentPattern = String2Pattern(current);
			String currentPatternRight = pattern2String(exchange(currentPattern, GO_RIGHT));
			if(currentPatternRight.equals(end)) {
				break;
			}
			if(!map.contains(currentPatternRight)) {
				count.add(times+1);
				map.add(currentPatternRight);
				nextPattern.add(currentPatternRight);
			}
			currentPattern = String2Pattern(current);
			String currentPatternUp = pattern2String(exchange(currentPattern, GO_UP));
			if(currentPatternUp.equals(end)) {
				break;
			}
			if(!map.contains(currentPatternUp)) {
				count.add(times+1);
				map.add(currentPatternUp);
				nextPattern.add(currentPatternUp);
			}
			currentPattern = String2Pattern(current);
			String currentPatternDown = pattern2String(exchange(currentPattern, GO_DOWN));
			if(currentPatternDown.equals(end)) {
				break;
			}
			if(!map.contains(currentPatternDown)) {
				count.add(times+1);
				map.add(currentPatternDown);
				nextPattern.add(currentPatternDown);
			}
			
		}
		
		return times+1;
		
	}
	
	
	
	

}




