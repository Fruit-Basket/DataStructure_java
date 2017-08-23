package fruitbasket.tree.visitor;

/**
 * 构建一颗二叉查找树
 *
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>>
	extends AbstractTree<E>{
	
	protected BinaryTreeNode<E> root;
	protected int size=0;
	
	public BinaryTree(){}
	
	public BinaryTree(E[] elements){
		for(int i=0;i<elements.length;i++){
			insert(elements[i]);
		}
	}

	@Override
	public boolean insert(E element) {
		if(root==null){
			root=createNewNode(element);
		}
		else{
			BinaryTreeNode<E> parent=null;
			BinaryTreeNode<E> current=root;
			while(current!=null){
				//如果将要插入的元素小于当前的元素
				if(element.compareTo(current.getElement())<0){
					parent=current;
					current=current.getLeft();
				}
				//如果将要插入的元素大于当前的元素
				else if(element.compareTo(current.getElement())>0){
					parent=current;
					current=current.getRight();
				}
				else{
					return false;	//不允许插入值相同的元素
				}
			}
			
			if(element.compareTo(parent.getElement())<0){
				parent.setLeft(createNewNode(element));
			}
			else{
				parent.setRight(createNewNode(element));
			}
		}
		size++;
		return true;
	}

	@Override
	public boolean delete(E element) {
		BinaryTreeNode<E> parent=null;
		BinaryTreeNode<E> current=root;
		while(current!=null){
			if(element.compareTo(current.getElement())<0){
				parent=current;
				current=current.getLeft();
			}
			else if(element.compareTo(current.getElement())>0){
				parent=current;
				current=current.getRight();
			}
			else{
				break; 	//current指向了将要删除的结点
			}
		}
		
		if(current==null){
			return false;
		}
		//第一种情况：current结点没有左子树
		if(current.getLeft()==null){
			//如果parent==null，则二叉树的根结点无左子树
			if(parent==null){
				root=current.getRight();
			}
			else{
				if(element.compareTo(parent.getElement())<0)
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getLeft());
			}
		}
		//第二种情况：current结点有左子树
		else{
			BinaryTreeNode<E> parentOfRightMost=current;
			BinaryTreeNode<E> rightMost=current.getLeft();
			
			while(rightMost.getRight()!=null){
				parentOfRightMost=rightMost;
				rightMost=rightMost.getRight();
			}
			
			current.setElement(rightMost.getElement());
			
			if(parentOfRightMost.getElement()==rightMost)
				parentOfRightMost.setRight(rightMost.getLeft());
			else
				parentOfRightMost.setLeft(rightMost.getLeft());
		}
		size--;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void accpet(Visitor<E> visitor) {
		visitor.visit(this);
	}

	public BinaryTreeNode<E> getRoot(){
		return root;
	}
	
	private BinaryTreeNode<E> createNewNode(E element) {
		return new BinaryTreeNode<E>(element);
	}
	
	public void clear(){
		root=null;
		size=0;
	}
}
