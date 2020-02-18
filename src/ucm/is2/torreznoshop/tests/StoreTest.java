package ucm.is2.torreznoshop.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucm.is2.torreznoshop.elements.Store;

class StoreTest {

	@BeforeEach
	void setUp() throws Exception {
		Store s = new Store(1000);
	}

	@Test
	void testShowPigs() {
		assertEquals(true,true);
	}

	@Test
	void testSellTorreznos() {
		fail("Not yet implemented");
	}

	@Test
	void testTurnPigIntoTorrezno() {
		fail("Not yet implemented");
	}

	@Test
	void testBuyPig() {
		fail("Not yet implemented");
	}

}
