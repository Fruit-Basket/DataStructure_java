package fruitbasket.sort;

import fruitbasket.search.SearchTest;

/**
 * 排序算法测试
 * Author: FruitBasket
 * Time: 2017年9月7日
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
		System.out.println("直接插入排序：");
		System.out.print("待排数组：");
		showArray(array);
		InsertionSort.straightInsertionSort(array);
		System.out.print("结果：");
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
