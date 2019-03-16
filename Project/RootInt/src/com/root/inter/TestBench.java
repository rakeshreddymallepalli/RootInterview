package com.root.inter;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestBench {
	
	 @Test
	    public void Trip_validateisValidMethod() {
		 
	        assertEquals(true, Trip.isValid(new Trip("07:15","07:45","17.3")).getResult());
	        //starttime > endtime
	        assertEquals(false, Trip.isValid(new Trip("07:55","07:45","17.3")).getResult());
	        // > 100
	        assertEquals(false, Trip.isValid(new Trip("07:55","07:45","500")).getResult());
	        // < 5
	        assertEquals(false, Trip.isValid(new Trip("07:15","07:45","1")).getResult());
	    }

}
