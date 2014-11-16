package Copy_List_with_Random_Pointer;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode a = new RandomListNode(-1);
		RandomListNode b = new RandomListNode(1);
		a.next = b;
		copyRandomList(a);
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> existedNodes = new HashMap<RandomListNode, RandomListNode>();
		if(head == null) {
			return null;
		}
        RandomListNode current = head;
        while(current != null) {
        	if(!existedNodes.containsKey(current)) {
        		RandomListNode newNode = new RandomListNode(current.label);
        		existedNodes.put(current, newNode);
        	}
        	RandomListNode tmp = existedNodes.get(current);
        	if(current.next != null) {
	        	if(!existedNodes.containsKey(current.next)) {
	        		RandomListNode newNode = new RandomListNode(current.next.label);
	        		existedNodes.put(current.next, newNode);
	        	}
	        	tmp.next = existedNodes.get(current.next);
        	}
        	if(current.random != null) {
	        	if(!existedNodes.containsKey(current.random)) {
	        		RandomListNode newNode = new RandomListNode(current.random.label);
	        		existedNodes.put(current.random, newNode);
	        	}
	        	tmp.random = existedNodes.get(current.random);
        	}
        	current = current.next;
        	
        }
		return existedNodes.get(head);
    }
	
	

}
