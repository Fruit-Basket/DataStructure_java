package fruitbasket.graph;

/**
* 图接口
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/
public interface Graph<V> {
	/**Return the number of vertices in the graph*/
	public int getSize();
	
	/**Return the vertices in the graph*/
	public java.util.List<V> getVertices();
	
	/**Return the object for the specified vertex index*/
	public V getIndex(int index);
	
	/**Return the index for the specified vertex object*/
	public int getVertex(V v);
	
	/**Return the neighbors of vertex with the specified index（返回指定定点的邻接点数组）*/
	public java.util.List<Integer> getNeighbors(int index);
	
	/**Return the degree for a specified vertex*/
	public int getDegree(int v);
	
	/**Return the adjacency matrix*/
	public int[][] getAdjacencyMatrix();
	
	/**Print the adjacency matrix*/
	public void printAdjacendyMatrix();
	
	/**Print the edges*/
	public void printEdges();
}
	
