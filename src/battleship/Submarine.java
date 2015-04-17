package battleship;

public class Submarine extends Ship{
//Describes a ship of length 1
	/**
	 * create a ship object with length 1.
	 */
	public Submarine() {
		// TODO Auto-generated constructor stub
		length=1;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false };
	}
	/**
	 * return type submarine.
	 */
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "submarine";
	}
}
