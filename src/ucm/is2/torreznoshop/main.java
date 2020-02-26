package ucm.is2.torreznoshop;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.elements.Player;
import ucm.is2.torreznoshop.elements.Store;
import ucm.is2.torreznoshop.spaces.Building;
import ucm.is2.torreznoshop.spaces.Room;
import ucm.is2.torreznoshop.utilities.Pigtype;
import ucm.is2.torreznoshop.utilities.Texts;

import ucm.is2.torreznoshop.experimental.*;

/*
IS2
With <3 from Pedro and Alberto 
*/

public class main {
	//User interfaces from here
	
	static Store charcuteriaManolo = new Store(1000);
	static boolean end = false;
	static int AorB;
	static boolean buy;
	static Room room;
	int torreznos;
	int tType;
	static Random rand = new Random(); 	
	static Controller c = new Controller(rand, new Player(10, 500, room), new Building(new ArrayList<Room>()));

	public static void main(String[] args) {
		
		//GraphApplication ga = new GraphApplication();
		//ga.runGUI();
		
		System.out.println(Texts.INITIALTEXT);
		//System.out.println(Texts.TUTORIAL);
		System.out.println("");
		
		while(!end) {
			
			c.drawGame();
			AorB = rand.nextInt(2);
			
			c.showTurnInfo();
			c.getInput();

//			if(AorB == 0) {
//				c.buy();
//			}
//			
//			else {
//				c.sell();
//			}
			
			end = c.update();			
		}
	}

}
