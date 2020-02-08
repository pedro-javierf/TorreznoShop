package main;

public class Main {

	//User interfaces from here
	
	Pig p1 = new Pig(500,100,Pigtype.BELLOTA);
	Pig p2 = new Pig(300,80,Pigtype.CLASSIC);
	
	static Store charcuteriaManolo = new Store(1000);
	
	public static void Main()
	{
		charcuteriaManolo.showPigs();
	}
}
