import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Student Name: Aaron Thompson
 * Student Number: 041058950
 * Prof: Dr. James Mwangi
 * Assignment 1 - Data Structures
 * Due Date: February 5th 2023
 */

/**
 * class for preserve items
 * @author Aaron
 *
 */
public class Preserve extends FoodItem{
	/**
	 * stores jar size input
	 */
	private int jarSize;
	
	/**
	 * no-arg constructor
	 */
	Preserve(){
		
	}
	
	/**
	 * prints the super class toString with jar size
	 * @return returns String.format()
	 */
	public String toString() {
		
		return String.format("%s jar size: %dmL", super.toString(), jarSize);
	}
	
	/**
	 * calls super class addItem method then asks user for jar size
	 * @param scanner accepts user input
	 * @return true 
	 * 
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		super.addItem(scanner);
		boolean validInput = true;
		System.out.print("Enter the size of the jar in millilitres: ");
		 do {
			try {
				jarSize = scanner.nextInt();
				validInput = true;
			}
			catch(InputMismatchException e) {	
				System.out.print("Must enter valid integer: ");
				validInput = false;
				scanner.nextLine();
			}
			finally {
				if(jarSize <= 0 && validInput == true) {
					System.out.print("Cannot enter less than or equal to zero. Enter quantity of item: ");
					validInput = false;
					scanner.nextLine();
				}
			}
		 }while(validInput == false);
		return true;
	}
	
}
