package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class NPC extends GameEntity {
	private int HP;
	private int money;
	private int xPos;
	private int yPos;
	String message;
	String nameString;
	
	Room currentRoom;
	public NPC(String name,int hp, int money, Room startingRoom, int xpos, int posy) {
		super(hp, money, startingRoom, xpos, posy);
		this.nameString= name;
	}
	
	
	public String toString() {
		return " E ";
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}
	
	public String getName() {
		return nameString;
	}


	

}
