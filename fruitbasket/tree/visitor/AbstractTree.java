package fruitbasket.tree.visitor;

/**
 * 抽象元素
 * @param <E>
 */
public abstract class AbstractTree<E extends Comparable<E>> 
	implements Tree<E>{
	
	@Override
	public boolean isEmpty(){
		return getSize()==0;
	}
	
	/**
	 * 允许谁来访问本类
	 * @param visitor 指定哪个对象可以访问本类
	 */
	public abstract void accpet(Visitor<E> visitor);
}
