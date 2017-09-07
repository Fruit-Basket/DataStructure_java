package fruitbasket.search;

/**
 * 查找算法测试
 * Author: FruitBasket
 * Time: 2017年8月28日
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class SearchTest {
	private static final SearchTest instance=new SearchTest();
	private SearchTest(){}
	
	public SearchTest getInstance(){
		return instance;
	}
	
	public static void testSequentialSearch(){
		LinearListElement[] elements=new LinearListElement[10];
		for(int i=0;i<elements.length;++i){
			elements[i]=new LinearListElement();
			elements[i].key=i;
		}
		
		int index=LinearListSearch.sequentialSearch(elements,1);
		System.out.println(index);

	}
	
	public static void testBinarySearch(){
		System.out.println("testBinarySearch()");
		LinearListElement[] elements=new LinearListElement[10];
		for(int i=0;i<elements.length;++i){
			elements[i]=new LinearListElement();
			elements[i].key=i;
		}
		
		System.out.print("elements key: ");
		for(int i=0;i<elements.length;++i){
			System.out.print(elements[i].key);
		}
		System.out.println();
		
		int index;
		System.out.print("search result: ");
		for(int i=-1;i<=elements.length;++i){
			index=LinearListSearch.binarySearch(elements,i);
			System.out.print(index);
		}
		//System.out.println(elements[index].otherInfo);
	}
	
	public static void testBinarySortTree(){
		BinarySortTreeNode[] nodes=new BinarySortTreeNode[10];
		for(int i=0;i<nodes.length;++i){
			nodes[i]=new BinarySortTreeNode();
			nodes[i].key=i;
		}
		
		BinarySortTree tree=new BinarySortTree();
		tree.createTree(nodes);
		tree.show();
		
		int key=-1;
		System.out.print("delete "+key+": ");
		tree.deleteNode(key);
		tree.show();
		
		key=10;
		System.out.print("delete "+key+": ");
		tree.deleteNode(key);
		tree.show();
		
		key=5;
		System.out.print("delete "+key+": ");
		tree.deleteNode(key);
		tree.show();
		
		for(int i=0;i<nodes.length;++i){
			key=i;
			System.out.print("delete "+key+": ");
			tree.deleteNode(key);
			tree.show();
		}
	}

}
