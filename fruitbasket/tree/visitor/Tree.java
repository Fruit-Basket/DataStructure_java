package fruitbasket.tree.visitor;

/**
 * ���ӿ�
 * @param <E>
 */
public interface Tree<E extends Comparable<E>> {
	
	public boolean insert(E element);
	public boolean delete(E element);
	public int getSize();
	public boolean isEmpty();
}
