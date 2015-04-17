package battleship;

public class Battleship extends Ship {
//Describes a ship of length 4
	/**
	 * bulid a ship object with length 4
	 */
	public Battleship() {
		// TODO Auto-generated constructor stub
		length=4;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false,false,false,false};
	}
	/**
	 * return the type of the ship
	 */
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "battleship";
	}
}

