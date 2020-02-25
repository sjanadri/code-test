package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GENx implements GEEngines{
    private static final Logger logger = LogManager.getLogger(GENx.class);

    private static final String ENGINE_MODEL = GENx.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 4;
    public final double flightHoursBeforeRebuild = 20_000;
    public final double dryWeight = 13_552;
    public final double wetWeight = 14_103;
    public final double takeoffThrust = 74_170;

    private double flightHours;
    private int numRebuilds;

    public GENx(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GENx(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GENx(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }
    
    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }
    
    @Override
    public double hoursToRebuild(double flightHours, int numRebuilds) {

		if (numRebuilds >= maxNumRebuilds)
			return 0;
		else
			return flightHours - (numRebuilds * flightHoursBeforeRebuild);

	}

	@Override
	public double hoursToService(double flightHours) {	

    	double totalServiceHours = (maxNumRebuilds+1)*flightHoursBeforeRebuild;
    	
    	return totalServiceHours - flightHours;
	}

}
