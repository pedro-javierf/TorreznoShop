package ucm.is2.torreznoshop;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.elements.Store;
import ucm.is2.torreznoshop.spaces.Room;
import ucm.is2.torreznoshop.utilities.Pigtype;
import ucm.is2.torreznoshop.utilities.Texts;


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
	static Controller c = new Controller(rand, new GameEntity(10, 500, room));

	public static void main(String[] args) {
		
		System.out.println(Texts.INITIALTEXT);
		System.out.println(Texts.TUTORIAL);
		
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
