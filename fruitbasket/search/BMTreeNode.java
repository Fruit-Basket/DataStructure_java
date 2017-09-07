package fruitbasket.search;

/**
 * B-树结点
 * Author: FruitBasket
 * Time: 2017年9月1日
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class BMTreeNode {
	public static final int order=3;//阶数
	
	public int keyNum;//结点中关键字个数
	public BMTreeNode parent;//指向双亲结点
	public int[] keys;//关键字
	public BMTreeNode[] childs;//指向子树
}
