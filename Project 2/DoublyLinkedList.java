//Vincent Ou
//CSC 172

public interface DoublyLinkedList<T>{
    public void insert(T x);
    public void insert(int i, T newVal);
    public void set(int i, T newVal);
    public void delete(T x);
    public boolean contains(T x);
    public T lookup(T x);
    public boolean isEmpty();
    public void printList();
    public void printListRev();
}
