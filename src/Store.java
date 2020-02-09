
import java.util.List;

public class Store {

	private int _balance;
	private String name;
	private int [] availableTorreznos;
	private List<Pig> availablePigs;
	
	
	public Store(int balance)
	{
		_balance=balance;
		
	}
	
	void showPigs()
	{
		for(Pig l:availablePigs)
		{
			System.out.println(l.get_cost()+"$ " + l.get_size()+ " "+l.get_type().name());
		}
	}
	
	void sellTorreznos(int amount, Pigtype type)
	{
		if(availableTorreznos[type.ordinal()]>=amount)
		{
			availableTorreznos[type.ordinal()] -= amount;
			_balance += amount * type.getCost();
			System.out.println("Purchase completed");
		}
		else
		{
			System.out.println("Not enough torreznos");
		}
	}
	
	
	void turnPigIntoTorrezno(Pig p)
	{
		int index = p.get_type().ordinal();
		int numTorreznos = p.get_size();
		availableTorreznos[index] += numTorreznos;
		
		availablePigs.remove(p);
	}
	
	boolean buyPig(Pig p)
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
	
}
