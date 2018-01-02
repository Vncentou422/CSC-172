//Vincent Ou
//CSC 172
import java.io.*;
import java.util.*;
public class PostfixCalc{
    private ArrayList operators;
    private Stacks stack;
    public PostfixCalc(){
	stack = new Stacks();
	operators = new ArrayList();
	operators.addAll(Arrays.asList("+","-","*","/","(",")","<",">","=","&","|","!","^"));
    }
    public double evaluate(ArrayList x){
	while(x.size() > 0){
	    // stack.print();
	    if(!operators.contains(x.get(0))){
		//System.out.println(x.get(0));
		stack.push(x.get(0));
		//stack.print();
		//System.out.println("hello");
		x.remove(0);
	    }
	    else{
		//stack.print();
		if (x.get(0).equals("+")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    double x3 = x2 + x1;
		    x.remove(0);
		    stack.push(x3);
		}
		else if (x.get(0).equals("-")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    double x3 = x2 - x1;
		    x.remove(0);
		    stack.push(x3);
		}
		else if (x.get(0).equals("*")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    double x3 = x1 * x2;
		    x.remove(0);
		    stack.push(x3);
		}
		else if (x.get(0).equals("/")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    double x3 = x2 / x1;
		    x.remove(0);
		    stack.push(x3);
		}
		else if (x.get(0).equals("<")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    boolean x3 = x2 < x1;
		    x.remove(0);
		    if(x3)
			stack.push(1.0);
		    else
			stack.push(0.0);
		}
		else if (x.get(0).equals(">")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    boolean x3 = x2 > x1;
		    x.remove(0);
		    if(x3)
			stack.push(1.0);
		    else
			stack.push(0.0);
		}
		else if (x.get(0).equals("=")){
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    boolean x3 = (x2 == x1);
		    x.remove(0);
		    //stack.push(x3);
		    if(x3)
			stack.push(1.0);
		    else
			stack.push(0.0);
		}
		else if (x.get(0).equals("&")){
		    /*
		    boolean x1 = true;
		    boolean x2 = false;
		    int count = 2;
		    for(;count > 0; count++){
			if(count == 2){
			    if (stack.peek().equals("1") || stack.peek().equals("true")){
				stack.pop();
				stack.push(true);
				x1 = Boolean.parseBoolean(stack.pop().toString());
			    }
			    
			    if (stack.peek().equals("0") || stack.peek().equals("false")){
				stack.pop();
				stack.push(false);
				x1 = Boolean.parseBoolean(stack.pop().toString());
			    }
			}
			else{
			    if (stack.peek().equals("1") || stack.peek().equals("true")){
				stack.pop();
				stack.push(true);
				x2 = Boolean.parseBoolean(stack.pop().toString());
			    }
			    
			    if (stack.peek().equals("0") || stack.peek().equals("false")){
				stack.pop();
				stack.push(false);
				x2 = Boolean.parseBoolean(stack.pop().toString());
			    }
			}
		    }
		    
		    boolean x3 = x2 & x1;
		    x.remove(0);
		    if(x3)
			stack.push(1.0);
		    else
			stack.push(0.0);
		    */
		    //System.out.println("hello2");
		    double x1 = Double.parseDouble(stack.pop().toString());
		    //System.out.println(x1);
		    double x2 = Double.parseDouble(stack.pop().toString());
		    boolean y1, y2;
		    if (x1 == 1.0)
			y1 = true;
		    else
			y1 = false;
		    if (x2 == 1.0)
			y2 = true;
		    else
			y2 = false;
		    if (y2 & y1){
			stack.push(1.0);
			//System.out.println("hello");
		    }
		    else
			stack.push(0.0);
		    x.remove(0);
		}
		else if (x.get(0).equals("|")){
		    /*
		    boolean x1 =true;
		    boolean x2 =true;
		    int count = 2;
		    for(;count > 0; count++){
			if(count == 2){
			    if (stack.peek().equals("1") || stack.peek().equals("true")){
				stack.pop();
				stack.push(true);
				x1 = Boolean.parseBoolean(stack.pop().toString());
			    }
			    
			    if (stack.peek().equals("0") || stack.peek().equals("false")){
				stack.pop();
				stack.push(false);
				x1 = Boolean.parseBoolean(stack.pop().toString());
			    }
			}
			else{
			    if (stack.peek().equals("1") || stack.peek().equals("true")){
				stack.pop();
				stack.push(true);
				x2 = Boolean.parseBoolean(stack.pop().toString());
			    }
			    
			    if (stack.peek().equals("0") || stack.peek().equals("false")){
				stack.pop();
				stack.push(false);
				x2 = Boolean.parseBoolean(stack.pop().toString());
			    }
			}
		    }
		    boolean x3 = x2 || x1;
		    x.remove(0);
		    if(x3)
			stack.push(1.0);
		    else
			stack.push(0.0);
		    */
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    boolean y1, y2;
		    
		    if (x1 == 1.0)
			y1 = true;
		    else
			y1 = false;
		    if (x2 == 1.0)
			y2 = true;
		    else
			y2 = false;
		    if (y2 || y1)
			stack.push(1.0);
		    else
			stack.push(0.0);
		    x.remove(0);
		}
		else if (x.get(0).equals("!")){
		    boolean x1 = true;
		    if (stack.peek().equals("0") || stack.peek().equals("0.0")){
			stack.pop();
			stack.push("1.0");
		    }
		    else if(stack.peek().equals("1") || stack.peek().equals("1.0") || (double)stack.peek() == 1.0){
			stack.pop();
		        stack.push("0.0");
		    }
		    else
			x1 = Boolean.parseBoolean(stack.pop().toString());
		    x.remove(0);
		   
		}
		else{
		    double x1 = Double.parseDouble(stack.pop().toString());
		    double x2 = Double.parseDouble(stack.pop().toString());
		    x.remove(0);
		    stack.push(Math.pow(x1,x2));
		}
	    }
	}
	if(!stack.isEmpty()){
	    /*
	    if (Boolean.parseBoolean(stack.peek().toString()))
		return 1.00;
	    else if(stack.peek().equals(false))
		return 0.00;
	    else
	    */
		return Double.parseDouble(stack.pop().toString());
	}
	return 0.1;
    }
}

