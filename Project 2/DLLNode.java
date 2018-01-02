public class DLLNode<T>{
    private T data;
    private DLLNode<T> next, prev;
    
    public DLLNode(T value, DLLNode<T> p, DLLNode<T> n){
	data = value;
	prev = p;
	next = n;
    }
    
    public T getData(){
	return data;
    }
    public DLLNode<T> getNext(){
	return next;
    }
    public DLLNode<T> getPrev(){
	return prev;
    }
    public void setNext(DLLNode<T> n){
	next = n;
    }
    public void setPrev(DLLNode<T> p){
	prev = p;
    }
    public void setData(T x){
	data = x;
    }
    public String toString(){
	return data.toString();
    }
}
