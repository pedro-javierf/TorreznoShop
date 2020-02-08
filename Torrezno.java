package main;

public class Torrezno {

	private int unitCost;
	private Pigtype torreznoType;
	private int deliciousness;
	
	
	public Torrezno(int cost, Pigtype type, int delic)
	{
		unitCost=cost;
		torreznoType=type;
		deliciousness=delic;
	}
	
	public int getPrice()
	{
		return unitCost;
	}
	
	public int getDeliciousness()
	{
		return deliciousness;
	}
	
}
