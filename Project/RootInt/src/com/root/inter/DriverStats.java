package com.root.inter;
import java.util.Objects;

public class DriverStats {
	
	private String driver;
	private int totalMiles;
	private int averageSpeed;
	
	public DriverStats(String driverName, int totalMiles, int averageSpeed) {
		// TODO Auto-generated constructor stub
		this.driver = driverName;
		this.totalMiles = totalMiles;
		this.averageSpeed = averageSpeed;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public int getTotalMiles() {
		return totalMiles;
	}
	public void setTotalMiles(int totalMiles) {
		this.totalMiles = totalMiles;
	}
	public int getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(int averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	
	//for printing the results mostly
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Driver)) {
            return false;
        }
        String driver = (String) o;     
        return driver.equalsIgnoreCase(driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver,totalMiles,averageSpeed);
    }
}
