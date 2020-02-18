package ucm.is2.torreznoshop.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucm.is2.torreznoshop.utilities.Pig;
import ucm.is2.torreznoshop.utilities.Pigtype;

class PigTest {
	
	Pig p;

	@BeforeEach
	void setUp() throws Exception {
		
		p = new Pig(100,100,Pigtype.BELLOTA);
	}

	@Test
	void testGet_cost() {
	
		assertEquals(p.get_cost(),100);
	}

	@Test
	void testSet_cost() {
		p.set_cost(69);
		assertEquals(p.get_cost(),69);
	}

	@Test
	void testGet_size() {
		assertEquals(p.get_size(),100);
	}

	@Test
	void testSet_size() {
		p.set_size(100);
		assertEquals(p.get_size(),100);
	}

	@Test
	void testGet_type() {
		assertEquals(p.get_type(),Pigtype.BELLOTA);
	}

	@Test
	void testSet_type() {
		p.set_type(Pigtype.IBERICO);
		assertEquals(p.get_type(),Pigtype.IBERICO);
	}

}
