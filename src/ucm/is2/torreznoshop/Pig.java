package ucm.is2.torreznoshop;

public class Pig {

	private int _cost;
	private int _size; //size 50 means it can be turned into 50 delicious Torreznos of the same type
	private Pigtype _type;
	
	public Pig(int cost, int size, Pigtype type)
	{
		_cost=cost;
		_size=size;
		_type=type;
	}

	public int get_cost() {
		return _cost;
	}

	public void set_cost(int _cost) {
		this._cost = _cost;
	}

	public int get_size() {
		return _size;
	}

	public void set_size(int _size) {
		this._size = _size;
	}

	public Pigtype get_type() {
		return _type;
	}

	public void set_type(Pigtype _type) {
		this._type = _type;
	}
	
	
	
}
