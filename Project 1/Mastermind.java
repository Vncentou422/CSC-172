//Vincent Ou
//CSC 172
//2016 Jan 25
import java.util.*;
import java.io.*;

public class Mastermind{
    private String[] code;
    private boolean gamestatus;
    private String[] choicecolors;
    private String[] allchoicess;
    private String[] guess;

    public Mastermind(String[] tokencolors, int positions){
	gamestatus = true;
	choicecolors = tokencolors;
	// MASTERMIND CODE GENERATION PROCESS////////////////////////////////
        code = new String[positions];
	System.out.println("Please enter in the order of colors for the code, choosing from the list of colors given here:");
	System.out.println(printArray(tokencolors));
	System.out.println();
	int i = 0;
	while (i <= positions){
	    Scanner input = new Scanner(System.in);
	    if (i == positions){
		System.out.println(printArray(code));
		System.out.print("is this correct? enter Y or N:");
		String ans = input.nextLine();
		if (ans.equals("Y"))
		    i++;
		else
		    i=0;
	    }
	    else{
		System.out.print("Please enter color #" + (i+1) + ":");
		String color = input.nextLine();
		boolean found = false;
		for(String x: tokencolors)
		    if (color.equals(x))
			found = true;
		
		if (found){
		    code[i] = color;
		    i++;
		    System.out.println();
		}
		else
		    System.out.println("\nNot a color from the set\n");
	    }
	}
	allchoicess = permutation(choicecolors,code.length); 
	System.out.println("Code is " + printArray(code));  
	////////////////////////////////////////////////////////////////////
    }
    
    public void newGame(){ //resets ingame variables
	code = null;
	choicecolors = null;
	allchoicess = null;
	guess = null;
    }
    public void response(int colorsRightPositionWrong, int positionsAndColorRight){
	//Game code found
	if (colorsRightPositionWrong == 0 && positionsAndColorRight == code.length)
	    gamestatus = false;
	/// Otherwise, compare current guess to all possible guesses, and take out those
	/// that do not match.
	else{    
	    allchoicess = remove(allchoicess,0);
	    for (int count = 0; count < allchoicess.length; count++){
		String[] compareto = guess;
		String[] option = allchoicess[count].split(",");
		int match = 0;
		for(int i = 0; i < compareto.length; i++)
			if (compareto[i].equals(option[i])){
			    match++;
			    compareto = remove(compareto,i);
			    option = remove(option,i);
			    i--;
			}
	    
		int present = 0;
		for(int i = 0; i < compareto.length; i++)
		    for(int j = 0; j < option.length; j++){
			if(compareto[i].equals(option[j])){
			    option = remove(option,j);
			    j--;
			    present++;
			}
		    }
		if (present != colorsRightPositionWrong && match != positionsAndColorRight){
		    allchoicess = remove(allchoicess,count);
		   
		    count--;
		}
		
	    }
	}
    }
   
    
    public String[] nextMove() {
	//returns first choice in the list of all possible choices
	guess = allchoicess[0].split(",");
	return guess;
    }
     public String printArray(String[] x){
	String returrn = "";
	for(String y: x)
	    returrn +=  y + " ";
	return returrn;
     }
     
    public boolean getGameStatus(){
	return gamestatus;
    }
    public String[] remove(String[] x, int index){ //removes a value from given index
	String[] y = new String[x.length - 1];
	int j = 0;
	for (int i = 0; i < y.length; i++){
	    if (j != index){
		y[i] = x[j];
		j++;
	    }
	    else{
		i--;
		j++;
	    }
	}
	return y;
    }
    public String[] permutation(String[] tokencolors, int positions){ 
	//creates all possible combination of codes using permutation
	//Source: CSC 172 Pawlicki
        String[] allchoices = new String[(int)Math.pow(tokencolors.length,positions)];
	if (positions == 1)
	    return tokencolors;
	else{
	    String[] sub = permutation(tokencolors,positions - 1);
	    int x = 0;
	    for (int i = 0; i < tokencolors.length; i++){
		for(int j = 0; j < sub.length;j++){
		    allchoices[x] = tokencolors[i] + "," + sub[j];
		    x++;
		}
	    }
	}
	return allchoices;
    }
	
}

