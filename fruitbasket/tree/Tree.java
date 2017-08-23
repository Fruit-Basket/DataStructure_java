package fruitbasket.tree;

/**
 * Ê÷½Ó¿Ú
 * @param <E>
 */
public interface Tree<E extends Comparable<E>> {
	
	public boolean insert(E element);
	public boolean delete(E element);
	public int getSize();
	public boolean isEmpty();
	
	public Iterator<E> iterator();
}
