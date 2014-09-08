package LRU_Cache;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class LRUCache {
	public static void main(String[] args) {
		LRUCache instance = new LRUCache(2);
		instance.get(2);
		instance.set(2, 6);
		instance.get(1);
		instance.set(1, 5);
		instance.set(1, 2);
		instance.get(1);
		instance.get(2);
		
//		LRUCache instance = new LRUCache(1);
//		instance.set(2, 1);
//
//		instance.get(2);
//		instance.set(3, 2);
//		instance.get(2);
//		instance.get(3);
	}
	Hashtable<Integer, Integer> data;
	int capacity;
    int used;
	List<Integer> LRU = new ArrayList<Integer>();
		public LRUCache(int capacity) {
	        data = new Hashtable<Integer, Integer>();
	        this.capacity = capacity;
	        used = 0;
	    }
	    
	    public int get(int key) {
	    	if(data == null) {
	    		return -1;
	    	} else {
	    		 if(data.get(key) == null) {
	    			 return -1;
	    		 }
	    		 	int index = LRU.indexOf(Integer.valueOf(key));
		        	Integer keycontent = LRU.get(index);
		        	LRU.remove(index);
		        	LRU.add(keycontent);
	    			 return data.get(key);
	    	}
	       
	    }
	    
	    public void set(int key, int value) {
	    	if(data.containsKey(key)) {
	        	data.put(key, value);
	        	int index = LRU.indexOf(Integer.valueOf(key));
	        	Integer keycontent = LRU.get(index);
	        	LRU.remove(index);
	        	LRU.add(keycontent);
	    	} else if(used == capacity) {
	    		data.remove(LRU.get(0));
	    		LRU.remove(0);
	    		LRU.add(Integer.valueOf(key));
	    		data.put(key, value);
	    	} else {
		        	used++;
		        	data.put(key, value);
		        	LRU.add(Integer.valueOf(key));
		        }
	    	}
	        
	        	
	        
}
