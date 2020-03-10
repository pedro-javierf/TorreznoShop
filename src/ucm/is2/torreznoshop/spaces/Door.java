package ucm.is2.torreznoshop.spaces;

import java.util.Scanner;

public class Door {

	private Room room1ref;
	private Room room2ref;
	
	private boolean locked;
	
	private int xPos;
	private int yPos;
	
	
	Door(Room r1, Room r2, int x, int y, boolean lock)
	{
		xPos = x;
		yPos = y;
		room1ref = r1;
		room2ref = r2;
		locked = lock;
	}
	
	public int getXpos() {
		return xPos;}
	
	public int getYpos() {
		return yPos;}
		
	public Room getNextRoom() {
		return room2ref;}
	
	public Room getCurrentRoom() {
		return room1ref;}
	
	public boolean isLocked()
	{return locked;}
	
	public boolean promptUser()
	{
		System.out.println("Cross this door to the next room? (y/n)");
			
			Scanner inputScanner = new Scanner(System.in);
			char choice = inputScanner.next().charAt(0);
			
			if(choice == 'y') {
				return true;
			}
			else {
				return false;
			}
	}
}
