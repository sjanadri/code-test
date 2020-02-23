package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        String[][] data = {
                {"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"},
                {"m", "n", "o", "p"}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0, 2));

        String[] expectedResult = {"a", "b", "e", "f"};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0 , 2));
    }
}