//Vincent Ou
//CSC 172
//2016 Jan 25th
import java.util.*;
import java.io.*;
public class Driver{
    
    public static void main(String[] args){
	boolean gamestart = false;
	String[] datacolors = new String[] {"RED","ORANGE","YELLOW","GREEN","BLUE","VIOLET","INDIGO","BLACK","WHITE","GOLD","SILVER","PINK"};
	
	// Decides if game starts
        while (!gamestart){
	    System.out.println("WELCOME TO MASTERMIND\nPRESS ENTER TO PLAY");
	    Scanner input = new Scanner(System.in);
	    String start = input.nextLine();
	    if (start.equals(""))
		gamestart = true;
	}
	/////////////////////////
	// Runs the game in a loop
	while (gamestart){
	    // Helps instigate new Mastermind class
	    Scanner input = new Scanner(System.in);
	    System.out.print("Please enter number of colors 1-12:");
	    int numcolors = input.nextInt();
	    String[] tokencolors = new String[numcolors];
	    System.out.print("Please enter number of positions 1-12:");
	    int positions = input.nextInt();
	    for(int i = 0;i < numcolors; i++)
		tokencolors[i] = datacolors[i];
	    Mastermind game = new Mastermind(tokencolors,positions);
	    //////////////////////////////////////////////////
	    // Runs game until computer finds solution to code
	    while(game.getGameStatus()){
		System.out.println("Guess: " + game.printArray(game.nextMove()));
		Scanner reply = new Scanner(System.in);
		System.out.println("Enter number of right colors but in wrong position: ");
		int colorsRightPositionWrong = reply.nextInt();
		System.out.println("Enter number of right colors in the right position: ");
		int positionsAndColorRight = reply.nextInt();
		game.response(colorsRightPositionWrong,positionsAndColorRight);
	    }
	    /////////////////////////////////////////
	    //Asks user if they still want to play
	    System.out.print("Play another? Enter Y or N: ");
	    Scanner input2 = new Scanner(System.in);
	    String ans = input2.nextLine();
	    if (ans.equals("N"))
		gamestart = false; //exits loop
	    else
		game.newGame();
	    //////////////////////////////////////////
	}
	
	//////////////////////////////
    }
}
