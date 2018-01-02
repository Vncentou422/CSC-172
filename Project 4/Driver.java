//Vincent Ou
//CSC 172
import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args) throws IOException{
	if (args[0] != null){
	    ReadFile file = new ReadFile(args[0]);
	    String[] input = file.OpenFile();
	    ArrayList newa = new ArrayList(Arrays.asList(input));
	    ArrayList newVert = new ArrayList();
	    ArrayList newEdg = new ArrayList();
	    int counter = 0;
	    for(int i = 0; i < newa.size(); i++){
		String[] line = ((String)newa.get(i)).split("\\s+");
		if(((String)line[0]).equals("i")){
		    Node x = new Node(line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]),counter);
		    newVert.add(x);
		    counter++;
		}
		else{
		    break;
		}
	    }
	    Graph g = new Graph(newVert.size());
	    g.setVert(newVert);
	    for(; counter < newa.size(); counter++){
		String[] line = ((String)newa.get(counter)).split("\\s+");
		Node a1 = new Node();
		Node a2 = new Node();
		if(((String)line[0]).equals("r")){
		    for(int i = 0; i < newVert.size(); i++){
			if(line[2].equals(((Node)newVert.get(i)).value))
			    a1 = (Node)newVert.get(i);
			else if(line[3].equals(((Node)newVert.get(i)).value))
			    a2 = (Node)newVert.get(i);
		    }
		    Edge e1 = new Edge(line[1], a1,a2);
		    newEdg.add(e1);
		    g.insert(e1);
		}
	    }
	    g.setEdg(newEdg);
	    
	    g.print();
	    System.out.println(g.shortestPathto("i2","i14"));;
	}
	
    }
}
