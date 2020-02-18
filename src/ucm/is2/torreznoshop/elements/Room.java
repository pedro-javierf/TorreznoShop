package ucm.is2.torreznoshop.elements;

import java.util.ArrayList;
import java.util.List;

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
