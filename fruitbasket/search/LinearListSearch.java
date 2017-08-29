package fruitbasket.search;

/**
* һ���˳�����
* Author: FruitBasket
* Time: 2017/8/28
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/
public class LinearListSearch {
	
	private static final LinearListSearch instance=new LinearListSearch();
	private LinearListSearch(){}
	
	public static LinearListSearch getInstance(){
		return instance;
	}
	
	/**
	 * ˳�����
	 * @param table
	 * @param key
	 * @return
	 */
	public static int sequentialSearch(LinearListElement[] elements,int key){
		if(elements!=null){
			for(int i=0;i<elements.length;++i){
				if(key==elements[i].key){
					return i;
				}
			}
			return -1;
		}
		else{
			return -1;
		}
	}
	
	/**
	 * ���ֲ���
	 * @param elements
	 * @param key
	 * @return
	 */
	public static int binarySearch(LinearListElement[] elements,int key){
		int low=0;
		int high=elements.length-1;
		int middle;
		
		while(low<=high){
			middle=(low+high)/2;
			if(key>elements[middle].key){
				low=middle+1;
			}
			else if(key<elements[middle].key){
				high=middle-1;
			}
			else{
				return middle;
			}
		}
		return -1;
	}


}
