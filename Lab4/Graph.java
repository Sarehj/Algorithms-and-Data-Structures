//Sareh Jalalizad

//represents undirected graph of vertices


public class Graph {
	
	private final int V;        // number of vertices
	private int E;              // number of edges
	private Bag<Integer>[] adj; // adjacency lists
	
	
	@SuppressWarnings("unchecked")
	
	//Initializes an empty graph with vertices and 0 edges.
    // V the number of vertices
	public Graph(int V)
	{
		 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		 this.V = V; 
		 this.E = 0;
		
		adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
		
		for (int v = 0; v < V; v++) // Initialize all lists
		
			adj[v] = new Bag<Integer>(); // to empty.
	}
	
	
	
	//Initializes a graph from the specified input stream.
	public Graph(In in)
	{
		this(in.readInt()); // Read V and construct this graph.
		int E = in.readInt(); // Read E.
		
		// Add an edge.
		for (int i = 0; i < E; i++)
		{ 
			int v = in.readInt(); // Read a vertex,
			int w = in.readInt(); // read another vertex,
			addEdge(v, w);        // and add edge connecting them.
		}
	}
	

	
	//Returns the number of vertices in the graph.
	public int V() {
		return V;
	}
	
	//Returns the number of edges in the graph.
	public int E() { 
		return E;
	}
	
	
	// adds an edge between nodes
	public void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}
	
	
	//implements an iterator
	//Returns the vertices adjacent to vertex
	public Iterable<Integer> adj(int v)
	{
		return adj[v]; 
	}
	
	
	//String representation of this graph
	//Returns a string representation of this graph.
	public String toString(SymbolGraphDFS d)
	{
		String s = V + " vertices, " + E + " edges\n";
	
		for (int v = 0; v < V; v++)
		{
			s += d.name(v) + ": ";
			
			for (int w : this.adj(v)) {
				
				s += d.name(w) + " "; 
			}
			s += "\n";
		}
		return s;
	}

	public String toString(SymbolGraphBFS b)
	{
		String s = V + " vertices, " + E + " edges\n";
	
		for (int v = 0; v < V; v++)
		{
			s += b.name(v) + ": ";
			
			for (int w : this.adj(v)) {
				
				s += b.name(w) + " "; 
			}
			s += "\n";
		}
		return s;
	}

}
