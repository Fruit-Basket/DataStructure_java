package fruitbasket.tree;

/**
 * ���������������
 * @param <E>
 */
public class BTPreOrderIterator<E extends Comparable<E>>
	implements Iterator<E> {
	
	private BinaryTreeNode<E> root;
	private Stack<BinaryTreeNode<E>> stack;
	private Stack<BinaryTreeNode<E>> readStack;	//������������У����һ�εĽ�������ǰ�Ľ��
	private BinaryTreeNode<E> topNode;
	private int size;	//��¼���������ĸ���
	
	public BTPreOrderIterator(BinaryTreeNode<E> root,int size){
		this.root=root;
		this.size=size;
	    stack=new Stack<BinaryTreeNode<E>>(size);
	    readStack=new Stack<BinaryTreeNode<E>>(size);
	    stack.push(root);
	}
	
	@Override
	public boolean hasNext() {
		if(stack.isEmpty()==false)		//���ջ�գ������ѱ�����
			return true;
		else
			return false;
	}

	@Override
	/**
	 * ������ı����ķ�ʽ�𲽷���ÿһ�����
	 */
	public BinaryTreeNode<E> next() {
		if(stack.isEmpty()==false){
			topNode=stack.pop();
			if(topNode.getRight()!=null){
				stack.push(topNode.getRight());
			}
			if(topNode.getLeft()!=null){
				stack.push(topNode.getLeft());
			}
			//���ʽ��
			readStack.push(topNode);
			return topNode;
		}
		return null;
	}
	
	/**
	 * ����ָ��λ�õĽ��
	 * @param offset ָ������ڵ�ǰ������һ������λ�á�
	 * @return
	 */
	public BinaryTreeNode<E> visit(int offset){
		/**
		 * ���ʼ�¼ջ��ջ��Ԫ������󱻷��ʵ�Ԫ��
		 * ����ƫ��ʱ������󱻷��ʵ�Ԫ�ػ�׼
		 */
		int current=readStack.getSize()-1;	//ջ�е�ǰ�����-1����Ϊ��ǰ��󱻷��ʵĽ�����ţ������0��ʼ����
		//System.out.println("current=="+current);
		//System.out.println("readStack.getSize()=="+readStack.getSize());
		//�ж�ƫ�����Ƿ�Ϸ�
		if(offset==0){
			//System.out.println("offset==0");
			//�˴����轫topNodeѹ��readStack
			return topNode;
		}
		else if(offset>0&&
				offset<(size-current)){
			//System.out.println("offset>0");
			while(stack.isEmpty()==false&&(offset--)>0){
				//System.out.println("while");
				topNode=stack.pop();
				if(topNode.getRight()!=null){
					stack.push(topNode.getRight());
				}
				if(topNode.getLeft()!=null){
					stack.push(topNode.getLeft());
				}
				//���ʽ��
				readStack.push(topNode);
			}
			return topNode;
		}
		else if(offset<0&&
				offset>=(-current)){
			//System.out.println("offset<0");
			while(readStack.isEmpty()==false&&(offset++)<0){
				//System.out.println("while");
				topNode=readStack.pop();
				if(topNode.getRight()!=null){
					stack.pop();
				}
				if(topNode.getLeft()!=null){
					stack.pop();
				}
				stack.push(topNode);
			}
			//return topNode; //�����Ϊһ�ִ��������������
			return topNode=readStack.peek();
		}
		else{
			//System.out.println("return null");
			return null;
		}
	}
	
	public void reset(){
		stack.clear();
		readStack.clear();
		stack.push(root);
	}
	
	
	//����Ĵ���
	//ʹ���˵ݹ�ķ���
	/*private void preorder(){
		preorder(root);
	}
	
	private void preorder(BinaryTreeNode<E> subRoot){
		if(subRoot!=null){
			//���ʵ�ǰ���
			preorder(subRoot.getLeft());
			preorder(subRoot.getRight());
		}
	}*/
	
}
