package battleship;

public class Cruiser extends Ship {
//Describes a ship of length 3.
	/**
	 * build a ship object with length 3
	 */
	public Cruiser() {
		length=3;
		// TODO Auto-generated constructor stub
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false,false,false};
	}
	/**
	 * return the type of the object
	 */
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "cruiser";
	}

}

