package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class GameEntity {
	private int HP;
	private int money;
	
	Room currentRoom;
	
	public GameEntity(int hp, int money, Room startingRoom)
	{
		this.HP=hp;
		this.money=money;
		this.currentRoom = startingRoom;
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
