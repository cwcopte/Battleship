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
		String welcome = "Welcome to battleship game!\n s: start.\n r:check rules.\n q:quit.";
		System.out.println(welcome);
		

		//accept user input
		Scanner in = new Scanner(System.in);
		//in.nextLine();
		String typing=in.next();
		//while(in.hasNext()){
		boolean quit=false;
		while(!quit){
			if(typing.equals("q")){
				//quit the game
				quit=true;
			}else if(typing.equals("r")){
				//explain rules
				System.out.println("Battleship is usually a two-player game, where each player has a fleet and an ocean(hidden from the other player), and tries to be the first to sink the other player’s fleet.");
				typing=in.next();
			}else if(typing.equals("s")){
				
				if(game.ocean.isGameOver()){
					//clean the ocean
					game.ocean=new Ocean();
					game.ocean.placeAllShipsRandomly();
					game.ocean.print();
				}
				
				//problem exist for row1??
				//column 1-->refer to 0 and display
				
				//single ship only show s!!
				//hit count increase when repeatlly hit the same place! single
				System.out.println("Please enter row and column to play using ',' to seperate.");
				String userInput=in.next();
				String[] input;
				input=userInput.split(",");
				while(input.length!=2){
					System.out.println("Please enter two numbers for row(0-9) and column(0-9) to play using ',' to seperate.");
					userInput=in.next();
					input=userInput.split(",");
				}

				try {
					int row=Integer.parseInt(input[0]);
					int column=Integer.parseInt(input[1]);
					//System.out.println(row);
					//System.out.println(column);
					game.ocean.shootAt(row,column);
					System.out.println(game.getStatus());
				}
				catch (Exception e) {
					System.out.println("Invalid input. Please enter integer for row and column, using space to separate (row column).");
				}
				if(game.ocean.isGameOver()){
					System.out.println("Congradulations! You have finished the game and here is the result:");
					System.out.println(game.getStatus());
					//clean up and ask if play again!
					System.out.println("Enter y to play again. Enter q to quit!");
					String playAgain=in.next();
					//equal method useful?
					
					while(!(playAgain.equals("q")||playAgain.equals("y"))){
						System.out.println("Please input correctly. Enter y to play again. Enter q to quit!");
						playAgain=in.next();
					}
					if(playAgain.equals("q")){
						typing="q";
					}else if(playAgain.equals("y")){
						typing="s";
					}
					
				}
			}
			else {
				//explain rules
				System.out.println("Please enter s to start game, r to check rules, q to exit.");
				typing=in.next();
			}
		}
	}
    /**
     * demonstrate how many shots have been fired, how many attacks are successful, and how many ships have s
     * @return
     */
	//print final scores
	public String getStatus(){
		String result;
		result="Up to now, there are "+this.ocean.getShotsFired()+" shot(s) fired.";
		result+="Successfully atack: "+this.ocean.getHitCount()+" time(s). ";
		result+=this.ocean.getShipsSunk()+" ship(s) sunked";

		this.ocean.print();

		return result;
	}

}
