import java.util.Scanner;

/*
 * Student Name: Aaron Thompson
 * Student Number: 041058950
 * Prof: Dr. James Mwangi
 * Assignment 1 - Data Structures
 * Due Date: February 5th 2023
 **/

/**
 * class for fruit items
 * @author Aaron
 *
 */
public class Fruit extends FoodItem{
	/**
	 * stores name of orchard input from user
	 */
	private String orchardName;
	
	/**
	 * no-arg constructor
	 */
	Fruit(){
		
	}
	
	/**
	 * prints the super class toString with an orchard name
	 * @return returns String.format()
	 */
	public String toString() {
		
		return String.format("%s orchard supplier: %s", super.toString(), orchardName);		// call super toString method and format with Fruit class toString
	}
	
	
	/**
	 * calls super class addItem method then asks user for orchard supplier
	 * @param scanner accepts user input
	 * @return true 
	 * 
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		super.addItem(scanner);
		boolean validInput;
		System.out.print("Enter the name of the orchard supplier: ");
		 do {
			try {
				orchardName = scanner.nextLine();
				validInput = true;
			}
			catch(Exception e) {	
				validInput = false;
			}}while(!validInput);
		return true;
	}
	
	
}
