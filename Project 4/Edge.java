//Vincent Ou
//CSC 172
import java.util.*;
import java.io.*;
public class Edge {
    public Node v1, v2;
    public String value;
    public double distance;
    public Edge(String val, Node x, Node y){
	value = val;
	v1 = x;
	v2 = y;
	distance = distanceform(x,y);
    }
    public double distanceform(Node a1, Node a2){
	double lat1 = a1.latitude;
	double lon1 = a1.longitude;
	double lat2 = a2.latitude;
	double lon2 = a2.longitude;
	double dlon = lon2 - lon1;
	double dlat = lat2 - lat1;
	double a = Math.sin(dlat/2) * Math.sin(dlat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dlon/2) * Math.sin(dlon/2);
	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	double d = c * 3959;
	return d;
    }
}
