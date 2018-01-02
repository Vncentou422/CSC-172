//Vincent Ou
//CSC 172

public class Driver{
    public static void main(String[] args){
	InfixPostfixConverter x = new InfixPostfixConverter();
	PostfixCalc y = new PostfixCalc();
	System.out.println(x.compareOp("+","-"));
	System.out.println(x.compareOp("+","*"));
	System.out.println(x.compareOp("*","^"));
	System.out.println(x.compareOp("!","&"));
	System.out.println(x.convertInfPos("1 + 1"));
	System.out.println(y.evaluate(x.convertInfPos("1 + 1")));
	System.out.println(y.evaluate(x.convertInfPos(("5.2 + 1"))));
	System.out.println(y.evaluate(x.convertInfPos(("5.2 + 1.0"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 - 1"))));
	System.out.println(y.evaluate(x.convertInfPos(("5.2 - 1"))));
	System.out.println(y.evaluate(x.convertInfPos(("1.0 - 5.2 "))));
	System.out.println(y.evaluate(x.convertInfPos(("3.0 * 4"))));
	System.out.println(y.evaluate(x.convertInfPos(("4 / 0.25"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 - (4 + 5)"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 - (1 - (4 + 5))"))));
	System.out.println(y.evaluate(x.convertInfPos(("0 < 55"))));
	System.out.println(y.evaluate(x.convertInfPos(("3.2 < 2.3"))));
	System.out.println(y.evaluate(x.convertInfPos(("0 > 55"))));
	System.out.println(y.evaluate(x.convertInfPos(("3.2 > 2.3"))));
	System.out.println(y.evaluate(x.convertInfPos(("5 = 5.0"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 = 1"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 = 0"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 & 1"))));
	System.out.println(y.evaluate(x.convertInfPos(("1 | 0"))));
	System.out.println(y.evaluate(x.convertInfPos(("0 | 0"))));
	System.out.println(y.evaluate(x.convertInfPos(("!0"))));
	System.out.println(y.evaluate(x.convertInfPos(("!1"))));
	System.out.println(y.evaluate(x.convertInfPos(("!(3 * (1 + 6) = 63 / 3)"))));
	System.out.println(y.evaluate(x.convertInfPos(("(1 < 3) & (2 > 4) | 1"))));
	
	
    }
}
