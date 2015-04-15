package battleship;

public class Destroyer extends Ship{
// Describes a ship of length 2
	public Destroyer() {
		// TODO Auto-generated constructor stub
		length=2;
	}

	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "destroyer";
	}

}
