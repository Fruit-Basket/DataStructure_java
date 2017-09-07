package fruitbasket.search;

import java.util.Stack;

/**
 * 普通二叉排序树
 * Author: FruitBasket
 * Time: 2017年8月29日
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class BinarySortTree {
	
	private BinarySortTreeNode root=null;
	
	public BinarySortTree(){}
	
	public BinarySortTreeNode getRoot(){
		return root;
	}
	
	/**
	 * 往二叉排序树中插入一个元素
	 * @param node
	 */
	public void insertNode(BinarySortTreeNode node){
		if(root==null){
			root=new BinarySortTreeNode();
			root.key=node.key;
		}
		else{
			BinarySortTreeNode pointer=this.root;
			while(pointer!=null){
				if(node.key<pointer.key){
					if(pointer.lChild!=null){
						pointer=pointer.lChild;
					}
					else{
						pointer.lChild=new BinarySortTreeNode();
						pointer.lChild.key=node.key;
						break;
					}
				}
				else if(node.key>pointer.key){
					if(pointer.rChild!=null){
						pointer=pointer.rChild;
					}
					else{
						pointer.rChild=new BinarySortTreeNode();
						pointer.rChild.key=node.key;
						break;
					}
				}
				else{
					break;
				}
			}
		}
	}
	
	/**
	 * 从二叉排序树中删除一个元素
	 * @param key
	 */
	public void deleteNode(int key){
		BinarySortTreeNode toDelete;//指示将要被删除的元素
		BinarySortTreeNode parentNode = null,childTree=null;//指示将要被删元素的双亲和子树
		BinarySortTreeNode vanNode,vanParentNode = null;//指示被删元素的前驱、该前驱的双亲元素
		
		//1.找到要被删的元素
		toDelete=root;
		while(toDelete!=null){
			if(key==toDelete.key){
				break;    //若找到被删元素，则跳出循环
			}
			//若上面的if条件不成立，则当前的toDelete不是指向要被删的元素
			parentNode=toDelete;    
		    if(key>toDelete.key){
				toDelete=toDelete.rChild;
			}
			else{
				toDelete=toDelete.lChild;
			}
		}
		if(toDelete==null){//如果循环结束后，toDelete==null，则表明不存在被删结点
			return ;
		}

		//2.对被删结点分3种情况：被删元素有左子树和右子树、只有左子树或右子树、无子树
		if(toDelete.lChild!=null
				&&toDelete.rChild!=null){
				parentNode=toDelete;//设置parentNode以区分下面的两种情况

				//寻找被删元素的前驱及前驱的双亲，以被删元素的左孩子为起点
				vanNode=toDelete.lChild;
				while(vanNode.rChild!=null){
					vanParentNode=vanNode;
					vanNode=vanNode.rChild;
				}
				//寻找结束

				//用其前驱的信息替换被删结点的信息，故后面直接删除其前驱结点
				toDelete.key=vanNode.key;
				toDelete.otherInfo=vanNode.otherInfo;

				//将前驱vanNode的左孩子接到正确的地方
				if(vanParentNode==toDelete){
					toDelete.lChild=vanNode.lChild;
				}
				else{
					vanParentNode.rChild=vanNode.lChild;
				}
		}
		else{
			if(toDelete.lChild!=null){
				childTree=toDelete.lChild;
		    }
		    else if(toDelete.rChild!=null){
				childTree=toDelete.rChild;
			}

			//将phildTree所指的子树挂接到其双亲结点parentNode相应的位置
			if(parentNode==null){//如果要被删结点为根结点
				this.root=childTree;
			}
			else if(parentNode.lChild==toDelete){
				parentNode.lChild=childTree;
			}
			else if(parentNode.rChild==toDelete){
				parentNode.rChild=childTree;
			}
		}
	}
	
	/**
	 * 创建二叉排序树
	 * @param nodes
	 */
	public void createTree(BinarySortTreeNode[] nodes){
		if(nodes!=null&&nodes.length>0){
			for(BinarySortTreeNode e:nodes){
				insertNode(e);
			}
		}
	}
	
	/**
	 * 以中序输出二叉排序树
	 */
	public void show(){
		BinarySortTreeNode node=root;
		Stack<BinarySortTreeNode> stack=new Stack<>();
		
		while(node!=null||stack.isEmpty()==false){
			if(node!=null){
				stack.add(node);
				
				while(node.lChild!=null){
					stack.push(node.lChild);
					node=node.lChild;
				}
			}
			
			node=stack.pop();
			System.out.print(node.key);
			
			node=node.rChild;
		}
		System.out.println();
	}
}
