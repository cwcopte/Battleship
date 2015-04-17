package battleship;

public abstract class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected int length;
	protected boolean horizontal;
	boolean []hit;
	/**
	 * returns the row (0 to 9) which contains the bow (front) of the ship.
	 * @return
	 */
	public int getBowRow() {
		return bowRow;
	}
	/**
	 * set the row (0 to 9) which contains the bow (front) of the ship. 
	 * @param bowRow
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	/**
	 * return the column (0 to 9) which contains the bow (front) of the ship.
	 * @return
	 */
	public int getBowColumn() {
		return bowColumn;
	}
	/**
	 * set the the column (0 to 9) which contains the bow (front) of the ship.
	 * @param bowColumn
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	/**
	 * return whether the ship is horizontal or not.
	 * @return
	 */
	public boolean isHorizontal() {
		return horizontal;
	}
	/**
	 * set the horizontal position of the ship.
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	/**
	 * returns the length of the ship
	 * @return
	 */
	int getLength(){
		return length;
	}
	//int abstract getLength();
	public Ship() {

		//hit=new boolean[]{false,false,false,false};
		/*
		for(int i=0;i<hit.length;i++){
			hit[i]=false;
		}
		 */
	}
	abstract String getShipType();
	/**
	 * Returns true if it is okay to put a ship of this length with its bow in this location, with
the given orientation, and returns false otherwise. 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		//0-9

		if(horizontal){
			if(column>=0&&(column+this.getLength()-1)<=9&&row>=0&&row<=9){
				//valid position, not out of edge
				for( int i=row-1;i<row+2;i++){
					for( int j=column-1;j<column+this.getLength()+1;j++){
						//check ship position and surrounding ship
						if(i>=0&&i<=9&&j>=0&&j<=9){
							if(ocean.isOccupied(i, j))
							{
								return false;
							}
						}
					}
				}

				return true;
			}
		}
		else{
			if(row>=0&&(row+this.getLength()-1)<=9&&column>=0&&column<=9){
				//check ship position and surrounding ship
				for( int i=row-1;i<row+this.getLength()+1;i++){
					for( int j=column-1;j<column+2;j++){
						//check valid surrounding
						if(i>=0&&i<=9&&j>=0&&j<=9){
							if(ocean.isOccupied(i, j))
							{
								return false;
							}
						}

					}
				}
				//valid position, not out of edge

				return true;
			}
		}
		return false;

	}

	/**
	 * Puts the ship in the ocean. 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		//what to do with the ocean?
		//ocean.hitCount++;

		if(horizontal){
			for(int i=0;i<this.length;i++){
				ocean.getShipArray()[row][column+i]=this;
			}	
		}
		else{
			for(int i=0;i<this.length;i++){
				ocean.getShipArray()[row+i][column]=this;
			}


		}
	}
	/**
	 * )
If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow) and return
true, otherwise return false
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column){
		//how about invalid input? in testing , or control in main(later)
		//this.getBowRow();
		int position;

		if(!this.isSunk()){
			if(this.isHorizontal()){
				//how to get the variable

				if(column>=this.bowColumn&&column<(this.bowColumn+this.length)&&this.bowRow==row){
					position=column-this.bowColumn;
					this.hit[position]=true;
					//System.out.println("changed: "+hit[position]);
					return true;

				}

				//if(column>this.getBowColumn();&&column<(this.getBowColumn()+this.getLength()))
			}else{
				if(row>=this.bowRow&&row<(this.bowRow+this.length)&&this.bowColumn==column){
					position=row-this.bowRow;
					this.hit[position]=true;
					//System.out.println("changed: "+hit[position]);
				}
				return true;}
		}
		return false;
	}
	/**
	 * Return true if every part of the ship has been hit, false otherwise.
	 * @return
	 */
	boolean isSunk(){
		int m=0;
		for(int i=0;i<this.hit.length;i++){
			if(this.hit[i]){
				m++;
			}
			if(m==this.length){
				return true;
			}

		}
		return false;
	}
	/**
	 * if the ship is sunk,mark it as "x", if the ship is hit but not sunk, mark it with "s", otherwise "." if not empty sea
	 */
	@Override
	public String toString() {
		int shot=0;
		if(this.isSunk()){
			return " x";
		}
		else{
			for(int i=0;i<hit.length;i++){
				if (hit[i]){
					shot++;
					//return "s";
				}
				
			}
			if(shot<this.length&&shot!=0){
				return " s";
			}else{
				return " .";
			}
			
			//for not sunk or hitted
		}
	}

