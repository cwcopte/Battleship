package battleship;

public class EmptySea  extends Ship{
	//Describes a part of the ocean that doesn’t have a ship in it.
	public EmptySea() {

		length=1;
		//hit=new boolean[]{false,false,false,false};
		hit=new boolean[]{false};
	}

	@Override
	String getShipType() {

		return "empty";
	}
	//return what and how to determined ever being hit or what?




	@Override
	boolean isSunk() {

		return false;
	}

	@Override
	boolean shootAt(int row, int column) {

		hit[0]=true;
		/*
			if(row==this.getBowRow()&& column==this.getBowColumn()){
				hit[0]=true;
			}*/
		return false;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}

}
