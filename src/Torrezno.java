

public class Torrezno {

	//private int unitCost;
	private Pigtype torreznoType;
	private int deliciousness;
	
	
	public Torrezno(Pigtype type, int delic)
	{
		torreznoType=type;
		deliciousness=delic;
	}
	
	public int getPrice()
	{
		return torreznoType.getCost();
	}
	
	public int getDeliciousness()
	{
		return deliciousness;
	}
	
}
