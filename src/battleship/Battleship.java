package battleship;

public class Battleship extends Ship {
//Describes a ship of length 4
	public Battleship() {
		// TODO Auto-generated constructor stub
		length=4;
	}
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "battleship";
	}
}
