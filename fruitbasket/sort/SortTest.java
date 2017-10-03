package fruitbasket.sort;

import fruitbasket.search.SearchTest;

/**
 * �����㷨����
 * Author: FruitBasket
 * Time: 2017��9��7��
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class SortTest {
	private static final SortTest instance=new SortTest();
	private SortTest(){}
	
	public SortTest getInstance(){
		return instance;
	}
	
	public static void testStrightInsertionSort(){
		int[] array={2,1,3,5,7,0,9,8,6,4};
		System.out.println("ֱ�Ӳ�������");
		System.out.print("�������飺");
		showArray(array);
		InsertionSort.straightInsertionSort(array);
		System.out.print("�����");
		showArray(array);
	}
	
	private static void showArray(int[] array){
		if(array!=null&&array.length>0){
			System.out.print("[ ");
			for(int i=0;i<array.length;++i){
				System.out.print(array[i]+" ");
			}
			System.out.println("]");
		}
	}
}
