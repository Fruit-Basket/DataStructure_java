package fruitbasket.tree.visitor;

import fruitbasket.tree.visitor.BinaryTreeNode;

/**
 * 具体访问者
 * @param <E>
 */
public class IteratorVisitor<E extends Comparable<E>> implements Visitor<E> {
	
	@Override
	/**
	 * 访问BinaryTree，定义具体访问逻辑
	 */
	public void visit(BinaryTree<E> binaryTree) {
		//访问逻辑是先序输出所有结点
	    preorder(binaryTree.getRoot());
	    System.out.println();
	}
	

	private void preorder(BinaryTreeNode<E> subRoot){
		if(subRoot!=null){
			System.out.print(subRoot.getElement()+"  ");	//访问当前结点
			preorder(subRoot.getLeft());
			preorder(subRoot.getRight());
		}
	}
}
