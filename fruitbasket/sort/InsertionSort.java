package fruitbasket.sort;

/**
 * 3�ֲ�������
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
	 * ֱ�Ӳ�������
	 * ˼�룺��δ����ģ����뵽�������������
	 * �ص㣺
	 * 1.�ȶ�����
	 * 2.�������ڳ�ʼ��¼�����������򣩵����������ʼ��¼���򣬼�¼���ϴ��ǣ����㷨ʱ�临�ӶȽϸߣ����˲���
	 * 3.Ҳ��������ʽ�洢�ṹ
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
	 * �۰��������
	 * ˼�룺��ֱ�Ӳ�������Ļ����ϣ�ʹ���۰����
	 * �ص㣺
	 * 1.�ȶ�����
	 * 2.�ʺϳ�ʼ��¼���򡢼�¼���ϴ�����
	 * @param array
	 */
	public static void BinaryInsertionSort(int[] array){
		
	}
	
	/**
	 * ϣ�������ֳơ���С��������
	 * �����ݷֳ������飬�������ڽ���ֱ�Ӳ��������ظ�����
	 * @param array
	 */
	public static void shellSort(int[] array){
		
	}
	
}
