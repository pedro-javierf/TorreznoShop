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
	private int xSize;
	private int ySize;
	
	Room(String name, List<Door> doorLst, Building currentB,int x,int y)
	{
		this.name = name;
		doorList = doorLst;
		entityList = new ArrayList<GameEntity>();
		currentBuilding = currentB;
		xSize=x;
		ySize=y;
	}
	
	public List<Door> getDoorList()
	{
		//ideally i would return a copy list
		return doorList;
	}
	
	public List<Door> getEntityList()
	{
		//ideally i would return a copy list
		return entityList;
	}
	
	public int getxSize(){return xSize;}
	public int getySize(){return ySize;}
	
}
