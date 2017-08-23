package fruitbasket.tree.visitor;

import fruitbasket.tree.visitor.BinaryTreeNode;

/**
 * ���������
 * @param <E>
 */
public class IteratorVisitor<E extends Comparable<E>> implements Visitor<E> {
	
	@Override
	/**
	 * ����BinaryTree�������������߼�
	 */
	public void visit(BinaryTree<E> binaryTree) {
		//�����߼�������������н��
	    preorder(binaryTree.getRoot());
	    System.out.println();
	}
	

	private void preorder(BinaryTreeNode<E> subRoot){
		if(subRoot!=null){
			System.out.print(subRoot.getElement()+"  ");	//���ʵ�ǰ���
			preorder(subRoot.getLeft());
			preorder(subRoot.getRight());
		}
	}
}
