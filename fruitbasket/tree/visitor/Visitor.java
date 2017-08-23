package fruitbasket.tree.visitor;

/**
 * ���������
 * @param <E>
 */
public interface Visitor<E extends Comparable<E>> {
	//����ָ�����Է�����Щ����
	public void visit(BinaryTree<E> binaryTree);
}
