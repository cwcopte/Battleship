package battleship;

import java.util.Random;

public class Ocean {
	Ship[][] ships = new Ship[10][10] ;
	//Used to quickly determine which ship is in any given location.
	int shotsFired ;
	//The total number of shots fired by the user
	int hitCount ;
	//The number of ships sunk (10 ships in all)
	int shipsSunk;

	public Ocean() {
		//Creates an ”empty” ocean (fills the ships array with EmptySeas).
		//ships[][]
		shotsFired=0;
		hitCount=0;
		shipsSunk=0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Place all ten ships randomly on the (initially empty) ocean
	 */
	void placeAllShipsRandomly(){


		Battleship[] battleship=new Battleship[1];
		Destroyer[] destroyer=new Destroyer[3];//length2
		Cruiser[] cruiser=new Cruiser[4];
		Submarine[] submarine=new Submarine[2];//length3
		//EmptySea[]
		placeShips(battleship,this);
		placeShips(destroyer,this);
		placeShips(cruiser,this);
		placeShips(submarine,this);
	}
	
	private void placeShips(Ship[] insertShips, Ocean ocean){
		Random row=new Random();
		Random column=new Random();
		Random horizontal=new Random();
		/*
		 * while, do; do while ? both
		 */
		int randomRow;
		int randomColumn;
		boolean randomHorizontal;
		for(int i=0;i<insertShips.length;i++){
			do{
				//generate random number
				randomRow=row.nextInt(10);
				randomColumn=column.nextInt(10);
				randomHorizontal=horizontal.nextBoolean();

				if(insertShips[i].okToPlaceShipAt(randomRow,randomColumn,randomHorizontal, ocean)){
					insertShips[i].placeShipAt(randomRow,randomColumn,randomHorizontal, ocean);
				}
			}
			while(!(insertShips[i].okToPlaceShipAt(randomRow,randomColumn,randomHorizontal, ocean)));
		}
	}
	
	
	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @param row
	 * @param column
	 * @return
	 */
	boolean isOccupied(int row, int column){
		//row and column out of range?
		if(this.getShipArray()[row][column] instanceof EmptySea){
			return true;
		}
		return false;

	}
	/**
	 * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea),
false if it does not. 
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column){
		if(!(this.getShipArray()[row][column] instanceof EmptySea)){
			if(!this.getShipArray()[row][column].isSunk()){
				return true;
			}
			//when to increase?
			/*
			else{
				shipsSunk++;
			}*/
		}
		//real ship but not afloat? false instead?
		return false;
	}
	/**
	 * Returns the number of shots fired 
	 * @return 
	 */
	public int getShotsFired() {
		return shotsFired;
	}
	/**
	 * Returns the number of hits recorded
	 * @return
	 */
	public int getHitCount() {
		return hitCount;
	}
	/**
	 * Returns the number of ships sunk 
	 * @return
	 */
	public int getShipsSunk() {
		return shipsSunk;
	}
	/**
	 * Returns true if all ships have been sunk, otherwise false.
	 * @return
	 */
	boolean isGameOver(){
		if(this.getShipsSunk()==10){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public Ship[][] getShipArray() {
		return ships;
	}
	/**
	 * 
	 */
	void print(){
		//print array
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                System.out.print(ships[i][j] + " ");
            }
            System.out.println();
        }

	}
}
