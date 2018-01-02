import java.util.*;
import java.io.*;

public class Locator{
    public static void main(String[] args) throws IOException{
	AltBinSearchTree x = new AltBinSearchTree();
	ArrayList lines = new ArrayList();
	if (args.length > 0){
	    ReadFile file = new ReadFile(args[0]);
	    String[] input = file.OpenFile();
	    ArrayList newa = new ArrayList(Arrays.asList(input));
	    for(int i = 0; i < newa.size(); i++){
		String in = (String) newa.get(i);
		ArrayList splity = new ArrayList(Arrays.asList(in.split(" ")));
		splity.remove("");
		newa.set(i, splity);
	    }
	    for(int i = 0; i< newa.size();i++){
		for(int j = 0; j< ((ArrayList)newa.get(i)).size(); j++){
		    Double a = new Double(((ArrayList)newa.get(i)).get(j).toString());
		}
	    }
	    int count = 0;
	    for(int i = 0; i< newa.size(); i++){
		//for(int j = 0; j < ((ArrayList)newa.get(i)).size(); j++){
		    if(i == 0)
			count = Integer.valueOf(((ArrayList)newa.get(0)).get(0).toString());
		    else if(i <= count){
			Double d1 = new Double(((ArrayList)newa.get(i)).get(0).toString());
			Double d2 = new Double(((ArrayList)newa.get(i)).get(1).toString());
			Double d3 = new Double(((ArrayList)newa.get(i)).get(2).toString());
			Double d4 = new Double(((ArrayList)newa.get(i)).get(3).toString());
			Point p1 = new Point(d1,d2);
			Point p2 = new Point(d3,d4);
			Line l1 = new Line(p1,p2);
			lines.add(l1);
			x.insert(l1);
		    }
		    else{
		        Double d1 = new Double(((ArrayList)newa.get(i)).get(0).toString());
			Double d2 = new Double(((ArrayList)newa.get(i)).get(1).toString());
			Double d3 = new Double(((ArrayList)newa.get(i)).get(2).toString());
			Double d4 = new Double(((ArrayList)newa.get(i)).get(3).toString());
			Point p1 = new Point(d1,d2);
			Point p2 = new Point(d3,d4);
			if(x.separated(p1,p2) != -1)
			    ((Line)lines.get(x.separated(p1,p2))).print();
		    }
		    
	    }
	    System.out.println(x.countLeaves());
	    System.out.println(x.avglength());
	    //System.out.println(newa);
	}
	
    }
}
