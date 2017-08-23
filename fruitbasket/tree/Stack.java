package fruitbasket.tree;

import java.util.ArrayList;

/**
 * ջ
 * @param <E>
 */
public class Stack<E> {
	private ArrayList<E> list;
	private int capacity;
	
	public Stack(int capacity){
		this.capacity=capacity;
		list=new ArrayList<E>(capacity);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public E peek(){
		return list.get(getSize()-1);
	}
	
	public void push(E element){
		list.add(element);
	}
	
	public E pop(){
		E element=list.get(getSize()-1);
		list.remove(getSize()-1);
		return element;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}

	public boolean isFull(){
		return capacity==list.size();
	}
	
	public void clear(){
		 list.clear();
	}
}
