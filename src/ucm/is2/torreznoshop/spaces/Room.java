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
	String message;
	
	Room(String name, List<Door> doorLst, List<GameEntity> entityList, Building currentB, int x,int y)
	{
		this.name = name;
		doorList = doorLst;
		
		this.entityList = entityList;
		
		currentBuilding = currentB;
		xSize=x;
		ySize=y;
	}
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setEntityList(List<GameEntity> el)
	{
		this.entityList = el;
	}
	
	public void setDoorList(List<Door> dl)
	{
		this.doorList = dl;
	}
	
	public void addEntity(GameEntity e)
	{
		entityList.add(e);
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<Door> getDoorList()
	{
		//ideally i would return a copy list
		return doorList;
	}
	
	public List<GameEntity> getEntityList()
	{
		//ideally i would return a copy list
		return entityList;
	}
	
	public int getxSize(){return xSize;}
	public int getySize(){return ySize;}
	
}
