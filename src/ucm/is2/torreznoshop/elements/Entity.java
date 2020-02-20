package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class Entity {

	private int HP;
	private int money;
	
	Room currentRoom;
	
	Entity(int hp, int money, Room startingRoom)
	{
		this.HP=hp;
		this.money=money;
		this.currentRoom = startingRoom;
	}
	
}
