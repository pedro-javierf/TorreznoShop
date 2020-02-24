package ucm.is2.torreznoshop.spaces;

import java.util.ArrayList;
import java.util.List;

import ucm.is2.torreznoshop.elements.GameEntity;
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
		
		int size = 3;
		
		//FIrstly create the (empty) objects
		Room habitacionInicial = new Room(habInit, null, null, this, size, size);
		Room pasillo = new Room(habPas, null, null, this, size+4, size-1);
		
		//Creates one door asigned to these (empty) objects (rooms)
		Door puertaAPasillo = new Door(habitacionInicial, pasillo, 0, 1);
				
		//Create an empty entity list
		List<GameEntity> l1 = new ArrayList<GameEntity>();
				
		
		
		
		//Put the doors into a door list
		List<Door> habitaInicial = new ArrayList<Door>();
		habitaInicial.add(puertaAPasillo);
		
		
		//Assign to the room its lists
		habitacionInicial.setDoorList(habitaInicial);
		habitacionInicial.setEntityList(l1);
		
		
		
		
		
		
		
		
		//Build the room
		//habitacionInicial = new Room(habInit, habitaInicial, l1, this, size, size);
		
		currentRoom = habitacionInicial;
		
		//Add to the building
		roomList.add(habitacionInicial);

		//////////////////////////////////////////////////////////////////////////
		
		
		
		//Create the door now pointing in reverse order
		Door puertaAHabitacion = new Door(pasillo, habitacionInicial, 0, 0);
		
		//Create an empty entity list
		List<GameEntity> l2 = new ArrayList<GameEntity>();
		
		//Put the doors into a door list
		List<Door> habitaPas = new ArrayList<Door>();
		habitaPas.add(puertaAHabitacion);
		
		//Assign to the room its lists
		pasillo.setDoorList(habitaPas);
		pasillo.setEntityList(l2);
		
		//Add to the building
		roomList.add(habitacionInicial);
		
		
	}
	
}
