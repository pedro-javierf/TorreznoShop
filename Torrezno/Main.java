package main;

import com.sun.java_cup.internal.runtime.Scanner;

public class Main {

	//User interfaces from here
	
	Pig p1 = new Pig(500,100,Pigtype.BELLOTA);
	Pig p2 = new Pig(300,80,Pigtype.CLASSIC);
	
	static Store charcuteriaManolo = new Store(1000);
	boolean end = false;
	boolean AorB;
	boolean buy;
	int turn = 1;
	
	public static void Main(String args[])
	{
		
		while(!end) {
			AorB = (Math.random < 0.5);
			if(AorB) {
				System.out.Println("A new farmer enters your shop!");		
				System.out.Println("He wants to sell you an awesome pig!");
				buy = charcuteriaManolo.buyPig(new Pig(Math.random(),Math.random(),Math.random());   
			}
			
			else {
				System.out.Println("A new citizen enters your shop!");
				System.out.Println("He wants to buy your worldwide known torreznos!");
			}
			
			if(turn == 8) {
				System.out.Println("Phew... That was the last client for today");
				System.out.Println("It is getting late...");
				System.out.Println("Do you want to manage again your store tomorrow? (y/n)");
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
