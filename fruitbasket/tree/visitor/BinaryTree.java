package fruitbasket.tree.visitor;

/**
 * ����һ�Ŷ��������
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
				//�����Ҫ�����Ԫ��С�ڵ�ǰ��Ԫ��
				if(element.compareTo(current.getElement())<0){
					parent=current;
					current=current.getLeft();
				}
				//�����Ҫ�����Ԫ�ش��ڵ�ǰ��Ԫ��
				else if(element.compareTo(current.getElement())>0){
					parent=current;
					current=current.getRight();
				}
				else{
					return false;	//���������ֵ��ͬ��Ԫ��
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
				break; 	//currentָ���˽�Ҫɾ���Ľ��
			}
		}
		
		if(current==null){
			return false;
		}
		//��һ�������current���û��������
		if(current.getLeft()==null){
			//���parent==null����������ĸ������������
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
		//�ڶ��������current�����������
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
