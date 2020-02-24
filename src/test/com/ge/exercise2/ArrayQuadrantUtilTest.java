package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        Object[][] data = {
                {"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"},
                {"m", "n", "o", "p"}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0, 2));

        Object[] expectedResult = {"a", "b", "e", "f"};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0 , 2));
    }
    
    @Test
    public void getQuadrantValuesTest1() {
        Object[][] data = {
                {3, 6, 5, 7},
                {8, 9, 7, 6},
                {8, 7, 0, 0},
                {7, 8, 0, 5}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0, 2));

        Object[] expectedResult = {3, 6, 8, 9};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0 , 2));
    }
    
    @Test
    public void getQuadrantValuesTest2() {
        Object[][] data = {
                {'a', 'e', 'i', 'o'},
                {'u', 'x', 'u', 'j'},
                {'o', 'k', 'l', 'p'},
                {'7', 'i', 'n', 'n'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0, 2));

        Object[] expectedResult = {'i', 'o', 'u', 'j'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 1 , 2));
    }
}