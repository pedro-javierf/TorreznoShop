package ucm.is2.torreznoshop;


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
	
	public static String toString(int idx) {
		if(idx == 0) {
			return "Classic";
		}
		
		else if (idx == 1) {
			return "Iberico";
		}
		
		else if (idx == 2) {
			return "Bellota";
		}
		
		else {
			return "Importacion";
		}
	}

}


