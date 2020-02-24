package ucm.is2.torreznoshop;

import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.elements.Store;
import ucm.is2.torreznoshop.spaces.Room;
//import ucm.is2.torreznoshop.utilities.Pig;
import ucm.is2.torreznoshop.utilities.Pigtype;
import ucm.is2.torreznoshop.utilities.Texts;

public class Controller {

	private boolean bossDefeated;
	private boolean exit;
	private Random rand;
	private Store myInternalCharcutero;
	static int turn = 1;
	private Room currentRoom;
	private GameEntity player = new GameEntity(10, 500, currentRoom);
	
	public Controller(Random r,  GameEntity e)
	{
		player = e;
		rand = r;
		bossDefeated = false;
		exit = false;
	}
	
	public void drawGame()
	{
		for(int i = 0; i <= currentRoom.getxSize(); i++)
		{
			for(int j = 0; i <= currentRoom.getySize(); j++)
			{
				System.out.println("");
			}
		}
	}
	
	public void getInput()
	{
		System.out.println(Texts.MENU);
		
		Scanner inputScanner = new Scanner(System.in);
		int choice = inputScanner.nextInt();
		
		switch(choice)
		{
		case(1):
			
		case(2):
			//suadad
		case(3):
			//ahudgasuida
		case(4):
			exit = true;
			break;
		}
	}
	
	public void showTurnInfo()
	{
		System.out.println("Turn: " + turn);
		System.out.println("Balance: " + player.getMoney());	
		System.out.println("Health (Out of 10): " + player.getHP());	
	}
	
	public boolean update()
	{
		boolean result = false;
		if(bossDefeated) {
			System.out.println("Phew... take that b*tch");
			System.out.println("It is getting late...");
			System.out.println("The torreznos are safe. Should I leave the asylum yet? (y/n)");
			
			Scanner inputScanner = new Scanner(System.in);
			char choice = inputScanner.next().charAt(0);
			
			if(choice == 'y') {
				turn = 1;
			}
			else {
				result = true;
			}
		}
		else if(exit)
		{
			System.out.println("The torreznos are safe. Should I leave the game? (y/n)");
			
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
		System.out.println("A new elder stablishes conversation with you!");
		System.out.println("He wants to buy " + torreznos + " of your worldwide "+ Pigtype.toString(tipo) +" torreznos!");
		System.out.println("Wanna sell? y/n");	
		Scanner inputScanner = new Scanner(System.in);
		char choice = inputScanner.next().charAt(0);
		if(choice == 'y') {
			//System.out.println(torreznos + " of the kind " + Pigtype.toString(tipo) + " are requested");	
			myInternalCharcutero.sellTorreznos(torreznos, Pigtype.CLASSIC);
		}
		else {
			System.out.println("Bye then!");	
		}
		
	}

	public void buy() {
//		Pig pig = new Pig(rand.nextInt(400),rand.nextInt(50),Pigtype.values()[rand.nextInt(3)]);
//		System.out.println("A new elder stablishes conversation with you!");		
//		System.out.println("He wants to sell you an awesome pig of price "+pig.get_cost() + " and size "+pig.get_size());
//		System.out.println("Wanna buy? y/n");	
//		Scanner inputScanner = new Scanner(System.in);
//		char choice = inputScanner.next().charAt(0);
//		if(choice == 'y') {
//			myInternalCharcutero.buyPig(pig);
//		}
//		else {
//			System.out.println("Bye then!");	
//		}
	}
	
	
}
