package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class Player extends GameEntity{

String nameString;
public Player(int hp, int money, Room startingRoom)
	{
		super(hp, money, startingRoom, 1, 0);
		nameString = "Manolo";
	}

public String toString() {
	return " P ";
}

public String getName() {
	return nameString;
}
}
