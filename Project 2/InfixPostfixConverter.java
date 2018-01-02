//Vincent Ou
//CSC 172
import java.io.*;
import java.util.*;

public class InfixPostfixConverter{
    private Stacks stack;
    private Queues queue;
    private ArrayList operators;
    public InfixPostfixConverter(){
	stack = new Stacks();
	queue = new Queues();
	operators = new ArrayList();
        operators.addAll(Arrays.asList("+","-","*","/","(",")","<",">","=","&","|","!","^"));
    }
    public ArrayList convertInfPos(String x){
	x = x.replaceAll("\\s+","");
	x = x.trim();
	ArrayList retVal = new ArrayList();
	while (!x.isEmpty()){
	    if(!(operators.contains(x.substring(0,1)))){
		int counter = 0;
		if (x.length() == 1){
		    queue.enqueue(x.substring(0,1));
		    x = "";
		}
		else{
		
		    while(!(operators.contains(x.substring(counter,counter+1)))){
			counter++;
			if((counter + 1) > x.length())
			    break;
		
		    }
		    
		    queue.enqueue(x.substring(0,counter));
		    x = x.substring(counter);
		}
	    }
	    else{
		//stack.print();
		//	System.out.println("current string :" + x);
		if(stack.isEmpty()){
		    stack.push(x.substring(0,1));
		    
		}
		else{
		    if (x.substring(0,1).equals(")")){
			while (!(stack.peek().equals("("))){
			    queue.enqueue(stack.pop());
			    
			}
			stack.pop();
		    }
		    else if(x.substring(0,1).equals("=")){
			while(!(stack.isEmpty() || stack.peek().equals("("))){
			    // if (!stack.peek().equals("("))
				queue.enqueue(stack.pop());
				//else
				//	break;
			}
			//queue.enqueue(x.substring(0,1));
			stack.push(x.substring(0,1));
		    }
		    else if(!(compareOp(x.substring(0,1), (String) stack.peek())) || stack.peek().equals("(") || stack.peek().equals("="))
			stack.push(x.substring(0,1));
		    else{
			while(!stack.isEmpty())
			    queue.enqueue(stack.pop());
			stack.push(x.substring(0,1));	
		    }
		}	
		if (x.length() == 1 || x.length() == 0){
		    //System.out.println(x);
		    x = "";
		}
		else{
		    x = x.substring(1);
		    
		}
		
	    }
	    
	}
	while (!stack.isEmpty()){
	    queue.enqueue(stack.pop());
	}
	while(!queue.isEmpty())
	    retVal.add(queue.dequeue());
	return retVal;
    }
    public boolean compareOp(String x, String y){ //is x lower precedence than y
	ArrayList comparison = new ArrayList();
	comparison.addAll(Arrays.asList(1,1,2,2,9,9,4,4,9,6,5,7,3));
	return ((int)comparison.get(operators.indexOf(x))< (int)comparison.get(operators.indexOf(y))); 
    }
}
