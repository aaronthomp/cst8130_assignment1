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
 * Inventory class contains array to store inventory as well as methods to manipulate the array
 * @author Aaron
 *
 */
public class Inventory {
	
	
	 
	
	/**
	 * stores users choice regarding type of food
	 */
	String itemChoice = null;
	/**
	 * stores whether exit status is valid
	 */
	boolean exitStatus;
	/**
	 * stores switch case value for fruit class
	 */
	final String FRUIT = "f";
	/**
	 * stores switch case value for vegetable class
	 */
	final String VEGGIE = "v";
	/**
	 * stores switch case value for preserve class
	 */
	final String PRESERVE = "p"; 
	
	/**
	 * stores number of items allowed in array
	 */
	private int numItems = 20; 
	/**
	 * Instantiation of new array of objects of type FoodItem 
	 */
	FoodItem inventory[] = new FoodItem[numItems];
	
	
	/**
	 * no arg constructor
	 */
	public Inventory() {
		
	}
	
	/**
	 * prints out a to string of what the inventory contains
	 * @return return the super classes toString method
	 */
	public String toString() {
		System.out.println("Inventory:");
		for(int i = 0; i < numItems; i++) {
			if(inventory[i] != null) {
				System.out.println(inventory[i].toString());		// for each item in array iterate through and if not null print it toString
			}
		}
		return super.toString();
	}
	
	/**
	 * checks to see if the item code input from parameter exists already within the array
	 * @param item takes item code from object
	 * @return returns -1 if false otherwise returns index of array
	 */
	public int alreadyExists(FoodItem item) {	
		for(int i = 0; i <= numItems; i++) {						// iterate through array size			
			if(inventory[i] == null) {								// if inventory at i is null return -1
				return -1;
			}
			else if(inventory[i].isEqual(item) == true) { 			// if inventory does contain item code return index value
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * method adds item to child classes based on user inputs
	 * @param scanner takes in user input
	 * @return returns true
	 */
	public boolean addItem(Scanner scanner) {
		int filledSpaces = 0;
		for(int i = 0; i < numItems; i++) {
			if(inventory[i] != null) {
				filledSpaces++;
			}
			else {
				break;
			}
		}
		do {
			
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p): ");
			exitStatus = true;
			itemChoice = scanner.nextLine();
																	// if statement decides whether or not valid child class letter was input
			if(!itemChoice.equalsIgnoreCase(FRUIT) && !itemChoice.equalsIgnoreCase(VEGGIE) && !itemChoice.equalsIgnoreCase(PRESERVE)) {
				exitStatus = false;
				System.out.println("Invalid entry.");
			}
			
			}
			while(exitStatus == false);
			switch(itemChoice) {
			case FRUIT:
				Fruit fruit = new Fruit();
				fruit.inputCode(scanner);
				alreadyExists(fruit);
				if(alreadyExists(fruit) == -1) { 					// validates itemCode variable to continue adding more items
					fruit.addItem(scanner);
					inventory[filledSpaces] = fruit; 
				}
				else {
					System.out.println("Item code already exists.");
				}
				break;
				
			case VEGGIE:
				Vegetable veggie = new Vegetable();
				veggie.inputCode(scanner);
				alreadyExists(veggie);
				if(alreadyExists(veggie) == -1) {					// validates itemCode variable from FoodItem class to continue adding more items
				veggie.addItem(scanner);
				inventory[filledSpaces] = veggie;
				}
				else {
					System.out.println("Item code already exists.");
				}
				break;
				
			case PRESERVE:
				Preserve preserve = new Preserve();
				preserve.inputCode(scanner);
				alreadyExists(preserve);
				if(alreadyExists(preserve) == -1) {					// validates itemCode variable from FoodItem class to continue adding more items
				preserve.addItem(scanner);
				inventory[filledSpaces] = preserve;
				}
				else {
					System.out.println("Item code already exists.");
				}
				break;
			}
			
		return true;
	}
	
	/**
	 * method updates quantity of items from inventory array
	 * @param scanner takes in user input
	 * @param buyOrSell true determines buy false determines sell
	 * @return true 
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		int amount = 0;
		int index = 0;
		FoodItem food = new FoodItem();
		boolean validInput = true;
		
		
			if(inventory[0] == null && buyOrSell == true) {					// if theres no items in array dont allow buy
				System.out.println("Error... could not buy item.");
			}
			else if(inventory[0] == null && buyOrSell == false) {			// if theres no items in array dont allow sell
				System.out.println("Error... could not sell item.");
			}
			else {															// otherwise allow both buy and sell
			
		
		if(buyOrSell == true) {												// start of buy items
			food.inputCode(scanner);
			index = alreadyExists(food);					
			if(index == -1) {												// if alreadyExists method returns negative value item code doesn't exist
				System.out.println("Code not found in inventory...");
				System.out.println("Error... could not buy item.");
			}
			else {															// otherwise allow user input for buy amount
			System.out.print("Enter amount of items you would like to purchase: ");
			do{																// end of do-while on line 210
				try {
			amount = scanner.nextInt();
			validInput = true;
			}
			catch(InputMismatchException e) {								// if exception is caught validInput becomes false looping once more
				System.out.print("Must enter a valid integer or 0 to exit: ");
				validInput = false;
			}
			finally {
				if (amount < 0 && validInput && true) {						// if the amount entered is less than 0 validInput becomes false looping once more
						validInput = false;
						System.out.print("Must enter a positive integer or 0 to exit: ");
					}
				}
				scanner.nextLine();											// clear scanner, makes sure theres no infinite loops
		}while(validInput == false);
			inventory[index].updateItem(amount);							// if all inputs are good exit while loop and update item at index value
			} 
		}																	// end of buy items
			
			
		else {																// start of sell items
			food.inputCode(scanner);
			index = alreadyExists(food);					
			if(index == -1) {												// if index is negative 1 item code does not exist
				System.out.println("Code not found in inventory...");
				System.out.println("Error... could not sell item.");
			}
			else {															// otherwise allow user input for selling items
			System.out.print("Enter amount of items you would like to sell: ");
			do{																// do-while ends on line 242
				try {
			amount = scanner.nextInt();
			validInput = true;
			}
			catch(InputMismatchException e) {								// if exception is caught validInput becomes false looping once more
				System.out.print("Must enter a valid integer or 0 to exit: ");
				validInput = false;
				
			}
			finally {
				if (amount < 0 && validInput == true) {						// if amount is less than 0 validInput becomes false looping once more
						validInput = false;
						System.out.print("Must enter a positive integer or 0 to exit: ");
					}
				}
				scanner.nextLine();											// clears scanner, solves infinite looping issue
		}while(validInput == false);
			
		
			if(inventory[index].updateItem(amount*(-1)) == false) {			// multiply amount by negative number so when adding in update item it takes away from total
				System.out.println("Insufficient stock in inventory...\r\n"	// if update item returns false number was too large to sell stock amount
						+ "Error...could not sell item");
		}
			}
		}
			}
		return true;
	}
	
}
