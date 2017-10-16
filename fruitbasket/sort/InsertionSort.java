package fruitbasket.sort;

/**
 * 3种插入排序
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
	 * 直接插入排序
	 * 思想：将未排序的，插入到已排序的数列中
	 * 特点：
	 * 1.稳定排序
	 * 2.更适用于初始记录基本有序（正序）的情况；当初始记录无序，记录量较大是，此算法时间复杂度较高，不宜采用
	 * 3.也适用于链式存储结构
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
	
	/**
	 * 折半插入排序
	 * 思想：在直接插入排序的基础上，使用折半查找
	 * 特点：
	 * 1.稳定排序
	 * 2.适合初始记录无序、记录量较大的情况
	 * @param array
	 */
	public static void BinaryInsertionSort(int[] array){
		
	}
	
	/**
	 * 希尔排序，又称“缩小增量排序”
	 * 将数据分成若干组，再在组内进行直接插入排序，重复进行
	 * @param array
	 */
	public static void shellSort(int[] array){
		
	}
	
}
