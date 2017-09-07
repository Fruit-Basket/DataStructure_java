package fruitbasket.search;

import java.util.Stack;

/**
 * ��ͨ����������
 * Author: FruitBasket
 * Time: 2017��8��29��
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
	 * �������������в���һ��Ԫ��
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
	 * �Ӷ�����������ɾ��һ��Ԫ��
	 * @param key
	 */
	public void deleteNode(int key){
		BinarySortTreeNode toDelete;//ָʾ��Ҫ��ɾ����Ԫ��
		BinarySortTreeNode parentNode = null,childTree=null;//ָʾ��Ҫ��ɾԪ�ص�˫�׺�����
		BinarySortTreeNode vanNode,vanParentNode = null;//ָʾ��ɾԪ�ص�ǰ������ǰ����˫��Ԫ��
		
		//1.�ҵ�Ҫ��ɾ��Ԫ��
		toDelete=root;
		while(toDelete!=null){
			if(key==toDelete.key){
				break;    //���ҵ���ɾԪ�أ�������ѭ��
			}
			//�������if��������������ǰ��toDelete����ָ��Ҫ��ɾ��Ԫ��
			parentNode=toDelete;    
		    if(key>toDelete.key){
				toDelete=toDelete.rChild;
			}
			else{
				toDelete=toDelete.lChild;
			}
		}
		if(toDelete==null){//���ѭ��������toDelete==null������������ڱ�ɾ���
			return ;
		}

		//2.�Ա�ɾ����3���������ɾԪ��������������������ֻ������������������������
		if(toDelete.lChild!=null
				&&toDelete.rChild!=null){
				parentNode=toDelete;//����parentNode������������������

				//Ѱ�ұ�ɾԪ�ص�ǰ����ǰ����˫�ף��Ա�ɾԪ�ص�����Ϊ���
				vanNode=toDelete.lChild;
				while(vanNode.rChild!=null){
					vanParentNode=vanNode;
					vanNode=vanNode.rChild;
				}
				//Ѱ�ҽ���

				//����ǰ������Ϣ�滻��ɾ������Ϣ���ʺ���ֱ��ɾ����ǰ�����
				toDelete.key=vanNode.key;
				toDelete.otherInfo=vanNode.otherInfo;

				//��ǰ��vanNode�����ӽӵ���ȷ�ĵط�
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

			//��phildTree��ָ�������ҽӵ���˫�׽��parentNode��Ӧ��λ��
			if(parentNode==null){//���Ҫ��ɾ���Ϊ�����
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
	 * ��������������
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
	 * �������������������
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
