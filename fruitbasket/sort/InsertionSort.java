package fruitbasket.sort;

/**
 * 插入排序
 * Author: FruitBasket
 * Time: 2017年9月7日
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class InsertionSort {

	private static final InsertionSort instance=new InsertionSort();
	
	private InsertionSort(){}
	
	public static InsertionSort getInstance(){
		return instance;
	}
	
	/**
	 * 直接插入排序：将未排序的，插入到已排序的数列中
	 * @param array
	 */
	public static void straightInsertionSort(int[] array){
		if(array!=null&&array.length>0){
			int temp;
			int i,j;
			for(i=1;i<array.length;++i){
				if(array[i]<array[i-1]){
					temp=array[i];
					
					array[i]=array[i-1];
					for(j=i-1;j>0&&array[j]>temp;--j){
						array[j]=array[j-1];
					}
					array[j]=temp;
				}
			}
		}
	}
	
	
	
}
