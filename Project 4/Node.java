//Vincent Ou
//CSC 172
import java.util.*;
import java.io.*;

public class Node{
    public double dist = Double.POSITIVE_INFINITY;
    public boolean known = false;
    public int number;
    public int updator;
    public String value = "";
    public double latitude = 0.00;
    public double longitude = 0.00;
    public PriorityQueue<Node> vertexQueue;
    public Node(){
    }
    public Node(String x, double y, double z, int num){
	number = num;
	value = x;
	latitude = y;
	longitude = z;
	vertexQueue = new PriorityQueue<Node>();
	
    }
}
