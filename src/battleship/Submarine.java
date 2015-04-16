package battleship;

public class Submarine extends Ship{
//Describes a ship of length 1
	public Submarine() {
		// TODO Auto-generated constructor stub
		length=1;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false };
	}
	@Override
	String getShipType() {
		// TODO Auto-generated method stub
		return "submarine";
	}
}
