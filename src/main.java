import java.util.Scanner;

public class main {

	//User interfaces from here
	
	Pig p1 = new Pig(500,100,Pigtype.BELLOTA);
	Pig p2 = new Pig(300,80,Pigtype.CLASSIC);
	
	static Store charcuteriaManolo = new Store(1000);
	static boolean end = false;
	static boolean AorB;
	static boolean buy;
	static int turn = 1;
	int torreznos;
	int tType;
	
	public static void main(String[] args) {
		while(!end) {
			AorB = (Math.random() < 0.5);
			if(AorB) {
				System.out.println("A new farmer enters your shop!");		
				System.out.println("He wants to sell you an awesome pig!");
				//buy = charcuteriaManolo.buyPig(new Pig((int)Math.random(),(int)Math.random(),Pigtype.BELLOTA));   
			}
			
			else {
				System.out.println("A new citizen enters your shop!");
				System.out.println("He wants to buy your worldwide known torreznos!");
				int torreznos = (int) Math.random();
				int tipo = (int)Math.random() * ((3 - 0) + 1) + 0;
				System.out.println(torreznos + " of the kind " + Pigtype.toString(tipo) + " are requested");		
			}
			
			if(turn == 8) {
				System.out.println("Phew... That was the last client for today");
				System.out.println("It is getting late...");
				System.out.println("Do you want to manage again your store tomorrow? (y/n)");
				Scanner inputScanner = new Scanner(System.in);
				char choice = inputScanner.next().charAt(0);
				if(choice == 'y') {
					turn = 1;
				}
				else {
					end = true;
				}
			}
			else {
				turn++;
			}
		}
	}

}
