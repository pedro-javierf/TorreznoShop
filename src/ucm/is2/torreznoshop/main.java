package ucm.is2.torreznoshop;
import java.util.Random;
import java.util.Scanner;

import ucm.is2.torreznoshop.spaces.Store;
import ucm.is2.torreznoshop.utilities.Pig;
import ucm.is2.torreznoshop.utilities.Pigtype;
import ucm.is2.torreznoshop.utilities.Texts;


public class main {
	//TODO: Refactor for removing pigs from functioning
	//User interfaces from here
	
//	Pig p1 = new Pig(500,100,Pigtype.BELLOTA);
//	Pig p2 = new Pig(300,80,Pigtype.CLASSIC);
	
	static Store charcuteriaManolo = new Store(1000);
	static boolean end = false;
	static int AorB;
	static boolean buy;
	
	int torreznos;
	int tType;
	static Random rand = new Random(); 	
	static Controller c = new Controller(rand, charcuteriaManolo);

	public static void main(String[] args) {
		
		System.out.println(Texts.INITIALTEXT);
		System.out.println(Texts.TUTORIAL);
		
		while(!end) {
			
			
			
			
			AorB = rand.nextInt(2);
			
			c.showTurnInfo();

			if(AorB == 0) {
				c.buy();
			}
			
			else {
				c.sell();
			}
			
			end = c.update();			
		}
	}

}
