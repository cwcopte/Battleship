package battleship;

public abstract class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected int length;
	protected boolean horizontal;
	protected boolean []hit=new boolean[4];
	/**
	 * 
	 * @return
	 */
	public int getBowRow() {
		return bowRow;
	}
	/**
	 * 
	 * @param bowRow
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	/**
	 * 
	 * @return
	 */
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	int getLength(){
		return length;
	}
	//int abstract getLength();
	public Ship() {
		// TODO Auto-generated constructor stub
		boolean []hit=new boolean[4];
		for(int i=0;i<hit.length;i++){
			hit[i]=false;
		}
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
			if(row>=0&&(row+this.getLength()-1)<=9&&column>=0&&column<=9){
				
				for( int i=column;i<column+this.getLength();i++){
					
						//check ship position and ignore empty ship in sourounding
						if(ocean.isOccupied(row, i))
						{
							return false;
						}
				}
				return true;
			}return false;
		}
		else{
			if(column>=0&&(column+this.getLength()-1)<=9&&row>=0&&row<=9){
				for( int i=row-1;i<row+this.getLength()+1;i++){
				
						//check ship position and ignore empty ship in sourounding
						if(ocean.isOccupied(i, column))
						{
							return false;
						}
					
				}return true;
			}
		}return false;

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
		this.getBowRow();
		if(this.isHorizontal()){
			//how to get the variable

			if(column>this.bowColumn&&column<(this.bowColumn+this.length)&&this.bowRow==row){
				hit[column-this.bowColumn]=true;
				return true;}

			//if(column>this.getBowColumn();&&column<(this.getBowColumn()+this.getLength()))
		}else{
			if(row>this.bowRow&&row<(this.bowRow+this.length)&&this.bowColumn==column){
				hit[row-this.bowRow]=true;
			}
			return true;}

		return false;
	}
	/**
	 * Return true if every part of the ship has been hit, false otherwise.
	 * @return
	 */
	boolean isSunk(){
		int m=0;
		for(int i=0;i<hit.length;i++){
			if(hit[i]){
				m++;
			}
			if(m==this.length){
				return true;
			}

		}
		return false;
	}
	@Override
	public String toString() {

		if(this.isSunk()){
			return "x";
		}
		else{
			for(int i=0;i<hit.length;i++){
				if (hit[i]){
					return "s";
				}
			}return "";
			//for not sunk or hitted
		}
	}

}
