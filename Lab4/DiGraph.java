//Sareh Jalalizad

//represents directed graph of vertices


public class DiGraph {
	
	private final int V;        // number of vertices in direct graph
	private int E;              // number of edges
	private Bag<Integer>[] adj; // adjacency lists
	
	
	@SuppressWarnings("unchecked")
	
	//Initializes an empty graph with vertices.
    // V the number of vertices
	public DiGraph(int V)
	{
		 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		 this.V = V; 
		 this.E = 0;
		
		adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
		
		for (int v = 0; v < V; v++) // Initialize all lists
		
			adj[v] = new Bag<Integer>(); // to empty.
	}
	
	
	
	//Initializes a direct graph from the specified input stream.
	public DiGraph(In in)
	{
		this(in.readInt()); // Read V and construct this graph.
		if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
		
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
	
	
	// adds the direct edge w to v to direct graph
	public void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v’s list.
		E++;
	}
	
	
	//implements an iterator
	//Returns the vertices adjacent to vertex
	public Iterable<Integer> adj(int v)
	{
		return adj[v]; 
	}
	
	
     //return the reverse of the digraph
	  public DiGraph reverse() {		 
		  DiGraph reverse = new DiGraph(V);
	      for (int v = 0; v < V; v++) {
			        
	    	  for (int w : adj(v)) {
			  
	    		  reverse.addEdge(w, v);
	      }
	  }
			        return reverse;
   }
	
	
	//String representation of this graph
	//Returns a string representation of this graph.
	public String toString(SyGrDFDirectPath d)
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

	public String toString(SyGrBFDirectPath b)
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
