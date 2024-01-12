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
 * Assign1 class contains menu and main method
 * @author Aaron
 *
 */
public class Assign1 {

	/**
	 * when called displays menu
	 */
	public void displayMenu() {
		System.out.println("\nPlease select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: To Exit");
		System.out.print(">");
	}
	
	
	/**
	 * contains methods to run program
	 * 
	 * @param args takes in arguments to run
	 */
	public static void main(String[] args) {
		int menuChoice;
		
		Assign1 a1 = new Assign1();
		
		Inventory invent = new Inventory();
		Scanner input = new Scanner(System.in);
		
		
		do {
			menuChoice = 0;
			a1.displayMenu();
			try {
				menuChoice = input.nextInt();
			}
			catch(InputMismatchException e) {
		}
			input.nextLine();
			switch(menuChoice) {
			case 1:
				invent.addItem(input);
				break;
				
			case 2: 
				invent.toString();
				break;
				
			case 3:
				invent.updateQuantity(input, true);
				break;
				
			case 4:
				invent.updateQuantity(input, false);
				break;
				
			case 5:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Please enter an integer between 1-5.");
				break;
				
			}
		}while(menuChoice != 5);
	}
	
}
