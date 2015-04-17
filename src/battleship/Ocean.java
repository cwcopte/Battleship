package battleship;

import java.util.Random;

public class Ocean {
	private Ship[][] ships = new Ship[10][10] ;
	//Used to quickly determine which ship is in any given location.
	private int shotsFired ;
	//The total number of shots fired by the user
	private int hitCount ;
	//The number of ships sunk (10 ships in all)
	private int shipsSunk;

	public Ocean() {

		//Creates an ”empty” ocean (fills the ships array with EmptySeas)
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				EmptySea empty=new EmptySea();
				ships[i][j]=empty;

			}
		}
		//then the method to place ship should change!!
		shotsFired=0;
		hitCount=0;
		shipsSunk=0;

	}
	/**
	 * Place all ten ships randomly on the (initially empty) ocean
	 */
	void placeAllShipsRandomly(){
		Battleship[] battleship=new Battleship[]{new Battleship()};//ship length 4
		Destroyer[] destroyer=new Destroyer[]{new Destroyer(),new Destroyer(),new Destroyer()};//ship length2
		Cruiser[] cruiser=new Cruiser[]{new Cruiser(),new Cruiser()};//ship length 3
		Submarine[] submarine=new Submarine[]{new Submarine(),new Submarine(),new Submarine(),new Submarine()};//ship length1

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

				//if(insertShips[i].okToPlaceShipAt(randomRow,randomColumn,randomHorizontal, ocean)){
				//place ship

				//change surrounding, overwrite
				/*
				 * 					if(randomHorizontal){
						for(int m=randomRow-1;m<randomRow+2;m++){
							for(int n=randomColumn;n<randomColumn+insertShips[i].length;n++){
								if(n>=0&&n<=9&&m>=0&&m<=9&&!ocean.isOccupied(m, n)){
									//for valid input and no ship exist
									sea.placeShipAt(randomRow, randomColumn, randomHorizontal, ocean);
								}

							}

						}
					}
				 */

				//	}
			}
			while(!(insertShips[i].okToPlaceShipAt(randomRow,randomColumn,randomHorizontal, ocean)));
			insertShips[i].placeShipAt(randomRow,randomColumn,randomHorizontal, ocean);
		}
	}


	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @param row
	 * @param column
	 * @return
	 */
	boolean isOccupied(int row, int column){
		//check if row and column out of range
		if(row>=0&&row<=9&&column>=0&&column<=9){
			if(!(this.getShipArray()[row][column] instanceof EmptySea)){
				return true;
			}
		}
		//invalid input?
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
		//updates the number of shots that have been fired
		shotsFired++;
		//if(!(this.getShipArray()[row][column] instanceof EmptySea)){
		if(!this.getShipArray()[row][column].isSunk()){
			
		
		if(this.getShipArray()[row][column].shootAt(row, column)){
			//hit but not sunk
			//System.out.println("success");

			hitCount++;
			//if put here, cannot tell if hit but already sunk!
			//then, do not need to follow the instructions?
			if (this.getShipArray()[row][column].isSunk()){
				shipsSunk++;
			}
			return true;

		}
		}
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
	 * Prints the ocean. To aid the user, row numbers should be displayed along the left edge
of the array, and column numbers should be displayed along the top. Numbers should
be 0 to 9, not 1 to 10.
The top left corner square should be 0, 0.
Use ’S’ to indicate a location that you have fired upon and hit a (real) ship,
’-’ to indicate a location that you have fired upon and found nothing there,
’x’ to indicate a location containing a sunken ship,
and ’.’ (a period) to indicate a location that you have never fired upon.
	 */
	void print(){
		//print array
		Ship currentShip;
		int row;
		int column;
		boolean horizontal;
		int length;
		//add number in front!
		System.out.println("#0123456789");
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				if(j==0){
					System.out.print(i);
				}
				currentShip=ships[i][j];
				column=currentShip.getBowColumn();
				row=currentShip.getBowRow();
				horizontal=currentShip.isHorizontal();
				length=currentShip.getLength();
				if(currentShip instanceof EmptySea)
				{
					if(currentShip.hit[0]){
						//if(currentShip.shootAt(i, j)){
						System.out.print("-");
					}else{
						System.out.print(".");
					}

				}
				else if(currentShip instanceof Submarine){
					if(currentShip.isSunk()){
						System.out.print("x");
					}else{
						//System.out.print(".");
						//for testing
						System.out.print(" ");
					}
				}
				else {
					
					//System.out.print("x");
					//System.out.print(currentShip.toString());

					if(currentShip.isSunk()){
						System.out.print("x");
					}else if(currentShip.toString()=="s") {
						//check hit array
						boolean print=false;
						for(int m=0;m<currentShip.hit.length;m++){
							if (currentShip.hit[m]){

								if(horizontal){
									if(j-column==m&&i==row){
										System.out.print("s");
										print=true;
										
									}/*
									else{
										System.out.print(" ");
									}*/
								}else{
									if(i-row==m&&j==column){
										System.out.print("s");
										print=true;
									}
									/*
									else{
										System.out.print(" ");
									}*/
								}
							}
						}
						if(!print){
							System.out.print(" ");
						}
						
					}
					else{
						//System.out.print(".");
						//for testing!!
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
