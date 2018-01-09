package Program1;
import java.util.*;
/**
 * This program tests the vendingMachine. The keypad
 * reports the user input through the keypad
 * @author Sean Grenfell
 * @version September 30, 2017 V1.0
 *
 */
public class VendingMachineTester {
	public static void main(String[] args) 
	{
		String f = "snack";
		double cv = 0.0;
		Scanner scan = new Scanner(System.in);
		keypad p = new keypad(scan);
		snacks s = new snacks(f);
		coins c = new coins(cv);
		vendingMachine vm = new vendingMachine(p,s,c);
		p.run(vm);
	}
}
