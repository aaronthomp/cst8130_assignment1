import java.util.Scanner;

/*
 * Student Name: Aaron Thompson
 * Student Number: 041058950
 * Prof: Dr. James Mwangi
 * Assignment 1 - Data Structures
 * Due Date: February 5th 2023
 **/

/**
 * class for vegetable items
 * @author Aaron
 *
 */
public class Vegetable extends FoodItem {
	/**
	 * stores farm name for vegetables
	 */
	private String farmName;
	
	/**
	 * no arg constructor
	 */
	Vegetable(){
		
	}
	
	/**
	 * prints the super class toString with a farm name
	 * @return returns String.format()
	 */
	public String toString() {
		
		return String.format("%s farm supplier: %s", super.toString(), farmName);
	}
	
	/**
	 * calls super class addItem method then asks user for farm name
	 * @param scanner accepts user input
	 * @return true 
	 * 
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		super.addItem(scanner);
		boolean validInput;
		System.out.print("Enter the name of the farm supplier: ");
		 do {
			try {
				farmName = scanner.nextLine();
				validInput = true;
			}
			catch(Exception e) {	
				validInput = false;
			}}while(!validInput);
		return true;
	}
	
}
