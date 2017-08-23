package fruitbasket.tree.visitor;

/**
 * ����Ԫ��
 * @param <E>
 */
public abstract class AbstractTree<E extends Comparable<E>> 
	implements Tree<E>{
	
	@Override
	public boolean isEmpty(){
		return getSize()==0;
	}
	
	/**
	 * ����˭�����ʱ���
	 * @param visitor ָ���ĸ�������Է��ʱ���
	 */
	public abstract void accpet(Visitor<E> visitor);
}
