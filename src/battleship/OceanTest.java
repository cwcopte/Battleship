package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean ocean;
	Ship[] ship;
	@Before
	public void setUp() throws Exception {
		ocean=new Ocean();
		//are those ships the same or not==not!
		ship=new Ship[]{new EmptySea(),
				new Battleship(),
				new Destroyer(),new Destroyer(),new Destroyer(),
				new Cruiser(),new Cruiser(),
				new Submarine(),new Submarine(),new Submarine(),new Submarine()};
		//battleship
		ship[1].placeShipAt(3, 3, false, ocean);
		//destroyer
		ship[2].placeShipAt(2, 7, true, ocean);
		ship[3].placeShipAt(4, 1, false, ocean);
		ship[4].placeShipAt(8, 8, false, ocean);
		
		//cruiser
		
		ship[5].placeShipAt(8, 0, true, ocean);
		ship[6].placeShipAt(4, 7, false, ocean);

		//submarine
		ship[7].placeShipAt(0, 5, false, ocean);
		ship[8].placeShipAt(2, 5, false, ocean);
		ship[9].placeShipAt(4, 5, false, ocean);
		ship[10].placeShipAt(8, 5, false, ocean);
		//true or false are the same for length 1? yes
		//fill empty sea
		for (int i = 0; i < ocean.ships.length; i++) {
			for (int j = 0; j < ocean.ships[i].length; j++) {
				if (ocean.ships[i][j]!= null){
					ocean.ships[i][j]=ship[0];
				}
			}
		}

	}

	@Test
	public void testOcean() {
		assertEquals(ocean.shotsFired,0);
		assertEquals(ocean.hitCount,0);
		assertEquals(ocean.shipsSunk,0);

	}
	/*
// physically can not test
	@Test
	public void testPlaceAllShipsRandomly() {
		fail("Not yet implemented");
	}
	 */
	@Test
	public void testIsOccupied() {
		assertFalse(ocean.isOccupied(0, 0));
		//submarine
		assertTrue(ocean.isOccupied(0, 5));
		assertFalse(ocean.isOccupied(0, 6));
		//battleship
		assertTrue(ocean.isOccupied(5, 3));
		assertTrue(ocean.isOccupied(3, 3));
		assertTrue(ocean.isOccupied(4, 3));
		assertTrue(ocean.isOccupied(6, 3));
		assertFalse(ocean.isOccupied(7, 3));
		//destroyer
		assertTrue(ocean.isOccupied(2, 8));
		assertTrue(ocean.isOccupied(2, 7));
		assertFalse(ocean.isOccupied(2, 6));
		//cruiser
		assertTrue(ocean.isOccupied(8, 1));
		assertTrue(ocean.isOccupied(8, 0));
		assertTrue(ocean.isOccupied(8, 2));
		assertFalse(ocean.isOccupied(9, 0));
		
		assertFalse(ocean.isOccupied(9, 9));
	}

	@Test
	public void testShootAt() {
		assertEquals(ocean.shotsFired,0);
		assertEquals(ocean.hitCount,0);
		assertEquals(ocean.shipsSunk,0);
		//assertEquals(ocean.getHitCount(),0);

		
		//submarine
		ocean.shootAt(2, 5);
		assertEquals(ocean.shotsFired,1);
		assertEquals(ocean.getHitCount(),1);
		//assertEquals(ocean.hitCount,1);
		//assertEquals(ocean.shipsSunk,1);
		//destroyer
		ocean.shootAt(4, 1);
		ocean.shootAt(5, 1);
		//battleship
		ocean.shootAt(3, 3);
		ocean.shootAt(4, 3);
		ocean.shootAt(5, 3);
		ocean.shootAt(6, 3);

		
		//cruiser
		ocean.shootAt(4,7);
		ocean.shootAt(5, 7);
		ocean.shootAt(6, 7);
		//test hit again!
		


	}
	@Test
	public void testGetShotsFired() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHitCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShipsSunk() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGameOver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShipArray() {
		fail("Not yet implemented");
	}

	
}
