import java.util.Scanner;
/**
 * A keypad that takes input from the user and displays useful information
 */
public class keypad {
	private Scanner scan;
	
	/**
	 * Construct a keypad object
	 * @param _Scanner that reads text from the user
	 */
	public keypad(Scanner _Scanner) 
	{
		scan = _Scanner;
	}
	/**
	 * Displays a message to the user
	 * @param output what the display will show to the user
	 */
	public void display(String output) 
	{
		System.out.print(output);
	}
	/**
	 * is always on and waiting for user input passes input to vending machine0
	 * @param vm 
	 */
	public void run(vendingMachine vm) 
	{
		boolean active = true;
		
		while(active) {
			greeting();
			String input = scan.nextLine();
			
				vm.start(input);
		}
	}
	/**
	 * Displays the greeting to the user before and after use
	 */
	public void greeting() 
	{
		display("\nPress 1 for Candy Bar\nPress 2 for Chips\nPress 3 for Cookie\nPress Q to quit\n");
		display("Please enter selection: ");
	}
}
