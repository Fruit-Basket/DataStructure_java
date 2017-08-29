package fruitbasket.search;

/**
 * ��ͨ����������
 * Author: FruitBasket
 * Time: 2017��8��29��
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class BinarySortTree {
	
	private static final BinarySortTree instance=new BinarySortTree();
	private BinarySortTree(){}
	
	public static BinarySortTree getInstance(){
		return instance;
	}
	
	/**
	 * ������������������
	 * @param tree
	 * @param element
	 */
	public static void insertElement(BinarySortTreeElement tree,BinarySortTreeElement element){
		if(element!=null){
			if(tree==null){
					tree=new BinarySortTreeElement();
					tree.key=element.key;
			}
			else{
				if(element.key>tree.key){
					insertElement(tree.rChild,element);
				}
				else if(element.key<tree.key){
					insertElement(tree.lChild,element);
				}
			}
		}
	}
	
	public static void createTree(BinarySortTreeElement tree,BinarySortTreeElement[] elements){
		if(elements!=null&&elements.length>0){
			for(BinarySortTreeElement e:elements){
				
			}
		}
	}
}
