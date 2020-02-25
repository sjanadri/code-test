package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GEPassport implements GEEngines{
    private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GEPassport.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 0;
    public final double flightHoursBeforeRebuild = 50_000;
    public final double dryWeight = 4_505;
    public final double wetWeight = 5_230;
    public final double takeoffThrust = 20_650;

    private double flightHours;
    private int numRebuilds;

    public GEPassport(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GEPassport(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GEPassport(String serialNumber) {
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
