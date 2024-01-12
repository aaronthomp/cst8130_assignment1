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
 * Super class for all produce child classes, contains worker methods
 * 
 * @author Aaron
 *
 */
public class FoodItem {
	/**
	 * instantiating object from Inventory class
	 */
	Inventory inventoryObject = new Inventory();
	/**
	 * stores item code from users input
	 */
	private int itemCode;
	/**
	 * stores item name from users input
	 */
	private String itemName;
	/**
	 * stores item price from users input
	 */
	private float itemPrice;
	/**
	 * stores items quantity from users input
	 */
	private int itemQuantityInStock;
	/**
	 * stores items cost from users input
	 */
	private float itemCost;

	/**
	 * no arg constructor
	 */
	public FoodItem() {

	}

	/**
	 * prints out a formatted statement of items
	 * 
	 * @return formatted variables print statement
	 */
	public String toString() {

		return String.format("Item: %d, %s, %d price: $%.2f cost: $%.2f", itemCode, itemName, itemQuantityInStock,
				itemPrice, itemCost);
	}

	/**
	 * method to check validity of item updates
	 * 
	 * @param amount takes in a quantity to update
	 * @return returns false if amount is not valid otherwise returns true
	 */
	public boolean updateItem(int amount) {

		if (itemQuantityInStock + amount < 0) { 						// check to see if amount entered would result in quantity being less
																		// than 0 return false if true
			return false;
		}
		itemQuantityInStock += amount; 									// otherwise set quantity to quantity plus amount
		return true;
	}

	/**
	 * checks if item codes match within the array
	 * 
	 * @param item takes in item code from FoodItem object
	 * @return returns true if item codes match, false otherwise
	 */
	public boolean isEqual(FoodItem item) {

		if (this.itemCode == item.itemCode) { 							// if item code is equal to the objects item code return true otherwise
																		// its false
			return true;
		}

		return false;
	}

	/**
	 * prompts user for input to populate the inventory array
	 * 
	 * @param scanner takes user input
	 * @return true
	 */
	public boolean addItem(Scanner scanner) {
		boolean validInput = true;

		System.out.print("Enter the name for the item: "); 				// ask for user input
		do { 															// end of do-while on line 111
			try {														
				itemName = scanner.nextLine();							// accept user input
				validInput = true;										// set validInput to true
			} catch (Exception e) {
				validInput = false;										// if exception is caught validInput becomes false
			}
		} while (validInput == false);									// repeat while validInput is false

		System.out.print("Enter the quantity for the item: ");			// all other user inputs in addItem work the same as above comments
		do {
			try {
				itemQuantityInStock = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.print("Please enter a valid integer: ");
				validInput = false;
				scanner.nextLine();
			} finally {
				if (itemQuantityInStock <= 0 && validInput == true) {
					System.out.print("Cannot enter less than or equal to zero quantity. Enter quantity of item: ");
					validInput = false;
					scanner.nextLine();									// clear scanner, otherwise infinite loop
				}
			}

		} while (validInput == false);
		scanner.nextLine();

		System.out.print("Enter the cost of the item: ");
		do {
			try {
				itemCost = scanner.nextFloat();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.print("Please enter a valid number: ");
				validInput = false;
				scanner.nextLine();
			} finally {
				if (itemCost <= 0 && validInput == true) {
					System.out.print("Cost of item cannot be less than or equal to zero. Enter cost of item: ");
					validInput = false;
					scanner.nextLine();
				}
			}
		} while (validInput == false);
		scanner.nextLine();

		System.out.print("Enter the sales price of the item: ");
		do {
			try {
				itemPrice = scanner.nextFloat();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.print("Please enter a valid number: ");
				validInput = false;
				scanner.nextLine();
			} finally {
				if (itemPrice <= 0 && validInput == true) {
					System.out.print(
							"Price of item cannot be less than or equal to zero, unless you fancy going out of business. Enter sales price of item: ");
					validInput = false;
					scanner.nextLine();
				}
			}
		} while (validInput == false);
		scanner.nextLine();
		return true;
	}

	/**
	 * takes user input for itemCode variable
	 * 
	 * @param scanner used for user input
	 * @return true unless input mismatch exceptions
	 */
	public boolean inputCode(Scanner scanner) {								// works the same as addItem user inputs
		boolean validInput;
		itemCode = 0;
		System.out.print("Enter item code: ");
		do {
			try {
				itemCode = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.print("Please enter a valid integer: ");
				validInput = false;
				scanner.nextLine();
			}
		} while (validInput == false);
		scanner.nextLine();

		return true;
	}

}
