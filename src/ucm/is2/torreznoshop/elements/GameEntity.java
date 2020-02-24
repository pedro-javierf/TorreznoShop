package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class GameEntity {
	private int HP;
	private int money;
	private int vitalEnergy;
	
	private int xPos;
	private int yPos;
	private int torreznoCount;
	
	Room currentRoom;
	
	public GameEntity(int hp, int money, Room startingRoom)
	{
		torreznoCount = 0;
		vitalEnergy = 70;
		this.HP=hp;
		this.money=money;
		this.currentRoom = startingRoom;
	}

	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public boolean moveInX(int amount)
	{
		if(xPos + amount >= 0)
		{
			xPos+=amount;
			return true;
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
		return false;
	}
	
	public boolean consume(int torreznoNum)
	{
		if(torreznoNum <= torreznoCount)
		{
			torreznCount-=torreznoNum;
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

	
}
