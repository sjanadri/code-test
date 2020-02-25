package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 implements GEEngines{
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 3;
    public final double flightHoursBeforeRebuild = 25_000;
    public final double dryWeight = 14_502;
    public final double wetWeight = 15_100;
    public final double takeoffThrust = 81_070;

    private double flightHours;
    private int numRebuilds;

    public GE90(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }
    

    public int getNumRebuilds() {
		return numRebuilds;
	}

	public void setNumRebuilds(int numRebuilds) {
		this.numRebuilds = numRebuilds;
	}

	public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }
   
    
    
    /**
     * Method for the engines that calculates how many hours are left before a rebuild is needed
     * 
     * @return Number of hours after which the Rebuild is needed.
     */
    @Override
    public double hoursToRebuild(double flightHours, int numRebuilds) {

		if (numRebuilds >= maxNumRebuilds)
			return 0;
		else
			return (flightHours - (numRebuilds * flightHoursBeforeRebuild));

	}

    /**
     * Method for the engines that calculates how many hours of flight service is left.
     * 
     * @return Number of hours Flight Service is available.
     */
	@Override
	public double hoursToService(double flightHours) {	

    	double totalServiceHours = (maxNumRebuilds+1)*flightHoursBeforeRebuild;
    	
    	return totalServiceHours - flightHours;
	}

}
