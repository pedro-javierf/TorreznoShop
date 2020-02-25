package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class Player extends GameEntity{


public Player(int hp, int money, Room startingRoom)
	{
		super(hp, money, startingRoom, 2, 1);
	}


}
