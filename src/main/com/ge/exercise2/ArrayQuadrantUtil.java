package com.ge.exercise2;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);
    
    String[][] data;

    public ArrayQuadrantUtil(String[][] data) { 
        this.data = data;
    }
    
    public String[] getQuadrantValues(int row, int column, int quadSize) {
    	
    	int row_start = row* quadSize  ;
    	int row_end = row_start + quadSize ;
    	
    	int col_start = column* quadSize  ;
    	int col_end = col_start + quadSize ;
    	
    	String[] quadValues = new String[quadSize*quadSize];
    	 
    	int k=0;
    	
    	for (int i = row_start ; i < row_end ; i++ ) {
    		for(int j = col_start ; j< col_end ; j++){
    			quadValues[k++] = data[i][j];
    			
    		}
    	}  	
    	return quadValues;
    }



	public String[] getColumnValues(int colSelected) {
		logger.info("Retriving Column Values for Column numbered {0}", colSelected );
		String[] columnData = new String[data[0].length];
		
		for(int row = 0; row < data.length; row++) {
			columnData[row] = data[row][colSelected];
		}
		return columnData;
	}

	public String[] getRowValues(int rowSelected) {
		return data[rowSelected];
	}

	  public HashMap<Integer, Quadrant> getQuadrants(int quadSize) {

	    	HashMap<Integer, Quadrant> quadrants = new HashMap<Integer, Quadrant>();
	    	
	    	int quadCount = 0;
			
			int quadHeight = data.length / quadSize;
			int quadBreadth = data[0].length / quadSize;
			
			for(int i = 0; i < quadHeight ; i++) {
				for(int j = 0; j < quadBreadth ; j++) {
					quadrants.put(++quadCount, new Quadrant(i, j));		
				}	
			}	 
	    	return quadrants;
	    }
 
	
}
