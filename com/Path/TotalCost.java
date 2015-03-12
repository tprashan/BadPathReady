import java.io.*;
import java.util.*;

class TotalCost{
	public static Double findCost(String fileName){
		Double totalCost = 0.0;
		int queueLength = Routes.queue.size();
		String firstCity = Routes.queue.poll();
		String secondCity = Routes.queue.poll();
		for (int i=0;i<queueLength-1;i++) {
			try{
				File inFile = new File(fileName);
		        FileInputStream fstream = new FileInputStream(inFile);
		        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			    String strLine=br.readLine();
	            while ( strLine != null)   {
	            	String[] cities = strLine.split(",");
	            	if(cities[0].equals(firstCity) && cities[1].equals(secondCity)||
	            		cities[0].equals(secondCity) && cities[1].equals(firstCity)){
	            		totalCost = (Double.parseDouble(cities[2])+totalCost);
	            		firstCity=secondCity;
	            		secondCity=Routes.queue.poll();
	            	}
	            	strLine = br.readLine();
	            }

			}catch (Exception e){
			    System.err.println("Error: " + e.getMessage());
			}
		}
		return totalCost;
	}
}