package ucm.is2.torreznoshop.spaces;

import java.util.ArrayList;
import java.util.List;

import ucm.is2.torreznoshop.elements.Entity;

public class Room {

	private List<Door> doorList;
	private List<Entity> entityList;
	private Building currentBuilding;
	
	Room(List<Door> doorLst, Building currentB)
	{
		doorList = doorLst;
		entityList = new ArrayList<Entity>();
		currentBuilding = currentB;
	}
	
}
