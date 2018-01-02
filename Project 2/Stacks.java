//Vincent Ou
//CSC 172

public class Stacks<T> implements Stack<T>{
    private DLList<T> stacky;
    private int size;

    public Stacks(){
	stacky = new DLList();
	size = 0;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public void push(T x){
	stacky.insertFirst(x);
	size++;
    }
    public T pop(){
	
	if (isEmpty())
	    return null;
	else{
	    T x = peek();
	    stacky.delete(peek());
	    size--;
	    return x;

	}
    }
    public T peek(){
	return stacky.getFirst();
    }
    public void print(){
	stacky.printList();
    }
}
