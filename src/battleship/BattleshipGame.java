package battleship;

import java.util.Scanner;

public class BattleshipGame {
	private Ocean ocean;
	public BattleshipGame() {
		ocean=new Ocean();
		// TODO Auto-generated constructor stub
	}
	/**
	 * accept ”shots” from the user; display the results; print
final scores; and ask the user if he/she wants to play again. 
	 * @param args
	 */
	public static void main(String[] args){
		BattleshipGame game=new BattleshipGame();

		game.ocean.placeAllShipsRandomly();
		
		//start of the game
		String welcome = "Welcome to battleship game!";
		System.out.println(welcome);
		System.out.println(game.getStatus());
		/*
		//accept user input
		Scanner in = new Scanner(System.in);
		//in.nextLine();
	
		while(in.hasNext()){
			
			if(in.nextLine()!="q"){

				System.exit(0);
			}
			else{
				//accept hit location
				String userInput=in.nextLine();
				String[] input;
				input=userInput.split(" ");
				if(input.length==2){
					try {
					int row=Integer.parseInt(input[0]);
					int column=Integer.parseInt(input[1]);
					}

					catch (Exception e) {
						System.out.println("Please enter integer for row and column, using space to separate");
						//print  result
						//System.out.print();
					}
				}
			}
		}*/
	}

//print final scores
	public String getStatus(){
		String result;
		result="Up to now, there are "+this.ocean.getShotsFired()+" shots fired.";
		result+=this.ocean.getShipsSunk()+" sunked";
		
		this.ocean.print();
		
		return result;
	}
	public int getFinalScores(){
		
		//return, hits, sunked, rate of shooting successfully
		System.out.println("successfully get "+this.ocean.getHitCount()/this.ocean.getShotsFired());
		//how to  caculate?
		return 0;
	}
}
