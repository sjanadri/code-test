package com.ge.exercise2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class main thread to Array util.
 *
 */
public class ArrayUtilApp {
	
	static Scanner sc = new Scanner(System.in);
	static String[][] array; 

	public static void main(String[] args) {
	
  //Read input from Console.
	array = readInput(); 
	
	int selectView;
	
		do{
		System.out.println("Select the oparation :");
		System.out.println("1. Retrieve Row Values");
		System.out.println("2. Retrieve Column Values");
		System.out.println("3. Retrieve Quadrant Values");
		
		selectView = sc.nextInt();
		}while(!((selectView>= 1) && (selectView  < 4)));	
		
		ArrayQuadrantUtil arrayQuadrantUtil = new ArrayQuadrantUtil(array);
		
		switch(selectView) {
		case 1 : showRow(arrayQuadrantUtil);
		
			break;
		
		case 2 : showColumn(arrayQuadrantUtil);
			break;
			
		case 3 : try {
				showQuadrant(arrayQuadrantUtil);
					} catch (DimensionException e) {
				System.err.println(e.getMessage());
							}
			break;
			
		default :
			System.out.println("Invalid Choice");
		}
		 
	}

	private static void showQuadrant(ArrayQuadrantUtil arrayQuadrantUtil) throws DimensionException {
		
		if(array.length % 2 !=0 && array[0].length %2 !=0) {
			throw new DimensionException("Quadrant can be obtained only for input Array with Even Dimensions.");
		}
		 
		System.out.println("Enter the Quadrant size :");
		int quadSize = sc.nextInt();
		
		if(array.length % quadSize != 0 && array[0].length % quadSize != 0 ) {
			throw new DimensionException("Quadrant not Possible for the input array");
		}else {
			
			HashMap<Integer, Quadrant> quadrants = arrayQuadrantUtil.getQuadrants(quadSize);
			
			for (Integer key : quadrants.keySet()) {
				System.out.println(key + ". ("+ quadrants.get(key).row +","+ quadrants.get(key).row + ")");
			}
			
			int choice;
			do{
				System.out.println("Select the valid Quadrant to view:");
				choice = sc.nextInt();
			}while(!(quadrants.containsKey(choice)));
			String[] quadValues = arrayQuadrantUtil.getQuadrantValues(quadrants.get(choice).row, quadrants.get(choice).column , quadSize);
			display(quadValues);
		}	
	}
	

	private static void showColumn(ArrayQuadrantUtil arrayQuadrantUtil) {
		System.out.println("Enter the column number to view :");
		int colSelected;
		
		do {
		System.out.println("Columns available are : 0 - "+ ( array[0].length-1));	
		colSelected = sc.nextInt();
		}while(!((colSelected>= 0) && (colSelected < array[0].length)));
		
		String[] colValues = arrayQuadrantUtil.getColumnValues(colSelected);
		display(colValues);
		
	}

	private static void showRow(ArrayQuadrantUtil arrayQuadrantUtil) {
		System.out.println("Enter the row number to view :");
		int rowSelected;
		
		do {
		System.out.println("Rows available are : 0 - "+ ( array.length-1));	
		rowSelected = sc.nextInt();
		}while(!((rowSelected>= 0) && (rowSelected < array.length)));
			
		String[] rowValues = arrayQuadrantUtil.getRowValues(rowSelected);
		display(rowValues);
	}

	
	private static void display(String[] values) {
		
		for(int i = 0; i< values.length ; i ++) {
			System.out.println(values[i] + "");
		}
		
	}

	/**
	 * Reads input from users and Stores into 2-D array.
	 * 
	 * @Returns {@link Array} of {@link String}.
	 */
	private static String[][] readInput() {

		System.out.println("Enter Num of Rows :");
		int rows = sc.nextInt();
		
		System.out.println("Enter Num of Columns :");
		int columns = sc.nextInt();
		
		String[][] data = new String[rows][columns];
		System.out.println("Enter the inputs to array :");
		
		for (int i = 0; i < rows; i++) {
		      for (int j = 0; j < columns; j++) {
		        String value = sc.next();
		        data[i][j] = value;
		      }
		    }
		return data;
	}
}
