public class Point{
    private double xval;
    private double yval;

    public Point(){
    }
    public Point(double x, double y){
	xval = x;
	yval = y;
    }
    public double getX(){
	return xval;
    }
    public double getY(){
	return yval;
    }
    public void setX(double x){
	xval = x;
    }
    public void setY(double y){
	yval = y;
    }
    public void setLocation(double x, double y){
	xval = x;
	yval = y;
    }
}
