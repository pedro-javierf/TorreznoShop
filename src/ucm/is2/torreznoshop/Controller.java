package ucm.is2.torreznoshop;

import java.util.Random;
import java.util.Scanner;

public class Controller {

	private Random rand;
	private Store charcuteriaManolo;
	static int turn = 1;
	
	public Controller(Random r, Store s)
	{
		charcuteriaManolo = s;
		rand = r;
	}
	
	public void showTurnInfo()
	{
		System.out.println("Turn: " + turn + " (Out of 8)");
		System.out.println("Balance: " + charcuteriaManolo.get_balance());	
		charcuteriaManolo.showPigs();
	}
	
	public boolean update()
	{
		boolean result = false;
		if(turn == 8) {
			System.out.println("Phew... That was the last client for today");
			System.out.println("It is getting late...");
			System.out.println("Do you want to manage again your store tomorrow? (y/n)");
			Scanner inputScanner = new Scanner(System.in);
			char choice = inputScanner.next().charAt(0);
			if(choice == 'y') {
				turn = 1;
			}
			else {
				result = true;
			}
		}
		else {
			turn++;
		}
		return result;	
	}
	
	public void sell() {
		int torreznos = rand.nextInt(100); 
		int tipo = rand.nextInt(4);
		System.out.println("A new citizen enters your shop!");
		System.out.println("He wants to buy " + torreznos + " of your worldwide "+ Pigtype.toString(tipo) +" torreznos!");
		System.out.println("Wanna sell? y/n");	
		Scanner inputScanner = new Scanner(System.in);
		char choice = inputScanner.next().charAt(0);
		if(choice == 'y') {
			//System.out.println(torreznos + " of the kind " + Pigtype.toString(tipo) + " are requested");	
			charcuteriaManolo.sellTorreznos(torreznos, Pigtype.CLASSIC);
		}
		else {
			System.out.println("Bye then!");	
		}
		
	}
	
	public void buy() {
		Pig pig = new Pig(rand.nextInt(400),rand.nextInt(50),Pigtype.BELLOTA);
		System.out.println("A new farmer enters your shop!");		
		System.out.println("He wants to sell you an awesome pig of price "+pig.get_cost() + " and size "+pig.get_size());
		System.out.println("Wanna buy? y/n");	
		Scanner inputScanner = new Scanner(System.in);
		char choice = inputScanner.next().charAt(0);
		if(choice == 'y') {
			  charcuteriaManolo.buyPig(pig);
		}
		else {
			System.out.println("Bye then!");	
		}
	}
	
	
}
