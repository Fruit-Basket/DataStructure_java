package fruitbasket.tree;

/**
 * �������ӿ�
 * @param <E>
 */
public interface Iterator<E>{

	public boolean hasNext();
	public TreeNode<E> next();
}
