package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class Player extends GameEntity{

String nameString;
boolean hasDoorKey;

public Player(int hp, int money, Room startingRoom)
	{
		super(hp, money, startingRoom, 0, 0);
		nameString = "Manolo";
		hasDoorKey = false;
	}

public String toString() {
	return " P ";
}

public boolean getHasDoorKey()
{return hasDoorKey;}

public void setHasDoorKey(boolean value)
{hasDoorKey=value;}

public String getName() {
	return nameString;
}
}
