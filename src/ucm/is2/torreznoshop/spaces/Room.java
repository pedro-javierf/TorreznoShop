package ucm.is2.torreznoshop.spaces;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import ucm.is2.torreznoshop.elements.GameEntity;

public class Room {

	private String name;
	private List<Door> doorList;
	private List<GameEntity> entityList;
	private Building currentBuilding;
	
	Room(String name, List<Door> doorLst, Building currentB)
	{
		this.name = name;
		doorList = doorLst;
		entityList = new ArrayList<GameEntity>();
		currentBuilding = currentB;
	}
	
}
