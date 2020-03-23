package ucm.is2.torreznoshop.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ucm.is2.torreznoshop.elements.Player;

class PlayerTest {

	@Test
	void testPlayer() {
		Player pepe = new Player(100,2000,null, 2);
		assertNotNull(pepe);
	}

}
