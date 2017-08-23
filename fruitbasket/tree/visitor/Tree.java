package fruitbasket.tree.visitor;

/**
 * Ê÷½Ó¿Ú
 * @param <E>
 */
public interface Tree<E extends Comparable<E>> {
	
	public boolean insert(E element);
	public boolean delete(E element);
	public int getSize();
	public boolean isEmpty();
}
