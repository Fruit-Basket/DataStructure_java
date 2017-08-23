package fruitbasket.tree;

/**
 * 二叉树先序迭代器
 * @param <E>
 */
public class BTPreOrderIterator<E extends Comparable<E>>
	implements Iterator<E> {
	
	private BinaryTreeNode<E> root;
	private Stack<BinaryTreeNode<E>> stack;
	private Stack<BinaryTreeNode<E>> readStack;	//存放先序序列中，最后一次的结点和其面前的结点
	private BinaryTreeNode<E> topNode;
	private int size;	//记录二叉树结点的个数
	
	public BTPreOrderIterator(BinaryTreeNode<E> root,int size){
		this.root=root;
		this.size=size;
	    stack=new Stack<BinaryTreeNode<E>>(size);
	    readStack=new Stack<BinaryTreeNode<E>>(size);
	    stack.push(root);
	}
	
	@Override
	public boolean hasNext() {
		if(stack.isEmpty()==false)		//如果栈空，则树已遍历完
			return true;
		else
			return false;
	}

	@Override
	/**
	 * 以先序的遍历的方式逐步访问每一个结点
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
			//访问结点
			readStack.push(topNode);
			return topNode;
		}
		return null;
	}
	
	/**
	 * 访问指定位置的结点
	 * @param offset 指定相对于当前结点的下一个结点的位置。
	 * @return
	 */
	public BinaryTreeNode<E> visit(int offset){
		/**
		 * 访问记录栈的栈顶元素是最后被访问的元素
		 * 计算偏移时，以最后被访问的元素基准
		 */
		int current=readStack.getSize()-1;	//栈中当前结点数-1，作为当前最后被访问的结点的序号，序号由0开始算起
		//System.out.println("current=="+current);
		//System.out.println("readStack.getSize()=="+readStack.getSize());
		//判断偏移量是否合法
		if(offset==0){
			//System.out.println("offset==0");
			//此处无需将topNode压入readStack
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
				//访问结点
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
			//return topNode; //此语句为一种错误情况，已修正
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
	
	
	//错误的代码
	//使用了递归的方法
	/*private void preorder(){
		preorder(root);
	}
	
	private void preorder(BinaryTreeNode<E> subRoot){
		if(subRoot!=null){
			//访问当前结点
			preorder(subRoot.getLeft());
			preorder(subRoot.getRight());
		}
	}*/
	
}
