package com.root.inter;

import java.util.Comparator;

/*
 * class to sort the final results by total miles.
 */

public class MilesComparator implements Comparator<DriverStats> {
	@Override
	public int compare(DriverStats ds1, DriverStats ds2) {		  
		if(ds1.getTotalMiles()==ds2.getTotalMiles())  
			return 0;  
		else if(ds1.getTotalMiles()<ds2.getTotalMiles())  
			return 1;  
		else  
			return -1;
	}  

}

