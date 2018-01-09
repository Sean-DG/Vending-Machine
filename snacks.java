/**
 * Snacks contained in the vending machine
 */
public class snacks {
	
	private int candyBarRemain = 5;
	private int chipsRemain = 5;
	private int cookieRemain = 5;
	
	private static final int candyBar = 1;
	private static final int chips = 2;
	private static final int cookie = 3;
	
	private double candyBarPrice = .75;
	private double chipsPrice = .50;
	private double cookiePrice = 1.15;
	private String snack;
	/**
	 * Constructs snack 
	 * @param _snack
	 */
	public snacks(String _snack) 
	{
		snack = _snack;
	}
	/**
	 * retrieves the desired snack and removes it from the machine
	 * @param _snack
	 * @return snack
	 */
	public String getSnack(String _snack)
	{
		String snack = _snack;
		if(snack.equals("1")) {
			snack = "Candy Bar";
			candyBarRemain--;
		}else if(snack.equals("2")){
			snack = "Chips";
			chipsRemain--;
		}else if(snack.equals("3")) {
			snack = "Cookie";
			cookieRemain--;
		}
		return snack;
	}
	/**
	 * gets the price of the desired snack
	 * @param input
	 * @return cost -returns the cost of the snack described
	 */
	public double getPrice(String input) 
	{
		String snack = input;
		double cost = 0.0;
		
		if(snack.equals("1")) {
			cost = candyBarPrice;
		}else if(snack.equals("2")) {
			cost = chipsPrice;
		}else if(snack.equals("3"))
			cost = cookiePrice;
		return cost;
	}
	/**
	 * checks to see how many snacks are left
	 * @param input
	 * @return remain
	 */
	public int snackRemain(String input) 
	{
		int remain = 99;
		String thisSnack = input;
		
		if(thisSnack.equals("1"))
			remain = candyBarRemain;
		else if(thisSnack.equals("2"))
			remain = chipsRemain;
		else if(thisSnack.equals("3")) 
			remain = cookieRemain;
		
			return remain;
	}
	/**
	 * refills the machine
	 */
	public void setSnackRemain() 
	{
		candyBarRemain = 5;
		chipsRemain = 5;
		cookieRemain = 5;
	}
}
