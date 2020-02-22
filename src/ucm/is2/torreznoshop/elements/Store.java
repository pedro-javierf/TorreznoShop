package ucm.is2.torreznoshop.elements;

import java.util.ArrayList;
import java.util.List;

import ucm.is2.torreznoshop.utilities.Pigtype;

public class Store {

	private int _balance;
	private String name;
	private int [] availableTorreznos;
	
	
	public Store(int balance)
	{
		_balance=balance;
		availableTorreznos = new int[4];
		
		for(int i = 0; i < 4; i++) {
			availableTorreznos[i] = 100;
		}
		
	}
	
	
	void sellTorreznos(int amount, Pigtype type) {
		if(availableTorreznos[type.ordinal()]>=amount) {
			availableTorreznos[type.ordinal()] -= amount;
			_balance += amount * type.getCost();
			System.out.println("Purchase completed");
		}
		else {
			System.out.println("It seems like you do not have enough torreznos");
			System.out.println("Maybe someone arround can lend you some...");
	
		}
	}


	public int get_balance() {
		return _balance;
	}
	
}
