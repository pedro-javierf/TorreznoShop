package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class NPC extends GameEntity {
	private int HP;
	private int money;
	private int xPos;
	private int yPos;
	String message;
	
	Room currentRoom;
	public NPC(int hp, int money, Room startingRoom, int xpos, int posy) {
		super(hp, money, startingRoom, xpos, posy);
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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
