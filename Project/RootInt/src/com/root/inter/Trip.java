package com.root.inter;
import java.time.LocalTime; 
import static java.time.temporal.ChronoUnit.MINUTES;

public class Trip {
	
	private LocalTime startTime;
	public LocalTime getStartTime() {
		return startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public float getMiles() {
		return miles;
	}



	private LocalTime endTime;
	private float miles;
	
	public Trip()
	{
	}
	
	public Trip(String startTime, String endTime, String miles)
	{
		String[] startTime_split = startTime.split(":");
		String[] endTime_split = endTime.split(":");
		
		this.startTime = LocalTime.of(Integer.parseInt(startTime_split[0]), 
				Integer.parseInt(startTime_split[1]));

		this.endTime = LocalTime.of(Integer.parseInt(endTime_split[0]), 
				Integer.parseInt(endTime_split[1]));
		
		this.miles = Float.parseFloat(miles);
	}
	
	public static float averageSpeed(Trip trip)
	{
		float result = -1; //implies that startTime > endTime
		
		if(trip.startTime.isBefore(trip.endTime))
		{
			 float time_diff = (float)MINUTES.between(trip.startTime, trip.endTime);
			 result = trip.miles/(time_diff/60.0f);
		}
		
		return result;
	}
	
	public static BooleanResult isValid(Trip trip)
	{
		BooleanResult br = new BooleanResult(false,"");
		
		int averagespeed = (int)Trip.averageSpeed(trip);
		
		if(averagespeed == -1)
		{
			br.setMessage("startTime > EndTime");
		}
		else if(averagespeed < 5)
		{
			br.setMessage("Average speed < 5");
		}
		else if(averagespeed > 100)
		{
			br.setMessage("Average speed > 100");
		}
		else
		{
			br.setMessage("Success");
			br.setResult(true);
		}
		return br;
	}

}
