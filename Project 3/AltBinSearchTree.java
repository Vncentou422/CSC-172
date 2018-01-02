import java.util.*;
import java.io.*;
import java.awt.*;

public class AltBinSearchTree{

    TreeNode _root;
    int numlines;
    int size;
    public AltBinSearchTree(){
	_root = null;
	numlines = -1;
	size = 0;
    }
    public int ccw(Point p0, Point p1, Point p2){
        double dx1 = p1.getX() - p0.getX();
       double dy1 = p1.getY() - p0.getY();
       double dx2 = p2.getX() - p0.getX();
       double dy2 = p2.getY() - p0.getY();
	if (dx1 * dy2 > dy1 * dx2)
	    return 1; //counterclockwise
	else if(dx1*dy2 < dy1*dx2)
	    return -1; //clockwise
	else if((dx1*dx2 < 0) || (dy1*dy2< 0))
	    return -1; //clockwise
	else if((dx1*dx1+dy1*dy1)<(dx2*dx2+dy2*dy2))
	    return 1; //counterclockwise
	else
	    return 0; //colinear
    }
    public void insert(Line x){
	if (_root == null){
	    TreeNode newNode = new TreeNode();
	    newNode.setLine(x);
	    numlines++;
	    newNode.setLineNum(numlines);
	    newNode.setLeft(null);
	    newNode.setRight(null);
	    _root = newNode;
	    size++;
	    return;
	}
	else{
	    inserthelper(_root, x);
	    size++;
	}
    }
    public void inserthelper(TreeNode root, Line x){
	int ccwp1 = ccw(x.getPoint1(), root.getLine().getPoint1(), root.getLine().getPoint2());
	int ccwp2 = ccw(x.getPoint2(), root.getLine().getPoint1(), root.getLine().getPoint2());
	//System.out.println("" + (numlines+1) + " " + ccwp1 + " " + ccwp2);
	//root.getLine().print();
	if((ccwp1 <= 0) && (ccwp2 <= 0)){
	    if(root.getLeft() == null){
		numlines++;
		TreeNode newNode = new TreeNode(x, numlines);
		root.setLeft(newNode);
	    }
	    else
		inserthelper(root.getLeft(), x);
	}
	else if((ccwp1 >= 0) && (ccwp2 >= 0)){
	    if(root.getRight() == null){
		numlines++;
		TreeNode newNode = new TreeNode(x,numlines);
		root.setRight(newNode);
	    }
	    else
		inserthelper(root.getRight(),x);
	}
	else{
	    Point intersect = x.intersection(root.getLine());
	    Line a = new Line(x.getPoint1(), intersect);
	    Line b = new Line(intersect, x.getPoint2());
	    if (ccwp1 >= 0){
		if ((root.getLeft() == null) && (root.getRight() == null)){
		    numlines++;
		    TreeNode aa= new TreeNode(a, numlines);
		    TreeNode bb = new TreeNode(b, numlines);
		    root.setLeft(aa);
		    root.setRight(bb);
		}
		
		else{
		    inserthelper(root.getRight(), a);
		    numlines--;
		    inserthelper(root.getLeft(),b);
		    
		}
	    }
	    else{
		if ((root.getLeft() == null) && (root.getRight() == null)){
		    numlines++;
		    TreeNode aa= new TreeNode(a, numlines);
		    TreeNode bb = new TreeNode(b, numlines);
		    root.setLeft(aa);
		    root.setRight(bb);
		}
		else{
		    inserthelper(root.getLeft(), a);
		    numlines--;
		    inserthelper(root.getRight(),b);
		    
		}
	    }
	}
    }
    public TreeNode getRoot(){
	return _root;
    }
    public void swap(){
	TreeNode x = _root.getLeft();
	_root.setLeft(_root.getRight());
	_root.setRight(x);
    }
    public void print(){
	if (_root == null)
	    return;
	else
	    print(_root);
    }
    public void print(TreeNode x){
	if (x.getLeft() != null){
	    print(x.getLeft());
	}
	System.out.print(x.getLineNum() + " " );
	x.getLine().print();
	if (x.getRight() != null){
	    print(x.getRight());
	}
    }
    /*
    public TreeNode findParent(Point x){
	return findParent(_root, x);
    }
    public TreeNode findParent(TreeNode root, Point x){
	int ccwp = ccw(x, root.getLine().getPoint1(), root.getLine().getPoint2());
	if((root.getLeft() == null) && (root.getRight() == null))
	    return root;
	else if(ccwp <= 0)
	    return findParent(root.getLeft(), x);
	else
	    return findParent(root.getRight(),x);
    }
    */
    public ArrayList findParent(Point x){
	ArrayList retArr = new ArrayList();
	return findParent(_root, x, retArr);
    }
    public ArrayList findParent(TreeNode root, Point x, ArrayList ret){
	int ccwp = ccw(x, root.getLine().getPoint1(), root.getLine().getPoint2());
	ret.add(root);
	if((root.getLeft() == null) && (root.getRight() == null))
	    return ret;
	
	else if(ccwp <= 0)
	    return findParent(root.getLeft(), x, ret);
	else
	    return findParent(root.getRight(),x, ret);
    }
	    
    public int separated(Point x, Point y){
	ArrayList a = findParent(x);
	ArrayList b = findParent(y);
	if(a.get(a.size() - 1).equals(b.get(b.size()-1))){
	    System.out.println("Not separated by a line");
	    return -1;
	}
	else{
	    for(int i = a.size() - 1; i > -1; i--){
		for(int j = b.size() - 1; j > -1; j--){
		    if(a.get(i).equals(b.get(j))){
			TreeNode ret = (TreeNode) a.get(i);
			return ret.getLineNum();
			
		    }
		}
	    }
	    return -1;
	    
	}
    }
    public int countLeaves(){
	if (_root == null)
	    return 0;
	else
	    return countLeaves(_root);
    }
    public int countLeaves(TreeNode node){
	if( node == null )
	    return 0;
	if( node.getLeft() == null && node.getRight() == null ) {
	    return 1;
	}
	else {
	    return countLeaves(node.getLeft()) + countLeaves(node.getRight());
	}
    }
    public int externallength(){
	if(_root == null)
	    return 0;
	else
	    return externallength(_root);
    }
    public int externallength(TreeNode node){
	if(node == null)
	    return 0;
	if(node.getLeft() == null && node.getRight() == null){
	    return 1;
	}
	else{
	    return externallength(node.getLeft()) + externallength(node.getRight()) + 2;
	}
    }
    public double avglength(){
	return ((double)externallength())/((double)countLeaves());
    }
}
	    
	
		   
		   
    
	    
