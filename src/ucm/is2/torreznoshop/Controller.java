package ucm.is2.torreznoshop;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import ucm.is2.torreznoshop.elements.Player;
import ucm.is2.torreznoshop.elements.Boss;
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
	private boolean interactDog1 = false;
	private boolean interactDog2 = false;
	private boolean interactBraulio = false;
	private Random rand;
	private Store myInternalCharcutero;
	static int turn = 1;
	
	private Building currentBuilding;
	
	private Player player;
	
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
		//System.out.println("  0   1   2   3   4   5   6   7   8  ...");
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
		List<GameEntity> entities = currentBuilding.getCurrentRoom().getEntityList();
		Scanner inputScanner = new Scanner(System.in);
		int choice = inputScanner.nextInt();
		boolean interacted = false;
		switch(choice){
		
		case(1)://move
			if(!askUserMove())
				{System.out.println("you can/t move theree my brudah");}
			break;
			
		case(2)://interact
			
			for(GameEntity e : entities) {
				if(canInteract(e)) {
					interact(e);
					interacted = true;
				}
			}
		
			if(!interacted) {
				interactProto();
			}
		
			break;
		
		case(3)://consume torrezno
			System.out.println("How many torreznos will you have? ");
			Scanner torreznoScanner = new Scanner(System.in);
			int torreznoNum = torreznoScanner.nextInt();
			player.consumeTorreznos(torreznoNum);
			break;
			
		case(4):
			exit = true;
			break;
		}
	}
	
	public void interactProto() {
		System.out.println("Room info: ");
		System.out.println(currentBuilding.getCurrentRoom().getMessage());
		System.out.println();
		System.out.println("Entities in this room: ");
		for(GameEntity g : currentBuilding.getCurrentRoom().getEntityList()) {
			if(g.getName() == player.getName()) {
				System.out.println("You (Manolo) are present in coordinates " + g.getX() + " " + g.getY());
			}
			else {
			System.out.println(g.getName()+ " is present in coordinates " + g.getX() + " " + g.getY());
			}
		}
	}
	
	public void interact(GameEntity e) {
		if(e.getName().equalsIgnoreCase("Obviosly not a dog (dog)")) {
			if(!interactDog1 && !interactDog2 && !interactBraulio) {
				System.out.println(e.getMessage());
				interactDog1 = true;
			}
			
			else if(interactDog1 && interactBraulio && !interactDog2) {
				System.out.println(e.getLoreMessage());
				System.out.println("You received a very strange key...");
				player.setHasDoorKey(true);
				interactDog2 = true;
			}
			
			else {
				System.out.println(e.getFinalMessage());
			}
		}
		
		else if(e.getName().equalsIgnoreCase("Braulio")) {
			if(!interactBraulio) {
				System.out.println(e.getMessage());
				interactBraulio = true;
			}
			
			else {
				System.out.println(e.getLoreMessage());
			}
		}
		
		else if(e.getName().equalsIgnoreCase("Pilar")) {
			Scanner choiceScanner = new Scanner(System.in);
			System.out.println("BOSS FIGHT!");
			System.out.println("What will you do?");
			System.out.println("(fight/flee)");
			String choice = choiceScanner.next();
			if(choice.equalsIgnoreCase("fight")) {
				System.out.println("READY TO FIGHT, READY TO DIE! \n(Megalovania intensifies)");
				fightBoss(e);
			}
			
			else {
				System.out.println("You choose to walk away by now...");
			}
		}
		
		else {
			System.out.println(e.getMessage());
		}
	}
	
	private void fightBoss(GameEntity boss) {
		int i = 0;
		while(player.getHP() > 0 && boss.getHP() > 0) {
			if(i % 2 == 0) {
				System.out.println("You attacked with a strength of: " + player.getAttackIdx());
				player.attack(boss);
			}
			
			else {
				System.out.println(boss.getName() + " attacked back!");
				boss.attack(player);
			}
			i++;
		}
	}
	
	private void fightMenu() {
		System.out.println("What will you do now? ");
		System.out.println("1. Attack");
		System.out.println("2. Consume torreznos " + "(You have "+ player.getAvailableTorreznos()+ " torreznos)");
		System.out.println("3. Flee");
	}
	
	private boolean canInteract(GameEntity e) {
		boolean b1 = player.getX() == e.getX()-1 && player.getY() == e.getY();
		boolean b2 = player.getX() == e.getX()+1 && player.getY() == e.getY();
		boolean b3 = player.getX() == e.getX() && player.getY() == e.getY()+1;
		boolean b4 = player.getX() == e.getX() && player.getY() == e.getY()-1;
		return b1 || b2 || b3 || b4;
	}


	public void showTurnInfo()
	{
		System.out.println("Turn: " + turn);
		System.out.println("Balance: " + player.getMoney());	
		System.out.println("Health (Out of 10): " + player.getHP());	
		System.out.println("Available torreznos: " + player.getAvailableTorreznos());
		System.out.println("Consumed torreznos: " + player.getConsumedTorreznos());
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
					if(d.isLocked() && !player.getHasDoorKey())
					{
						System.out.println("You need a key for traversing this door...");
					}
					
					else {
						System.out.println("Do you want to traverse this magic portal? (It's a normal door)\nYou would go from "+ currentBuilding.getCurrentRoom().getName() + " to "+ d.getNextRoom().getName()+ "\n(y/n)");
						Scanner inputScanner = new Scanner(System.in);
						char choice = inputScanner.next().charAt(0);
						
						if(choice == 'y') {
							player.setxPos(0);
							player.setyPos(0);
							//We are in a door! go to the next room
							currentBuilding.setCurrentRoom(d.getNextRoom());
							//player.setRoom(d.getNextRoom());
							currentBuilding.getCurrentRoom().addEntity(player);
							System.out.println("ROOM SWAP! Exiting "+ d.getCurrentRoom().getName() +" and Entering " + d.getNextRoom().getName() );
						}
						else {
							System.out.println("Nothing happened here...");
						}
					}
					
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
