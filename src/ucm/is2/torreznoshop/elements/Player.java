package ucm.is2.torreznoshop.elements;

import ucm.is2.torreznoshop.spaces.Room;

public class Player extends GameEntity{
	
	private String nameString;
	private boolean hasDoorKey;
	private int attackIdx;
	private int availableTorreznos;
	private int consumedTorreznos;
	
	
	public Player(int hp, int money, Room startingRoom)
		{
			super(hp, money, startingRoom, 0, 0);
			nameString = "Manolo";
			hasDoorKey = false;
			attackIdx = 2;
			availableTorreznos = 0;
			consumedTorreznos = 0;
		}
	
	public String toString() {
		return " P ";
	}
	
	public void setHasDoorKey(boolean value)
	{hasDoorKey=value;}
	
	public String getName() {
		return nameString;
	}
	
	public boolean getHasDoorKey() 
		// TODO Auto-generated method stub
		{return hasDoorKey;}
	
	public int getAttackIdx() {
		return attackIdx;
	}
	
	public void setAttackIdx(int attackIdx) {
		this.attackIdx = attackIdx;
	}
	
	public int getAvailableTorreznos() {
		return availableTorreznos;
	}
	
	public void setAvailableTorreznos(int availableTorreznos) {
		this.availableTorreznos = availableTorreznos;
	}
	
	public int getConsumedTorreznos() {
		return consumedTorreznos;
	}
	
	public void setConsumedTorreznos(int consumedTorreznos) {
		this.consumedTorreznos = consumedTorreznos;
	}
	
	public void consumeTorreznos(int quantity) {
		if(quantity < 0) {
			System.out.println("Don't you try to throw up torreznos...");
		}
		
		else {
			if(availableTorreznos >= quantity) {
				setAvailableTorreznos(getAvailableTorreznos()-quantity);
				setConsumedTorreznos(getConsumedTorreznos()+quantity);
				
				if(quantity > 0 && quantity <= 5) {
					setAttackIdx(getAttackIdx()+2);
				}
				
				else if(quantity > 5 && quantity <= 10) {
					setAttackIdx(getAttackIdx() + 4);
				}
				
				else if(quantity > 10 && quantity <= 15) {
					setAttackIdx(getAttackIdx() + 8);
					setHP(getHP()+1);
				}
				
				else {
					setAttackIdx(getAttackIdx() + 10);
					setHP(getHP()+2);
				}
			}
			
			else {
				System.out.println("You don't have enough torreznos, my friend :(");
			}
		}
	}
	

}


