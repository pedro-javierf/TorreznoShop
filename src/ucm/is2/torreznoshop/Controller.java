package ucm.is2.torreznoshop;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import ucm.is2.torreznoshop.elements.Player;
import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.elements.Store;
import ucm.is2.torreznoshop.spaces.Building;
import ucm.is2.torreznoshop.spaces.Door;
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
	
	private Building currentBuilding;
	
	private GameEntity player;
	
	public Controller(Random r,  Player mainPlayer, Building initialBuilding)
	{
		currentBuilding = initialBuilding;
		player = mainPlayer;
		rand = r;
		
		bossDefeated = false;
		exit = false;
		
		//Init the rooms and so on
		currentBuilding.initBuilding();
		currentBuilding.setPlayer(mainPlayer);
	}
	

	
	public void drawGame()
	{
		List<Door> doors = currentBuilding.getCurrentRoom().getDoorList();
		List<GameEntity> entities = currentBuilding.getCurrentRoom().getEntityList();
		
		String c;
		
		String DASHES = new String(new char[(currentBuilding.getCurrentRoom().getySize()*4)+1]).replace("\0", "-");
		
		System.out.println(currentBuilding.getCurrentRoom().getName());
		System.out.println(currentBuilding.getCurrentRoom().getMessage());
		System.out.println("  0   1   2   3   4   5   6   7   8  ...");
		System.out.println(DASHES);
		for(int i = 0; i < currentBuilding.getCurrentRoom().getxSize(); i++)
		{
			for(int j = 0; j < currentBuilding.getCurrentRoom().getySize(); j++)
			{
				//how the hell do i do this efficiently
				c = "   ";
				for(Door d: doors)
				{
					if(d.getXpos()==i && d.getYpos()==j)
					{
						c= " D ";
					}
				}
				
				for(GameEntity g: entities)
				{
					if(g.getY()==i && g.getX()==j)
					{
						c= g.toString(); //better, c = g.toString() to diferentiate between player and NPCs for example
					}
				}


				System.out.print("|"+c); //add hatever entity or door is here
			}
			System.out.println("|");
			System.out.println(DASHES);
		}
	}
	
	boolean consumeTorreznos()
	{
		System.out.println("how many torreznos you want to consume: ");
		Scanner inputScanner = new Scanner(System.in);
		int num = inputScanner.nextInt();	
		return(player.consume(num));
	}
	
	boolean askUserMove()
	{
		System.out.println("how many x: ");
		Scanner inputScanner = new Scanner(System.in);
		int x = inputScanner.nextInt();	
		if(x + player.getX() > currentBuilding.getCurrentRoom().getySize() || x + player.getX() < 0) {
			return false;
		}
		System.out.println("how many y: ");
		int y = inputScanner.nextInt();	
		if(y + player.getY() > currentBuilding.getCurrentRoom().getxSize() || y + player.getY() < 0) {
			return false;
		}
		//feo y malo d cojone
		return(player.moveInX(x) && player.moveInY(y));
	}
	
	public void getInput()
	{
		System.out.println(Texts.MENU);
		
		Scanner inputScanner = new Scanner(System.in);
		int choice = inputScanner.nextInt();
		
		switch(choice)
		{
		case(1)://move
			if(askUserMove())
				{System.out.println("success");}
			else
				{System.out.println("you can/t move theree my brudah");}
			break;
		case(2)://interact
			System.out.println("NOT YET IMPLEMENTED");
			break;
		case(3)://consume torrezno
			if(consumeTorreznos())
				{System.out.println("success");}
			else
				{System.out.println("you don-t have so many torreznos bro");}
			break;
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
	
	protected void updateInteractions()
	{
		List<Door> doors = currentBuilding.getCurrentRoom().getDoorList();
		List<GameEntity> entities = currentBuilding.getCurrentRoom().getEntityList();
		
		

		for(Door d: doors)
		{
			for(GameEntity g: entities)
			{
				if(g.getY()==d.getXpos() && g.getX()==d.getYpos())
				{
					//We are in a door! go to the next room
					currentBuilding.setCurrentRoom(d.getNextRoom());
					//player.setRoom(d.getNextRoom());
					currentBuilding.getCurrentRoom().addEntity(player);
					
					System.out.println("ROOM SWAP! Exiting "+ d.getCurrentRoom().getName() +" and Entering " + d.getNextRoom().getName() );
				}
			}
		}
				
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
				result = true;
			}
			else {
				turn = 1;
			}
		}
		else if(exit)
		{
			System.out.println("The torreznos are safe. Should I leave the game? (y/n)");
			
			Scanner inputScanner = new Scanner(System.in);
			char choice = inputScanner.next().charAt(0);
			
			if(choice == 'y') {
				result = true;
			}
		}
		else {
			updateInteractions();
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
