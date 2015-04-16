package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	private Ocean ocean;

	private Ocean ocean2;
	private Ocean ocean1;

	Battleship testBattleship;//ship length 4
	Cruiser testCruiser;//ship length 3
	Destroyer testDestroyer;//ship length 2
	Submarine testSubmarine;//ship length 1
	EmptySea testEmptySea;//ship length 1

	Battleship Battleship1;//ship length 4
	Cruiser Cruiser1;//ship length 3
	Destroyer Destroyer1;//ship length 2
	Submarine Submarine1;//ship length 1
	EmptySea EmptySea1;//ship length 1

	Battleship Battleship2;//ship length 4
	Cruiser Cruiser2;//ship length 3
	Destroyer Destroyer2;//ship length 2
	Submarine Submarine2;//ship length 1
	EmptySea EmptySea2;//ship length 1
	@Before
	public void setUp() throws Exception {
		ocean=new Ocean();
		ocean=new Ocean();
		ocean2=new Ocean();
		ocean1=new Ocean();

		testBattleship=new Battleship();
		//for mainly testing use
		testDestroyer=new Destroyer();
		testCruiser=new Cruiser();
		testSubmarine=new Submarine();
		testEmptySea=new EmptySea();

		//ocean1, testing for horizontal
		Battleship1=new Battleship();
		Destroyer1=new Destroyer();
		Cruiser1=new Cruiser();
		Submarine1=new Submarine();
		EmptySea1=new EmptySea();

		Battleship2=new Battleship();
		Destroyer2=new Destroyer();
		Cruiser2=new Cruiser();
		Submarine2=new Submarine();
		EmptySea2=new EmptySea();
		//construct ocean
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(i==0){
					if(j==0){

						Destroyer1.placeShipAt(i, j, false, ocean1);
					}
					else if(j==2){

						Cruiser1.placeShipAt(i, j, false, ocean1);

					}else if(j==5){

						Battleship1.placeShipAt(i, j, false, ocean1);

					}else if(j==9){

						Submarine1.placeShipAt(i, j, false, ocean1);


					}	
				}else if(i==8){
					if(j==0){
						EmptySea1.placeShipAt(i, j, false, ocean1);
					}else if(j==9){
						EmptySea2.placeShipAt(i, j, false, ocean1);
					}

				}
				else if(i==9){
					if(j==0){

						Destroyer2.placeShipAt(i, j, true, ocean1);

					}
					else if(j==2){

						Cruiser2.placeShipAt(i, j, true, ocean1);

					}else if(j==5){

						Battleship2.placeShipAt(i, j, true, ocean1);

					}else if(j==9){

						Submarine2.placeShipAt(i, j, true, ocean1);


					}
				}

			}
		}
	}

	@Test
	public void okToPlaceShipAtTest() {
		//testing for five type ships
		//testing for position to place ship
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				assertTrue(testSubmarine.okToPlaceShipAt(i, j, true, ocean));		
				assertTrue(testEmptySea.okToPlaceShipAt(i, j, true, ocean));	
				assertTrue(testSubmarine.okToPlaceShipAt(i, j, false, ocean));		
				assertTrue(testEmptySea.okToPlaceShipAt(i, j, false, ocean));					
				//testing for horizontal Battleship
				if(j<9){
					assertTrue(testDestroyer.okToPlaceShipAt(i, j, true, ocean));	
				}else if(j<8){
					assertTrue(testCruiser.okToPlaceShipAt(i, j, true, ocean));	
				}else if(j<7){
					assertTrue(testBattleship.okToPlaceShipAt(i, j, true, ocean));
				}
				//testing for vertical Battleship

				if(i<9){
					assertTrue(testDestroyer.okToPlaceShipAt(i, j, false, ocean));	
				}else if(i<8){
					assertTrue(testCruiser.okToPlaceShipAt(i, j, false, ocean));	
				}else if(i<7){
					assertTrue(testBattleship.okToPlaceShipAt(i, j, false, ocean));
				}
			}

		}
		//invalid input position
		for(int i=-3;i<0;i++){
			for(int j=0;j<10;j++){
				assertFalse(testSubmarine.okToPlaceShipAt(i, j, false, ocean));		
				assertFalse(testEmptySea.okToPlaceShipAt(i, j, false, ocean));	
				assertFalse(testCruiser.okToPlaceShipAt(i, j, false, ocean));	
				assertFalse(testBattleship.okToPlaceShipAt(i, j, false, ocean));
				assertFalse(testDestroyer.okToPlaceShipAt(i, j, false, ocean));
			}
		}
		for(int i=0;i<3;i++){
			for(int j=10;j<12;j++){
				assertFalse(testSubmarine.okToPlaceShipAt(i, j, true, ocean));		
				assertFalse(testEmptySea.okToPlaceShipAt(i, j, true, ocean));	
				assertFalse(testCruiser.okToPlaceShipAt(i, j, true, ocean));	
				assertFalse(testBattleship.okToPlaceShipAt(i, j, true, ocean));
				assertFalse(testDestroyer.okToPlaceShipAt(i, j, true, ocean));
			}
		}
//testing for nearby occupied!!
		
	}
	@Test
	public void placeShipAtTest() {
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				assertFalse(ocean.getShipArray()[i][j] instanceof Submarine);
				testSubmarine.placeShipAt(i, j, true, ocean);
				assertTrue(ocean.getShipArray()[i][j] instanceof Submarine);


			}
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(j==0){
					
					assertFalse(ocean.getShipArray()[i][j] instanceof Destroyer);
					testDestroyer.placeShipAt(i, j, true, ocean);
					assertTrue(ocean.getShipArray()[i][j] instanceof Destroyer);
					assertTrue(ocean.getShipArray()[i][j+1] instanceof Destroyer);
					assertFalse(ocean.getShipArray()[i][j+2] instanceof Destroyer);
				}
				else if(j==2){
					assertFalse(ocean.getShipArray()[i][j] instanceof Cruiser);
					testCruiser.placeShipAt(i, j, true, ocean);
					assertTrue(ocean.getShipArray()[i][j] instanceof Cruiser);
					assertTrue(ocean.getShipArray()[i][j+1] instanceof Cruiser);
					assertTrue(ocean.getShipArray()[i][j+2] instanceof Cruiser);
					assertFalse(ocean.getShipArray()[i][j+3] instanceof Battleship);
				}else if(j==5){
					assertFalse(ocean.getShipArray()[i][j] instanceof Battleship);
					testBattleship.placeShipAt(i, j, true, ocean);
					assertTrue(ocean.getShipArray()[i][j] instanceof Battleship);
					assertTrue(ocean.getShipArray()[i][j+1] instanceof Battleship);
					assertTrue(ocean.getShipArray()[i][j+2] instanceof Battleship);
					assertTrue(ocean.getShipArray()[i][j+3] instanceof Battleship);
					assertFalse(ocean.getShipArray()[i][j+4] instanceof Battleship);
				}else if(j==9){
					assertFalse(ocean.getShipArray()[i][j] instanceof EmptySea);
					testEmptySea.placeShipAt(i, j, true, ocean);
					assertTrue(ocean.getShipArray()[i][j] instanceof EmptySea);

				}
			}
		}
		//vertical
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(j<9){
					if(i==0){
						assertTrue(ocean2.getShipArray()[i][j] instanceof EmptySea);
						assertFalse(ocean2.getShipArray()[i][j] instanceof Destroyer);
						testDestroyer.placeShipAt(i, j, false, ocean2);
						assertTrue(ocean2.getShipArray()[i][j] instanceof Destroyer);
						assertTrue(ocean2.getShipArray()[i+1][j] instanceof Destroyer);
						assertFalse(ocean2.getShipArray()[i+2][j] instanceof Destroyer);
					}
					else if(i==2){
						assertTrue(ocean2.getShipArray()[i][j] instanceof EmptySea);
						assertFalse(ocean2.getShipArray()[i][j] instanceof Cruiser);
						testCruiser.placeShipAt(i, j, false, ocean2);
						assertTrue(ocean2.getShipArray()[i][j] instanceof Cruiser);
						assertTrue(ocean2.getShipArray()[i+1][j] instanceof Cruiser);
						assertTrue(ocean2.getShipArray()[i+2][j] instanceof Cruiser);
						assertFalse(ocean2.getShipArray()[i+3][j] instanceof Battleship);
					}else if(i==5){
						assertTrue(ocean2.getShipArray()[i][j] instanceof EmptySea);
						assertFalse(ocean2.getShipArray()[i][j] instanceof Battleship);
						testBattleship.placeShipAt(i, j, false, ocean2);
						assertTrue(ocean2.getShipArray()[i][j] instanceof Battleship);
						assertTrue(ocean2.getShipArray()[i+1][j] instanceof Battleship);
						assertTrue(ocean2.getShipArray()[i+2][j] instanceof Battleship);
						assertTrue(ocean2.getShipArray()[i+3][j] instanceof Battleship);
						assertFalse(ocean2.getShipArray()[i+4][j] instanceof Battleship);
					}
					//problem exist!
					
				}
				else{
					assertTrue(ocean2.getShipArray()[i][j] instanceof EmptySea);
					assertFalse(ocean2.getShipArray()[i][j] instanceof Submarine);
					testSubmarine.placeShipAt(i, j, false, ocean2);
					assertTrue(ocean2.getShipArray()[i][j] instanceof Submarine);
				}
			}
		}

	}

	@Test
	public void shootAtTest() {
		//ocean
		assertTrue(Battleship1.shootAt(0, 5));//ship length 4
		assertTrue(Battleship1.shootAt(1, 5));
		assertTrue(Battleship1.shootAt(2, 5));
		assertTrue(Battleship1.shootAt(3, 5));

		//hit again
		assertFalse(Battleship1.shootAt(3, 5));
		//no ship in this place
		assertFalse(Battleship1.shootAt(4, 5));

		assertTrue(Cruiser1.shootAt(0, 2));//ship length 3
		assertTrue(Cruiser1.shootAt(1, 2));
		assertTrue(Cruiser1.shootAt(2, 2));

		assertFalse(Cruiser1.shootAt(1, 2));
		assertFalse(Cruiser1.shootAt(7, 5));

		assertTrue(Destroyer1.shootAt(0, 0));//ship length 2
		assertTrue(Destroyer1.shootAt(1, 0));

		assertFalse(Destroyer1.shootAt(0, 0));
		assertFalse(Destroyer1.shootAt(3, 0));

		assertTrue(Submarine1.shootAt(0, 9));//ship length 1
		assertFalse(Submarine1.shootAt(0, 9));
		assertFalse(Submarine1.shootAt(3, 0));

		//always return false, no mater where
		/*
		assertFalse(EmptySea1.shootAt(8, 0));//ship length 1
		assertFalse(EmptySea2.shootAt(8, 9));//ship length 1

		assertFalse(EmptySea2.shootAt(8, 9));
		assertFalse(EmptySea2.shootAt(6, 3));
*/
		assertTrue(EmptySea1.shootAt(8, 0));//ship length 1
		assertTrue(EmptySea2.shootAt(8, 9));//ship length 1

		assertTrue(EmptySea2.shootAt(8, 9));
		assertTrue(EmptySea2.shootAt(6, 3));

	}

	@Test
	public void isSunkTest() {
		assertFalse(Battleship2.isSunk());

		//ocean
		Battleship2.shootAt(9, 5);//ship length 4
		Battleship2.shootAt(9, 6);
		Battleship2.shootAt(9, 7);
		Battleship2.shootAt(9, 8);
		assertTrue(Battleship2.isSunk());

		assertFalse(Cruiser2.isSunk());
		Cruiser2.shootAt(9, 2);//ship length 3
		Cruiser2.shootAt(9, 3);
		assertFalse(Cruiser2.isSunk());
		Cruiser2.shootAt(9, 4);
		assertTrue(Cruiser2.isSunk());

		assertFalse(Destroyer2.isSunk());
		Destroyer2.shootAt(9, 0);//ship length 2
		Destroyer2.shootAt(9, 1);
		assertTrue(Destroyer2.isSunk());
		
		assertFalse(Submarine2.isSunk());
		Submarine2.shootAt(9, 9);//ship length 1
		assertTrue(Submarine2.isSunk());

		//always return false, no mater where
		assertFalse(EmptySea2.isSunk());
		EmptySea2.shootAt(8, 9);//ship length 1
		assertFalse(EmptySea2.isSunk());
	}
	@Test
	public void getShipTypeTest() {
		assertEquals("empty", testEmptySea.getShipType());
		assertEquals("cruiser", testCruiser.getShipType());
		assertEquals("battleship", testBattleship.getShipType());
		assertEquals("submarine", testSubmarine.getShipType());
		assertEquals("destroyer", testDestroyer.getShipType());

	}
	//do we need this?
	@Test
	public void toStringTest() {

		assertEquals(" ", Cruiser2.toString());
		Cruiser2.shootAt(9, 2);//ship length 3
		Cruiser2.shootAt(9, 3);
		assertEquals("s", Cruiser2.toString());
		Cruiser2.shootAt(9, 4);
		assertEquals("x", Cruiser2.toString());
		
		assertEquals(" ", Battleship2.toString());
		Battleship2.shootAt(9, 5);//ship length 4
		Battleship2.shootAt(9, 6);
		Battleship2.shootAt(9, 7);
		assertEquals("s", Battleship2.toString());
		Battleship2.shootAt(9, 8);
		assertEquals("x", Battleship2.toString());


		assertEquals(" ", Destroyer2.toString());
		Destroyer2.shootAt(9, 0);//ship length 2
		assertEquals("s", Destroyer2.toString());
		Destroyer2.shootAt(9, 1);
		assertEquals("x", Destroyer2.toString());
		
		assertEquals(" ", Submarine2.toString());
		Submarine2.shootAt(9, 9);//ship length 1
		assertEquals("x", Cruiser2.toString());

		
		//always return false, no mater where
		assertEquals(".", EmptySea2.toString());
		EmptySea2.shootAt(8, 9);//ship length 1
		assertEquals(".", EmptySea2.toString());

		/*
		
		
		
		assertEquals(" ", testSubmarine.toString());
		assertEquals(" ", testDestroyer.toString());
*/
	}
}
