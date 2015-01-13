package Restore_IP_Addresses;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> addressList = new ArrayList<String>();
		addressList = restoreIpAddresses("0000");
	}
	
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> addressList = new ArrayList<String>();
		int len = s.length();
		if(len == 0) {
			return addressList;
		}
		
		String[] tmp = s.split("");
		String[] nums = new String[tmp.length-1];
		for(int i=0;i<nums.length;i++) {
			nums[i] = tmp[i+1];
		}
		return generateAddress(nums, 0, addressList, "");
        
        
    }
	
	public static List<String> generateAddress(String[] nums, int position, List<String> addressList, String tmp) {
		String[] parts = tmp.split("\\.");
		if(parts.length == 5) {
			return addressList;
		}
		if(position == nums.length) {
			if(parts.length == 4) {
				addressList.add(tmp);
				return addressList;
			}else {
				return addressList;
			}
		}
		
		String last;
		if(parts.length == 0) {
			last = tmp;
		}else {
			last = parts[parts.length-1];
		}
		if(Integer.valueOf(last+nums[position]) < 256) {
			addressList = generateAddress(nums, position+1, addressList, tmp+nums[position]);
		}
		if(tmp != "") {
			addressList = generateAddress(nums, position+1, addressList, tmp+"."+nums[position]);
		}
		return addressList;
		
		
		
		
	}
	

}
