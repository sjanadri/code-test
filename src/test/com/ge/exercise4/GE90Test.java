package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE90Test {

    GE90 testEngine;

    @Before
    public void setUp() {
        testEngine = new GE90("0001" , 30_000, 1);
    }

    @Test
    public void toStringTest() {
        assertEquals("GE90 SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    

    @Test
    public void hoursToRebuildTest() {
        assertEquals( 5000.0,testEngine.hoursToRebuild(testEngine.getFlightHours(), testEngine.getNumRebuilds()), 0);
    }
    
    @Test
    public void hoursToService() {
    	assertEquals(70000.0 , testEngine.hoursToService(testEngine.getFlightHours()), 0.0);
    }
}