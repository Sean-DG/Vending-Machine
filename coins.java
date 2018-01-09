/**
 * Coins inserted and used by vendingMachine
 */
public class coins 
{
	private double coinValue;
	
	/**
	 * Construct a coin object
	 * @param coin the coin and value received
	 */
	public coins(double coin)
	{
		coinValue = coin;
	}
	/**
	 * Get the coin payed
	 * @return coin
	 */
	public double getCoin(String payment) 
	{
		double coinValue = 0.0;
		
		if(payment.equals(".25") || payment.equals("quarter"))
			coinValue = .25;
		else if(payment.equals(".10") || payment.equals("dime"))
			coinValue = .10;
		else if(payment.equals(".05") || payment.equals("nickel"))
			coinValue = .05;
		else if(payment.equals(".01") || payment.equals("penny"))
			coinValue = .01;
		return coinValue;
	}
}
