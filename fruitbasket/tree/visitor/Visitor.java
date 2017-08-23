package fruitbasket.tree.visitor;

/**
 * 抽象访问者
 * @param <E>
 */
public interface Visitor<E extends Comparable<E>> {
	//参数指定可以访问那些对象
	public void visit(BinaryTree<E> binaryTree);
}
