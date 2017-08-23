package fruitbasket.tree;


public abstract class AbstractTree<E extends Comparable<E>> 
	implements Tree<E>{
	
	@Override
	public boolean isEmpty(){
		return getSize()==0;
	}
	
	@Override
	public Iterator<E> iterator(){
		return null;
	}
}
