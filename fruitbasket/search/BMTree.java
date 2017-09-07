package fruitbasket.search;

/**
 *
 * Author: FruitBasket
 * Time: 2017年9月1日
 * Email: FruitBasket@qq.com
 * GitHub: github.com/Fruit-Basket
 */
public class BMTree {
	private BMTreeNode root=null;
	
	public BMTree(){}
	
	public BMTreeNode getRoot(){
		return root;
	}
	
	public SearchResult searchBMTree(int key){
		SearchResult searchResult=new SearchResult();
		boolean found=false;
		BMTreeNode node,nodePreant=null;
		node=this.root;
		int i=0;
		
		while(node!=null&&found==false){
			i=search(node,key);
			if(i>0&&node.keys[i]==key){
				found=true;
			}
			else{
				nodePreant=node;
				node=node.childs[i];
			}
		}
		if(found){
			searchResult.node=node;
			searchResult.i=i;
			searchResult.result=true;
			return searchResult;
		}
		else{
			searchResult.node=nodePreant;
			searchResult.i=i;
			searchResult.result=false;
			return searchResult;
		}
	}
	
	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private int search(BMTreeNode node,int key){
		if(node!=null){
			if(key<node.keys[0]){
				return 0;
			}
			else if(key>=node.keys[node.keys.length-1]){
				return node.keys.length;
			}
			else{
				for(int i=0;i<node.keys.length-1;++i){
					if(node.keys[i]<=key&&key<node.keys[i+1]){
						return i;
					}
				}
				return -1;
			}
		}
		else{
			return -1;
		}
	}
	
	public class SearchResult{
		public boolean result;//查找是否成功
		public BMTreeNode node;//指找到的结点
		public int i;//在结点中的关键字下标
	}
}
