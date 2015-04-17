package battleship;

public class EmptySea  extends Ship{
	//Describes a part of the ocean that doesn’t have a ship in it.
	/**
	 * empty sea is instance of ship with length 1
	 */
	public EmptySea() {

		length=1;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false};
	}
    /**
     * type of empty sea is empty
     */
	@Override
	String getShipType() {

		return "empty";
	}
	//return what and how to determined ever being hit or what?



    /**
     * empty sea can't be sunk
     */
	@Override
	boolean isSunk() {

		return false;
	}
    /**
     * empty sea cannot be hit
     */
	@Override
	boolean shootAt(int row, int column) {

		hit[0]=true;
		/*
			if(row==this.getBowRow()&& column==this.getBowColumn()){
				hit[0]=true;
			}*/
		return false;

	}
    /**
     * marks the empty sea with a sign "."
     */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " .";
	}

}
