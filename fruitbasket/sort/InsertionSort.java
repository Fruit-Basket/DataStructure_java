package fruitbasket.sort;

/**
 * ��������
 * Author: FruitBasket
 * Time: 2017��9��7��
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
	 * ֱ�Ӳ������򣺽�δ����ģ����뵽�������������
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
