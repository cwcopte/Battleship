package battleship;

public class Destroyer extends Ship{
// Describes a ship of length 2
	/**
	 * build a ship object with length 2
	 */
	public Destroyer() {
		// TODO Auto-generated constructor stub
		length=2;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false,false};
	}
    /**
     * return the type of the object
     */
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "destroyer";
	}

}
