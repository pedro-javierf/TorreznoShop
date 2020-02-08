package main;

import java.util.List;

public class Store {

	private int _balance;
	
	//si?
	private List<Torrezno> availableTorreznos;
	private List<Pig> availablePigs;
	
	public Store(int balance)
	{
		_balance=balance;
	}
	
	void turnPigIntoTorrezno(Pig p)
	{
		
	}
	
	boolean buyPig(Pig p)
	{
		
		//if we have enough balance->buy, add to pig list
		
		//else error
		return false;
	}
	
}
