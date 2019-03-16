package com.root.inter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Process {
	
	//trim the inputs
	//refine exception propagation
	//Separate business logic from POJO objects
	//Use java NIO to read files
	//could break down some of the methods 
   
   private static Set<String> Drivers = new HashSet<String>(); 
   private static Map<String, ArrayList<Trip>> Drivers_Trips = new HashMap<String,ArrayList<Trip>>();
   //private static Set<DriverStats> DriverStatsView = new HashSet<DriverStats>();
   private static TreeSet<DriverStats> DriverStatsView = new TreeSet<DriverStats>(new MilesComparator());
   
	
   public static void main(String[] args) {
	   
	   if(args.length == 1)
	   {
			readData(args[0]);

			populateDriverStatsView();
			
			printFromView();
	   }
	   else
	   {
		   System.out.println("Number of command line arguments not equal to one//incorrect filepath");
	   }
	}
   
   
   
   private static void printFromView()
   {
	   Iterator<DriverStats> iter = DriverStatsView.iterator();
		
	   while (iter.hasNext()) {
		   DriverStats ds = iter.next();
		   if(ds.getTotalMiles() > 0 )
		   {
			   System.out.println(ds.getDriver()+ " "+ds.getTotalMiles()+" miles @ "+ds.getAverageSpeed()+ " mph"); 
		   }
		   else
		   {
			   System.out.println(ds.getDriver()+ " "+ds.getTotalMiles()+" miles");
		   }
	   }  
   }
   
   //processes Driver_Trips and fills DriverStatsView
   private static void populateDriverStatsView()
   {
	Iterator<String> iter = Drivers.iterator();
	
	   while (iter.hasNext()) {
	       //System.out.println(iter.next());   
		   String DriverName = iter.next();
		   
		    ArrayList<Trip> trips = Drivers_Trips.get(DriverName);
		    int totalMiles = trips.stream().mapToInt(o -> (int)o.getMiles()).sum();
		    int averageSpeed = 0;
		    if(trips.size() != 0)
		       averageSpeed = (int) (trips.stream().mapToDouble(o -> (double)Trip.averageSpeed(o)).sum()/trips.size());
		    
		    DriverStatsView.add(new DriverStats(DriverName,totalMiles,averageSpeed));		    		    
	   }	     
   }
   
   //reads data from the file and stores in Drivers_Trips
   private static void readData(String filepath)
   {
	   System.out.println("Processing... ");
	   BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					filepath));
			String line = reader.readLine();
			while (line != null) {
				
				
				String[] line_split = line.trim().split(" ");
				
				if("Driver".equalsIgnoreCase(line_split[0]))
				{
					//check if the driver is already present
					Drivers.add(line_split[1]);
					Drivers_Trips.put(line_split[1], new ArrayList<Trip>());
				}	
				else if("Trip".equalsIgnoreCase(line_split[0]))
				{
					if(Drivers.contains(line_split[1]))
					{
						Trip trip = new Trip(line_split[2],line_split[3],line_split[4]);
						BooleanResult br = Trip.isValid(trip);
						if(br.getResult())
							Drivers_Trips.get(line_split[1]).add(trip);
						else
							System.out.println("Ignoring line: "+line+" because "+br.getMessage());
					}
					else
					{
						System.out.println("Ignoring line: "+line+" because driver is not in registered drivers");
					}
				}
				else
				{
					System.out.println("Ignoring line: "+line+" because the first word is not Driver or Trip");
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
	 }  
   }
}
