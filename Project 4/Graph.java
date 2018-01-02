//Vincent Ou
//CSC 172
import java.util.*;
import java.io.*;

public class Graph{
    private int vertexCount, edgeCount;
    private double adj[][];
    private ArrayList vert;
    //private ArrayList vertt;
    private ArrayList edges;
    public Graph (int numVerticies){
	vertexCount = numVerticies;
	adj = new double[numVerticies][numVerticies];
	vert = new ArrayList();
	//vertt = new ArrayList();
	edges = new ArrayList();
	for(int i = 0; i < adj.length; i++){
	    for(int j = 0; j < adj[i].length; j++){
		adj[i][j] = Double.POSITIVE_INFINITY;
	    }
	}
    }

    public int vertices(){
	return vertexCount;
    }

    public int edges(){
	return edgeCount;
    }

    public void insert(Edge e){
	adj[e.v1.number][e.v2.number] = e.distance;
	adj[e.v2.number][e.v1.number] = e.distance;
    }

    public boolean connected(Node node1, Node node2){
	return (adj[node1.number][node2.number] != 0.0);
    }

    public void print(){
	System.out.println(Arrays.deepToString(adj));
    }
    public ArrayList getVert(){
	return vert;
    }
    public void setVert(ArrayList x){
	vert = x;
	//vertt = x;
    }
    public void setEdg(ArrayList x){
	edges = x;
    }
    public Node findMin(ArrayList x){
	Node y = (Node)x.get(0);
	for(int i = 0; i < x.size(); i++){
	    if (((Node)x.get(i)).dist < y.dist){
		y = (Node)x.get(i);
	    }
	}
	return y;
    }
    public ArrayList adjacency(Node x){
	int num = x.number;
	ArrayList adjj = new ArrayList();
	for(int j = 0; j < adj[num].length; j++){
	    if(adj[num][j] != Double.POSITIVE_INFINITY){
		adjj.add(vert.get(j));
	    }
	}
	return adjj;
    }
    public ArrayList shortestPathto(String x, String y){
	Node x1 = new Node();
	Node y1 = new Node();
	for(int i = 0; i < vert.size(); i++){
	    if(((Node)vert.get(i)).value.equals(x))
		x1 = ((Node)vert.get(i));
	    else if(((Node)vert.get(i)).value.equals(y))
		y1 = ((Node)vert.get(i));
	}
	return shortestPathto(x1,y1);
    }
    public ArrayList shortestPathto(Node source, Node target){
	ArrayList tmp = new ArrayList();
	for(int k = 0; k < vert.size(); k++){
	    tmp.add(vert.get(k));
	}
	ArrayList vertt = new ArrayList();
	source.dist = 0;
	source.updator = -1;
	tmp.set(tmp.indexOf(source), source);
	while (!tmp.isEmpty()){
	    Node u = findMin(tmp);
	    tmp.remove(u);
	    vertt.add(u);
	    ArrayList adj = adjacency(u);
	    for(int i = 0; i < adj.size(); i++){
		if(tmp.contains(adj.get(i))){
		    double alt = u.dist + ((Node)adj.get(i)).dist;
		    if (alt < ((Node)adj.get(i)).dist){
			((Node)adj.get(i)).dist = alt;
			((Node)adj.get(i)).updator = u.number;
			}
		}
	    }
	}
	ArrayList path = new ArrayList();
	path.add(((Node)vertt.get(vert.indexOf(target))).updator);
	int x = ((Node)vertt.get(vert.indexOf(target))).updator;
	while(x != -1){
	    System.out.println(x);
	    path.add(((Node)vertt.get(x)).updator);
	    x = ((Node)vertt.get(x)).updator;
	}
	ArrayList path2 = new ArrayList();
	while(!path.isEmpty()){
	    path2.add(path.get(path.size() - 1));
	}
	return path2;
    }
    
    
	    
		   
	    
		
	    
	
}

