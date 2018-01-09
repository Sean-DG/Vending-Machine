package Program1;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 * the mediary between the keypad "user" and its inventory
 */
public class vendingMachine {
	
	private Scanner scan = new Scanner(System.in);
	private snacks item;
	private coins coin;
	private keypad userInterface;
	private String passcode = "12132";
	private String snackChoice;
	
	private boolean access;
	private boolean notPayed;
	private boolean running;
	private boolean quit;
	
	private double cost = 0.0;
	private double moneyInMachine = 0.0;
	private double balance;
	private double payedSoFar;
	
	private NumberFormat form = new DecimalFormat("#0.00");
	
	/**
	 * constructor for vendingMachine
	 * @param p,s,c
	 */
	public vendingMachine(keypad p, snacks s, coins c) 
	{
		userInterface = p;
		item = s;
		coin = c;
	}
	/**
	 * runs the order of operations for the entire system
	 * @param input input received from the user
	 */
	public void start(String input) 
	{
		snackChoice = input;
		running = true;
		
		checkInput(snackChoice);
		cost = item.getPrice(snackChoice);
		checkItem(snackChoice);
		
		if (running) 
		{
			pay(cost);
			deliverSnack(snackChoice);
			running = false;
		}
		
		return;
	}	
	/**
	 * checks the input to see if it is a passcode if a passcode has been entered it restocks all the snacks
	 * and gives the operator all the money contained in the machine. Then checks if a selection had been made
	 * if a selection had been made then it sends it off to retrieve the snack and the price
	 * @param _input
	 */
	public void checkInput(String _input) 
	{
		String input = _input;
		
		if((access = passcode(input)) == true) 
		{
			item.setSnackRemain();
			userInterface.display("\n\n\nPasscode accepted.\n");
			userInterface.display("You have retrieved $" + form.format(moneyInMachine) + "\n");
			userInterface.display("Machine has been refilled.\n\n\n");
			moneyInMachine = 0.0;
			running = false;
		}
		else if(input.length() <= 0) 
		{
			running = false;
		}
		else if(input.equals("Q") || input.equals("q")) {
			running = false;
		}
		else if(input.equals("1") || input.equals("2") || input.equals("3"))
		{
			return;
		}
		else
			running = false;
		
		return;
			
	}
	/**
	 * checks to see if the item is still available
	 * @param input
	 */
	public void checkItem(String _input) 
	{
		String input = _input;
		
			if(item.snackRemain(input) < 1) 
			{
				userInterface.display("\nOut of stock.\n");
				running = false;
			}
			else if (input.equals("1")) 
			{
				userInterface.display("\nYou have selected Candy Bar!\n");
			}
			else if (input.equals("2")) 
			{
				userInterface.display("\nYou have selected Chips!\n");
			}
			else if (input.equals("3")) 
			{
				userInterface.display("\nYou have selected Cookie!\n");
			}
	}
	/**
	 * ejects any money that may have been payed up to this point
	 * @param payedSoFar the value of the coins that have been inserted up to this point
	 */
	public void eject(double payedSoFar) 
	{
		userInterface.display("\n\nPlease take your change: $" + form.format(payedSoFar) + "\n");
	}
	/**
	 * pays any money given reducing the balance owed by the coins value
	 * @param cost
	 */
	public void pay(double cost) 
	{
		notPayed = true;
		balance = cost;
		
		while(notPayed) 
		{
			payMessage(balance);
			
			String payment = scan.nextLine();
			
			if(payment.equals("Q") || payment.equals("q")) 
			{
				eject(payedSoFar);
				moneyInMachine -= payedSoFar;
				payedSoFar = 0.0;
				notPayed = false;
				running = false;
				
			}
			else if(payment.equals(".25") || payment.equals(".10") || payment.equals(".05") || payment.equals(".01") 
					|| payment.equals("quarter") || payment.equals("dime") || payment.equals("nickel") || payment.equals("penny"))
				
			{
				balance -= coin.getCoin(payment);
				moneyInMachine += coin.getCoin(payment);
				payedSoFar +=coin.getCoin(payment);
				
				if(balance < 0.00)
				{
					payedSoFar -= cost;
					moneyInMachine -= payedSoFar;
					eject(payedSoFar);
					notPayed = false;
					payedSoFar = 0.0;
				}
				else if(balance == 0.00) 
				{
					notPayed = false;
					payedSoFar = 0.0;
				}
			}
			else
				payMessage(balance);
		}
	}
	/**
	 * sends the snack to the customer through the snack tray
	 * @param input
	 */
	public void deliverSnack(String input) 
	{
		String snack = item.getSnack(input);	
		userInterface.display("\nEnjoy your " + snack + " have a nice day!\n\n");
	}
	/**
	 * displays a message about the coins that can be used to pay
	 * @param balance balance represents how much the user still owes
	 */
	public void payMessage(double balance) 
	{
		userInterface.display("\nInsert: $.25, $.10, $.05, $.01\n" + "Balance: $" + form.format(balance) + ": ");
	}
	/**
	 * check to see if the passcode entered is correct
	 * @param _passcode
	 * @return access
	 */
	public boolean passcode(String _passcode) 
	{
		if(passcode.equals(_passcode))
			access = true;
		else
			access = false;
		return access;
	}
}
