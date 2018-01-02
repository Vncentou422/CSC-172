//Vincent Ou
//CSC 172

public class Queues<T> implements Queue<T>{
    private DLList<T> queuey;
    private int size;
    
    public Queues(){
	queuey = new DLList<T>();
	size = 0;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public void enqueue(T x){
	queuey.insert(x);
	size++;
    }
    public T dequeue(){
	if (isEmpty())
	    return null;
	else{
	    T x = queuey.getFirst();
	    queuey.deleteFirst();
	    size--;
	    return x;
	}
    }
    public T peek(){
	if (isEmpty())
	    return null;
	else
	    return queuey.getFirst();
    }
}
