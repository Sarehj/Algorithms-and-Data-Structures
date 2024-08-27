//Sareh Jalalizad

//weighted edge in an EdgeWeightedGraph. Each edge consists of 2 integers (vertices)
//and a weight.


public class Edge implements Comparable<Edge> {
	
	private final int v;    //vertex
	private final int w;    //other vertex
	private final double weight;

	
	//Initializes an edge between vertices and w of
    //the given weight
	public Edge(int V, int W, double weight) {
		this.v = V;
		this.w = W;
		this.weight = weight;
	} 
	
	
   //Returns the weight of this edge.
	public double weight() {
		return weight;
	}
	
	
   //Returns either end point of this edge.
	public int either() {
		return v;
	}
	
	
   //return the other vertex that is connected to speicifed vertex.
	public int other(int inputVertex) {
	
		if(inputVertex == v)
			return w;
		
		else if(inputVertex == w)
			return v;
		
		else throw new RuntimeException("Inconsistent edge");
	}
	
	
   //Compares two edges by weight.
	public int compareTo (Edge that) {
		
		if(this.weight() < that.weight()) //the weight of this is less than argument edge
			
			return -1;
		
		else if (this.weight() > that.weight()) //the weight of this is greater than argument edge
			
			return +1;
	
		else
			return 0;   //the weight of this is equal than argument edge
	}
	
	
   //Returns a string representation of this edge.
	public String toString() {
		
		return String.format("%d-%d %.2f", v, w, weight);
	}
}
