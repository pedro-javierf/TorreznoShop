package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class GameEntity {
	private int HP;
	private int money;
	private int vitalEnergy;
	
	private int xPos;
	private int yPos;
	private int torreznoCount;
	String nameString;
	
	Room currentRoom;
	
	public GameEntity(int hp, int money, Room startingRoom, int startingY, int startingX)
	{
		torreznoCount = 0;
		vitalEnergy = 70;
		
		xPos = startingX;
		yPos = startingY;
		
		this.HP=hp;
		this.money=money;
		this.currentRoom = startingRoom;
	}

	public void setRoom(Room r)
	{
		currentRoom = r;
	}
	
	public Room getRoom()
	{
		return currentRoom;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public String getName()
	{
		return nameString;
	}
	
	
	public boolean moveInX(int amount)
	{
		if(xPos + amount >= 0)
		{
			xPos+=amount;
			return true;
		}
		
		else {
			System.out.println("Bruh, you tried to go through walls (X axis). Put down the medication");
			xPos = xPos + 0;
		}
		return false;
	}
	
	public boolean moveInY(int amount)
	{
		if(yPos + amount >= 0)
		{
			yPos+=amount;
			return true;
		}
		
		else {
			System.out.println("Bruh, you tried to go through walls (Y axis). Put down the medication");
			yPos = yPos + 0;
		}
		return false;
	}
	
	public boolean consume(int torreznoNum)
	{
		if(torreznoNum <= torreznoCount)
		{
			torreznoCount-=torreznoNum;
			return true;
		}
		return false;
	}
		
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}



	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public String toString() {
		return " E ";
	}

	
}
