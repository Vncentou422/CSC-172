//Vincent Ou
//CSC 172
import java.util.*;
import java.io.*;
public class InfixCalc{
    public static void main(String[] args) throws IOException{
	PostfixCalc x = new PostfixCalc();
	InfixPostfixConverter y = new InfixPostfixConverter();
        if (args.length > 0){
	    ReadFile file = new ReadFile(args[0]);
	    String[] input = file.OpenFile();
	    ArrayList newa = new ArrayList(Arrays.asList(input));
	   
	    for(int i = 0; i < newa.size(); i++){
		if(newa.get(i) == " ")
		    newa.remove(i);
	    }
	    //System.out.println(newa);
	    PrintWriter out = new PrintWriter(args[1]);
	    for(int i = 0; i < input.length; i++){
		//System.out.println(y.convertInfPos(((String)newa.get(i)).trim().replaceAll("\\s","")));
		out.println(x.evaluate(y.convertInfPos(((String)newa.get(i)).trim().replaceAll("\\s",""))));

	    }
	    out.close();
	}
	
    }
}
