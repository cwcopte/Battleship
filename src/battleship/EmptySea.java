package battleship;

public class EmptySea  extends Ship{
//Describes a part of the ocean that doesn’t have a ship in it.
	public EmptySea() {
	
		length=1;
	}

	@Override
	String getShipType() {
	
		return "empty";
	}

	@Override
	boolean shootAt(int row, int column) {

		return false;
	}

	@Override
	boolean isSunk() {

		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}

}
