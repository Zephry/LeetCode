package Plant_investment;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        FileWriter fw = new FileWriter("C:/Users/I302649/Documents/GitHub/LeetCode/src/Plant_investment/dataresult.txt");  
        
 

            
		FileInputStream f = new FileInputStream("C:/Users/I302649/Documents/GitHub/LeetCode/src/Plant_investment/data.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(f, "GBK");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String SetNumber = reader.readLine();
		int SetCount = Integer.valueOf(SetNumber);
		for(int i = 0;i < SetCount;i++) {
			int plantNumber = Integer.valueOf(reader.readLine());
			Plant[] plants = new Plant[plantNumber];
			for(int k = 0;k < plantNumber; k++) {
				String information = reader.readLine();
				String[] data = information.split(" ");
				plants[k] = new Plant(Integer.valueOf(data[1]), Float.valueOf(data[2]), Float.valueOf(data[3]), Integer.valueOf(data[1]));
				
				
			}
			if(Judge(plants)) {
				fw.write("Buy!\n");
			} else {
				fw.write("Don't buy!\n");
			}
		}
		fw.close();
		f.close();
	}
	
	public static boolean Judge(Plant[] plants) {
		float startValue = 0;
		for(Plant thisPlant : plants) {
			startValue += thisPlant.value;
		}
		for(int i = 1;i < 13; i++) {
			for(int k = plants.length - 1;k >= 0;k--) {
				float increase = plants[k].percent/100;
				float result = plants[k].value * (1+(increase));
				plants[k].value = result;
				Plant currentPlant = plants[k];
				
				if(currentPlant.livemonth == i) {
					if(k == plants.length - 1) {
						plants[k] = new Plant();
					} else {
						Plant nextPlant = plants[k + 1];
						if(currentPlant.value > nextPlant.value) {
							currentPlant.livemonth += currentPlant.cycle;
							plants[k + 1] = new Plant(currentPlant.livemonth, currentPlant.value, currentPlant.percent, currentPlant.cycle);
							plants[k] = new Plant();
						} else {
							
							plants[k] = new Plant();
						}
					}
				}
				
				
			}
		}
		
		float endValue = 0;
		for(Plant thisPlant : plants) {
			endValue += thisPlant.value;
		}
		
		if(endValue > startValue) {
			return true;
		} else {
			return false;
		}
	}

}
