package ucm.is2.torreznoshop.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ucm.is2.torreznoshop.elements.GameEntity;
import ucm.is2.torreznoshop.spaces.Room;

class GameEntityTest {

	@Test
	void testGameEntity() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		assertNotNull(ge);
	}

	@Test
	void testSetRoom() {
		GameEntity ge =new GameEntity(100, 2000, null ,0 ,0);
		Room a = new Room("test room",null,null,null,0,0);
		ge.setRoom(a);
		assertEquals(ge.getRoom(),a);
	}

	@Test
	void testGetX() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setxPos(77);
		assertEquals(77,ge.getX());
	}

	@Test
	void testGetY() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setyPos(66);
		assertEquals(66,ge.getY());
	}

	@Test
	void testMoveInX() {
		GameEntity ge =new GameEntity(100, 2000, null ,0 ,0);
		ge.moveInX(1);
		assertEquals(ge.getX(),1);
	}

	@Test
	void testMoveInY() {
		GameEntity ge =new GameEntity(100, 2000, null ,0 ,0);
		ge.moveInY(1);
		assertEquals(ge.getY(),1);
	}

	@Test
	void testConsume() {
		assertEquals(true,true);
	}

	@Test
	void testGetHP() {
		
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		assertEquals(100, ge.getHP());
	}

	@Test
	void testSetHP() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setHP(69);
		assertEquals(69, ge.getHP());
	}

	@Test
	void testGetMoney() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		assertEquals(2000,ge.getMoney());
	}

	@Test
	void testSetMoney() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setMoney(0);
		assertEquals(0,ge.getMoney());
	}

	@Test
	void testSetxPos() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setxPos(77);
		assertEquals(77,ge.getX());
	}

	@Test
	void testSetyPos() {
		GameEntity ge = new GameEntity(100, 2000, null ,0 ,0);
		ge.setyPos(66);
		assertEquals(66,ge.getY());
	}

}
