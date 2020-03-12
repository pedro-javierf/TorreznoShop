package ucm.is2.torreznoshop.spaces;

import java.util.ArrayList;
import java.util.List;

import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.elements.NPC;
import ucm.is2.torreznoshop.elements.Player;

public class Building {

	private List<Room> roomList;
	protected Room currentRoom;
	protected Player player;
	
	public Building(List<Room> rl)
	{
		roomList = rl;
	}

	public void addRoom(Room r)
	{
		roomList.add(r);
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room r)
	{
		currentRoom = r;
	}
	
	public void setPlayer(Player p)
	{
		player = p;
		currentRoom.addEntity(p);
	}
	
	public void initBuilding() {
		// TODO Auto-generated method stub
		
		
		/*SAMPLE BULDING*/
		
		
		
		
		//First room setup parameters
		String habInit = "Habitacion Inicial";
		//First room setup parameters
		String habPas = "Pasillo";
		//First room setup parameters
		String habHall = "Hall principal";
		//First room setup parameters
		String Garden = "Jardin";
		//First room setup parameters
		String habComedor = "Comedor";
		//First room setup parameters
		String habCocina = "Cocina";
		//First room setup parameters
		String habPas2 = "Pasillo de Gerencia";
		
		int size = 3;
		
		
		//FIrstly create the (empty) objects
		Room habitacionInicial = new Room(habInit, null, null, this, size, size);
		Room pasillo = new Room(habPas, null, null, this, size+4, size-1);
		Room hall = new Room(habHall, null, null, this, size+4, size+4);
		Room garden = new Room(Garden, null, null, this, size+3, size+5);
		Room comedor = new Room(habComedor, null, null, this, size+5, size+5);
		Room kitchen = new Room(habCocina, null, null, this, size, size+5);
		Room pasilloaBoss = new Room(habPas2, null, null, this, size+3, size-1);
		
		//Creates one door asigned to these (empty) objects (rooms)
		Door puertaAPasillo = new Door(habitacionInicial, pasillo, 0, 1,false);
		Door puertaAHall = new Door(pasillo, hall, 6, 1,false);
		Door puertaAGarden = new Door(hall, garden, 5, 6,false);
		Door puertaAComedor = new Door(garden, comedor, 3, 0,false);
		Door puertaAComedorporPas = new Door(pasillo, comedor, 3, 1,false);
		Door puertaACocina = new Door(comedor, kitchen, 1, 0,false);
		Door puertaAPasillo2 = new Door(garden, pasilloaBoss, 0, 4,false);
		
		//Create the door now pointing in reverse order
		Door puertaAHabitacion = new Door(pasillo, habitacionInicial, 0, 0,false);
		Door puertaAPasilloReverse = new Door(hall, pasillo, 4, 0,false);
		Door puertaAHallReverse = new Door(garden, hall, 5, 3,false);
		Door puertaAGardenReverse = new Door(comedor, garden, 3, 7,false);
		Door puertaAComedorReverse = new Door(kitchen, comedor, 2, 5,false);
		Door puertaAComedorReversePas = new Door(comedor, pasillo, 7, 3,false);
		Door puertaaGardenReversePas2 = new Door(pasilloaBoss, garden, 2, 0,false);
				
		//Create an empty entity list
		List<GameEntity> l1 = new ArrayList<GameEntity>();
		List<GameEntity> l2 = new ArrayList<GameEntity>();
		List<GameEntity> l3 = new ArrayList<GameEntity>();	
		List<GameEntity> l4 = new ArrayList<GameEntity>();	
		List<GameEntity> l5 = new ArrayList<GameEntity>();	
		List<GameEntity> l6 = new ArrayList<GameEntity>();	
		List<GameEntity> l7 = new ArrayList<GameEntity>();	
		
		//Create entities for rooms
		NPC perroNpc= new NPC("Perrete de incognito",5, 0, habitacionInicial,0,2);
		perroNpc.setMessage("*You hear a metallic jingle* WOOF, WOOF. It is a dog, they do not usually talk");
		l1.add(perroNpc);
		NPC ambrosioNpc = new NPC("Ambrosio", 5, 10, pasillo, 5, 0);
		ambrosioNpc.setMessage("Ambrosio had a tough time in Vietnam. He does not feel like talking...");
		l2.add(ambrosioNpc);
		NPC braulioNpc = new NPC("Braulio", 5, 100, hall, 5, 5);
		braulioNpc.setMessage("If only we could get the key to escape from here..");
		l3.add(braulioNpc);
		
		
		//Put the doors into a door list
		List<Door> habitaInicial = new ArrayList<Door>();
		habitaInicial.add(puertaAPasillo);
		
		List<Door> habitaPas = new ArrayList<Door>();
		habitaPas.add(puertaAHabitacion);
		habitaPas.add(puertaAHall);
		habitaPas.add(puertaAComedorporPas);
		
		List<Door> habitaHall = new ArrayList<Door>();
		habitaHall.add(puertaAPasilloReverse);
		habitaHall.add(puertaAGarden);
		
		List<Door> habitaJardin = new ArrayList<Door>();
		habitaJardin.add(puertaAHallReverse);
		habitaJardin.add(puertaAComedor);
		habitaJardin.add(puertaAPasillo2);
		
		List<Door> habitaComedor = new ArrayList<Door>();
		habitaComedor.add(puertaAGardenReverse);
		habitaComedor.add(puertaACocina);
		habitaComedor.add(puertaAComedorReversePas);
		
		List<Door> habitaCocina = new ArrayList<Door>();
		habitaCocina.add(puertaAComedorReverse);
		
		List<Door> habitaPasillo2 = new ArrayList<Door>();
		habitaPasillo2.add(puertaaGardenReversePas2);
		
		
		
		//Assign to the room its lists
		habitacionInicial.setDoorList(habitaInicial);
		habitacionInicial.setEntityList(l1);
		pasillo.setDoorList(habitaPas);
		pasillo.setEntityList(l2);
		hall.setEntityList(l3);
		hall.setDoorList(habitaHall);
		garden.setDoorList(habitaJardin);
		garden.setEntityList(l4);
		comedor.setDoorList(habitaComedor);
		comedor.setEntityList(l5);
		kitchen.setDoorList(habitaCocina);
		kitchen.setEntityList(l6);
		pasilloaBoss.setDoorList(habitaPasillo2);
		pasilloaBoss.setEntityList(l7);
		
		
		
		
		//Assign messages
		habitacionInicial.setMessage("You are in your room. Cozy, right? Smells like ibuprofeno");
		pasillo.setMessage("Amazing hallway :O . You hear an old radio playing Frank Sinatra...\nSo nostalgic...");
		hall.setMessage("You face a huge hall with sofas \nA really old tv is on playing saber y ganar.\nThe daylight fills the room through the windows. \nJordi Hurtado's smile fills your heart meanwhile...");
		garden.setMessage("You found yourself in garden full of flower pots.\nYou see a bee with the face of Arturo Valls buzzing around.");
		comedor.setMessage("A huge lot of tables stand in front of you.\nThey are covered wiith tableloths with a very poor taste.\nIt smells like deep-fried food and hate for the human race.");
		kitchen.setMessage("Here comes the magic of that smell. \nThere is a box with frozen meat inside.\nIn the box it is written: First quality meat (Stalingrad's Horse Stable, 1945)");
		pasilloaBoss.setMessage("Smells like corrector pen. A dark presence is felt behind the other door");
		//Build the room
		//habitacionInicial = new Room(habInit, habitaInicial, l1, this, size, size);
		
		currentRoom = habitacionInicial;
		
		//Add to the building
		roomList.add(habitacionInicial);

		//////////////////////////////////////////////////////////////////////////

		//Add to the building
		roomList.add(habitacionInicial);
		roomList.add(pasillo);
		roomList.add(hall);
		roomList.add(garden);
		roomList.add(comedor);
		roomList.add(kitchen);
		roomList.add(pasilloaBoss);
		
		
	}
	
}
