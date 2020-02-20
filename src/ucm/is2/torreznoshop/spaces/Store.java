package ucm.is2.torreznoshop.spaces;

import java.util.ArrayList;
import java.util.List;

import ucm.is2.torreznoshop.utilities.Pig;
import ucm.is2.torreznoshop.utilities.Pigtype;

public class Store {

	private int _balance;
	private String name;
	private int [] availableTorreznos;
	private List<Pig> availablePigs;
	
	
	public Store(int balance)
	{
		_balance=balance;
		availableTorreznos = new int[4];
		availablePigs = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			availableTorreznos[i] = 100;
		}
		
	}
	
	public void showPigs()
	{
		for(Pig l:availablePigs)
		{
			System.out.println(l.get_cost()+"$ " + l.get_size()+ " "+l.get_type().name());
		}
	}
	
	public void sellTorreznos(int amount, Pigtype type)
	{
		boolean found = false;
		if(availableTorreznos[type.ordinal()]>=amount)
		{
			availableTorreznos[type.ordinal()] -= amount;
			_balance += amount * type.getCost();
			System.out.println("Purchase completed");
		}
		else
		{
			for(Pig p: availablePigs)
			{
				if(p.get_type()==type)
				{
					turnPigIntoTorrezno(p);
					found = true;
				}
				
			}
			if(!found) {
				System.out.println("Purchase could not be completed");
			}
			
			else {
				if(availableTorreznos[type.ordinal()]>=amount)
				{
					availableTorreznos[type.ordinal()] -= amount;
					_balance += amount * type.getCost();
					System.out.println("Purchase completed");
				}
			}
			//System.out.println("Not enough torreznos");
		}
	}
	
	
	
	
	void turnPigIntoTorrezno(Pig p)
	{
		int index = p.get_type().ordinal();
		int numTorreznos = p.get_size();
		availableTorreznos[index] += numTorreznos;
		
		availablePigs.remove(p);
	}
	
	public boolean buyPig(Pig p)
	{
		
		//if we have enough balance->buy, add to pig list
		if(_balance >= p.get_cost())
		{
			System.out.println("Purchase completed.");
			_balance = _balance - p.get_cost();
			availablePigs.add(p);
		}
		else {
			System.out.println("This store doesn't have enough money.");
		}
		//else error
		return false;
	}

	public int get_balance() {
		return _balance;
	}
	
}
