package Restore_IP_Addresses;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		restoreIpAddresses("0000");
	}
	
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> addressList = new ArrayList<String>();
		int len = s.length();
		if(len == 0) {
			return addressList;
		}
		addressList.add("");
		String[] tmp = s.split("");
		String[] nums = new String[tmp.length-1];
		for(int i=0;i<nums.length;i++) {
			nums[i] = tmp[i+1];
		}
		return generateAddress(nums, 0, addressList, "");
        
        
    }
	
	public static List<String> generateAddress(String[] nums, int position, List<String> addressList, String tmp) {
		if(position == nums.length) {
			addressList.add("");
			tmp = "";
			return addressList;
		}else {
			String subString = addressList.get(addressList.size()-1);
			
			int last = 0;
			if(tmp != "") {
				last = Integer.valueOf(tmp);
			}
			if((last*10) + Integer.valueOf(nums[position]) > 255) {
				subString = subString + tmp + ".";
				tmp = nums[position];
			}else {
				subString = subString + tmp + nums[position] + ".";
				tmp = "";
			}
			
			String[] parts = subString.split(".");
			if(parts.length == 5) {
				subString = "";
				tmp = "";
				addressList.set(addressList.size()-1, subString);
			}else {
				addressList.set(addressList.size()-1, subString);
				addressList = generateAddress(nums, position+1, addressList, tmp);
			}
			
			return addressList;
		}
			
		
		
	}
	

}
