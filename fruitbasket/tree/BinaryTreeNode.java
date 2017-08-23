package fruitbasket.tree;

public class BinaryTreeNode<E extends Comparable<E>> implements TreeNode<E> {
	private E element;
	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;
	
	public BinaryTreeNode(E element){
		this.element=element;
	}
	
	public void setElement(E element){
		this.element=element;
	}
	
	public E getElement(){
		return element;
	}
	
	public void setLeft(BinaryTreeNode<E> left){
		this.left=left;
	}
	
	public BinaryTreeNode<E> getLeft(){
		return left;
	}
	
	public void setRight(BinaryTreeNode<E> right){
		this.right=right;
	}
	
	public BinaryTreeNode<E> getRight(){
		return right;
	}
}
