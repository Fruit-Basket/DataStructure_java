package fruitbasket.search;

/**
 *
 * Author: FruitBasket
 * Time: 2017Äê8ÔÂ28ÈÕ
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
		
	}

}
