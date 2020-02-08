package main;

public enum Pigtype {
	CLASSIC(10),IBERICO(15),BELLOTA(20),IMPORTACION(40);

	private int _cost;

	private Pigtype(int cost)
	{
		_cost=cost;
	}
	
	public int getCost()
	{
		return _cost;
	}

}


