//Vincent Ou
//CSC172 

public interface Queue<T>{
    public boolean isEmpty();
    public void enqueue(T x);
    public T dequeue();
    public T peek();
}
