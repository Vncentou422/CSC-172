public class Line{
    private Point p1;
    private Point p2;

    public Line(){}
    public Line(Point x, Point y){
	if(x.getX() <= y.getX()){
	    p1 = x;
	    p2 = y;
	}
	else{
	    p1 = y;
	    p2 = x;
	}
    }
    public double slope(){
	return (p1.getY() - p2.getY())/(p1.getX() - p2.getX());
    }
    public Point getPoint1(){
	return p1;
    }
    public Point getPoint2(){
	return p2;
    }
    public Point intersection(Line x){
	// nx - nx2 + y2 = mx  - mx1 + y1, 
	//nx - mx= nx2 - y2 - mx1 + y1
	//x = nx2 - y2 - mx1 + y1 /(n- m)
	if (slope() == x.slope())
	    return null;
	else{
	    Point pt1 = x.getPoint1();
	    double xval = ((x.slope() * pt1.getX()) - pt1.getY() - (slope() * p1.getX()) + p1.getY())/(x.slope() - slope());
	    //y = mx - mx1 + y1
	    double yval = slope() * xval - slope() * p1.getX() + p1.getY();
	    Point retVal = new Point(xval,yval);
	    return retVal;
	}
    }
    public void print(){
	System.out.println("" + p1.getX() + "," + p1.getY() + " " + p2.getX() + "," + p2.getY());
    }
}
