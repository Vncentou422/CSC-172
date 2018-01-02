//Vincent Ou
//CSC 172

import java.util.*;
import java.io.*;

public class DLList<T> implements DoublyLinkedList<T>{
    private DLLNode<T> head, tail;
    private int size;
    
    public DLList(){
	head = tail = null;
	size = 0;
    }
    
    public void insert(T x){
	insertLast(x);
    }
    public void insert(int i, T newVal){
	if (i < 0 || i > size)
	    throw new IndexOutOfBoundsException();
	else if (i == size)
	    insert(newVal);
	
	DLLNode<T> temp = new DLLNode<T>(newVal, null, null);
	
	if (i == 0)
	    insertFirst(newVal);
	else{
	    DLLNode<T> tmp1 = head;
	    for(int x = 0; x< i-1; x++)
		tmp1 = tmp1.getNext();
	    DLLNode<T> tmp2 = tmp1.getNext();
	    temp.setNext(tmp2);
	    temp.setPrev(tmp1);
	    tmp1.setNext(temp);
	    tmp2.setPrev(temp);
	    size++;
	}
    }
    public void insertFirst(T newVal){
	head = new DLLNode<T> (newVal, null, head);
	if (size == 0)
	    tail = head;
	else
	    head.getNext().setPrev(head);
	size++;
    }
    public void insertLast(T newVal){
	tail = new DLLNode<T>(newVal, tail, null);
	if (size == 0)
	    head = tail;
	else
	    tail.getPrev().setNext(tail);
	size++;
    }
    public T getFirst(){return head.getData();}
    public T getLast() {return tail.getData();}
    public void deleteFirst(){
	if (size == 1){
	    head = tail = null;
	}
	else{
	    head = head.getNext();
	    head.setPrev(null);
	}
	size--;	
    }
    public void deleteLast(){
	if (size == 1){
	    head = tail = null;
	}
	else{
	    tail = tail.getPrev();
	    tail.setNext( null);
	}
	size--;
    }
    public void delete(int index){
	if ( index == 0)
	    deleteFirst();
	else if (index == size - 1)
	    deleteLast();
	else{
	    DLLNode<T> tmp1 = head;
	    for (int i = 0; i < index - 1; i++){
		tmp1 = tmp1.getNext();	
	    }
	    tmp1.setNext(tmp1.getNext().getNext());
	    tmp1.getNext().setPrev(tmp1);
	    size--;
	}
    }
    public int size() {return size;}
    public void set(int i, T newVal){
	if (i < 0 || i >= size)
	    throw new IndexOutOfBoundsException();
	DLLNode<T> temp = head;
	for(int x = 0; x < i; x++)
	    temp = temp.getNext();
	temp.setData(newVal);
    }
    public void delete(T x){
	if (lookup(x) != null)
	    delete(find(x));
	
    }
    public boolean contains(T x){
        DLLNode temp = head;
	while(temp != null){
	    if(x.equals(temp.getData()))
		return true;;
	    temp = temp.getNext();
	}
	return false;
    }
    public int find(T x){
	DLLNode temp = head;
	int counter = 0;
	while(temp != null){
	    if(x.equals(temp.getData()))
		return counter;
	    temp = temp.getNext();
	    counter++;
	}
	return -1;
    }
    public T lookup(T x){ 
	DLLNode temp = head;
	while(temp != null){
	    if(x.equals(temp.getData()))
		return (T)temp.getData();
	    temp = temp.getNext();
	}
	return null;
    }
    public boolean isEmpty(){return size == 0;}
    public void printList(){
	String x = "";
	DLLNode temp = head;
	if(isEmpty()){
	    return;
	}
	while(temp != null){
	    x += temp.toString();
	    temp = temp.getNext();
	}
	System.out.println(x);
    }
    public void printListRev(){
	String x = "";
        DLLNode temp = tail;
	if(isEmpty()){
	    return;
	}
	while (temp != null){
	    x += temp.toString();
	    //System.out.println(x);
	    temp = temp.getPrev();
	}
	System.out.println(x);
    }
}
