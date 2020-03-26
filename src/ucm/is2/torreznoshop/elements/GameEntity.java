package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class GameEntity {
	private int HP;
	private int money;
	private int attackIdx;
	private int xPos;
	private int yPos;
	private int torreznoCount;
	String nameString;
	Room currentRoom;
	private String message;
	private String loreMessage;
	private String finalMessage;
	private boolean haveTorreznos;
	
	public GameEntity(int hp, int money, int attackIdx, Room startingRoom, int startingY, int startingX, boolean haveTorreznos)
	{
		torreznoCount = 0;
		this.attackIdx = attackIdx;
		
		xPos = startingX;
		yPos = startingY;
		
		this.HP=hp;
		this.money=money;
		this.currentRoom = startingRoom;
		this.haveTorreznos = haveTorreznos;
	}

	public void attack(GameEntity e) {
		e.setHP(e.getHP() - attackIdx);
	}
	
	
	
	
	public int getTorreznoCount() {
		return torreznoCount;
	}

	public void setTorreznoCount(int torreznoCount) {
		this.torreznoCount = torreznoCount;
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
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	



	public String getLoreMessage() {
		return loreMessage;
	}


	public void setLoreMessage(String loreMessage) {
		this.loreMessage = loreMessage;
	}


	public String getFinalMessage() {
		return finalMessage;
	}


	public void setFinalMessage(String finalMessage) {
		this.finalMessage = finalMessage;
	}

	public int getAttackIdx() {
		return attackIdx;
	}

	public void setAttackIdx(int attackIdx) {
		this.attackIdx = attackIdx;
	}

	public boolean HaveTorreznos() {
		return haveTorreznos && torreznoCount > 0;
	}

	public void setHaveTorreznos(boolean haveTorreznos) {
		this.haveTorreznos = haveTorreznos;
	}

	
	
	
	
	

	
}
